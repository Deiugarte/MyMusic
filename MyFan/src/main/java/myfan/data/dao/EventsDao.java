package myfan.data.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import myfan.data.models.Events;
import myfan.data.models.FanaticsArtists;
import myfan.data.models.News;
import myfan.data.models.Events;
import myfan.resources.util.HibernateUtil;

public class EventsDao extends EventsHome {

  private static final Log log = LogFactory.getLog(EventsDao.class);
  private final SessionFactory sessionFactory = getSessionFactory();

  @Override
  public SessionFactory getSessionFactory(){
      try {
          return (SessionFactory) HibernateUtil.getSessionFactory();
      } catch (Exception e) {
          log.error("Could not locate SessionFactory in JNDI", e);
          throw new IllegalStateException("Could not locate SessionFactory in JNDI");
      }
  }
  
  public void save(Events Events){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Events);
      trans.commit();
  }

  public Events getEventsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Events instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteEvents(Events Events) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Events);
      trans.commit();
  }
  
  public List<Events> getEventsByArtistId(int artistId,int offset) {
	    try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from Events where artist = :artistId  order by creationDate DESC");
	        query.setParameter("artistId", artistId);
	        query.setFirstResult(offset*20);
	        query.setMaxResults(20);
	        //java.util.List results = query.list();
	        java.util.List <Events> results= session.createCriteria(Events.class).list();
	        for(int i=0; i< results.size();i++){
	        	   Hibernate.initialize(results.get(i));  
	        }
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
	}
public List<Events> getEventsByArtistsList(List<FanaticsArtists> fanaticsArtistsList, int offset ) {
	    try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        String queryStr= "from Events where (%s)  order by creationDate DESC ";
	        queryStr= String.format(queryStr,getQueryWithArtistsList(fanaticsArtistsList) );
	        Query query = session.createQuery(queryStr);
	        query.setFirstResult(20*offset);
	        query.setMaxResults(20);
	        //java.util.List results = query.list();
	        java.util.List <Events> results= session.createCriteria(Events.class).list();
	        for(int i=0; i< results.size();i++){
	        	   Hibernate.initialize(results.get(i));  
	        }
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
	}

private String getQueryWithArtistsList(List<FanaticsArtists> fanaticsArtistsList) {
		String query = " artist = %s ";
		String queryResult = "";
		for (int i = 0; i < fanaticsArtistsList.size(); i++) {
			queryResult += String.format(query, fanaticsArtistsList.get(i).getArtists().getArtistId());
			if (i == fanaticsArtistsList.size() - 1) {
				break;
			}
			else{
				queryResult+="or ";
			}
		}
		return queryResult;
	}
}
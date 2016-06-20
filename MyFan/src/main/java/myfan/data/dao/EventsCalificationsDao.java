package myfan.data.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import myfan.comunicacion.comunicacion.resources.HibernateUtil;
import myfan.data.models.Artists;
import myfan.data.models.EventsCalifications;

public class EventsCalificationsDao extends EventsCalificationsHome {

  private static final Log log = LogFactory.getLog(EventsCalificationsDao.class);
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
  
  public void save(EventsCalifications EventsCalifications){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(EventsCalifications);
      trans.commit();
  }

  public EventsCalifications getEventsCalificationsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      EventsCalifications instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteEventsCalifications(EventsCalifications EventsCalifications) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(EventsCalifications);
      trans.commit();
  }
  
  public List<EventsCalifications> getCalificationByConcert(int idEvent) {
	    try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from EventsCalifications where event = :idEvent");
	        query.setParameter("idEvent", idEvent);
	        java.util.List<EventsCalifications> results = query.list();
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
	}
}
package myfan.data.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import myfan.data.models.FanaticsArtists;
import myfan.data.models.UsersGenres;
import myfan.resources.util.HibernateUtil;

public class FanaticsArtistsDao extends FanaticsArtistsHome {

  private static final Log log = LogFactory.getLog(FanaticsArtistsDao.class);
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
  
  public void save(FanaticsArtists Events){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Events);
      trans.commit();
  }
  public List<FanaticsArtists> findArtistsByFanaticId(int idFanatic) {
	    try {
	        Session session = sessionFactory.getCurrentSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	       
	        Query query = session.createQuery("from FanaticsArtists where fanaticid = :idFanatic");
	        query.setParameter("idFanatic", idFanatic); 
	        
	      //  java.util.List <UsersGenres> results = query.list();
	        java.util.List <FanaticsArtists> results= session.createCriteria(FanaticsArtists.class).list();
	        for(int i=0; i< results.size();i++){
	        	   Hibernate.initialize(results.get(i));  
	        }
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
	}

  
  public void deleteEvents(FanaticsArtists fanaticsArtists) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(fanaticsArtists);
      trans.commit();
  }
}
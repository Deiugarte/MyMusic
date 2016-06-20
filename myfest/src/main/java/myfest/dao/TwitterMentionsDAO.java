package myfest.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import myfest.models.Twittermentions;
import myfest.utils.HibernateUtil;


public class TwitterMentionsDAO extends TwittermentionsHome {

  private static final Log log = LogFactory.getLog(TwitterMentionsDAO.class);
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
  
  public void save(Twittermentions Twittermentions){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Twittermentions);
      trans.commit();
  }
  
  public List<Twittermentions> getTwitterMentionsByID(int artistID){
	  try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from Twittermentions where artistId = :artistID");
	        query.setParameter("artistID", artistID);
	        java.util.List results = query.list();
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
  }

  public Twittermentions getArtistsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Twittermentions instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteArtists(Twittermentions Twittermentions) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Twittermentions);
      trans.commit();
  }
}
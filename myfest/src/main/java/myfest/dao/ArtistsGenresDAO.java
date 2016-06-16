package myfest.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import myfest.models.Artistsgenres;
import myfest.models.ArtistsgenresId;
import myfest.utils.HibernateUtil;


public class ArtistsGenresDAO extends ArtistsgenresHome {

  private static final Log log = LogFactory.getLog(ArtistsGenresDAO.class);
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
  
  public List<Artistsgenres> getArtistId(String id){
	  String idQuery = "FROM Artistsgenres WHERE gendeId = " + id;
	  try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery(idQuery);
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
  
  public void save(Artistsgenres Artists){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Artists);
      trans.commit();
  }

  public Artistsgenres getArtistsById(ArtistsgenresId id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Artistsgenres instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteArtists(Artistsgenres Artists) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Artists);
      trans.commit();
  }
}
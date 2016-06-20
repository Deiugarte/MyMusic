package myfan.data.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import myfan.comunicacion.comunicacion.resources.HibernateUtil;
import myfan.data.models.ArtistsCalifications;
import myfan.data.models.Fanatics;

public class ArtistsCalificationsDao extends ArtistsCalificationsHome {

  private static final Log log = LogFactory.getLog(ArtistsCalificationsDao.class);
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
  
  public void save(ArtistsCalifications ArtistsCalifications){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(ArtistsCalifications);
      trans.commit();
  }

  public ArtistsCalifications getArtistsCalificationsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      ArtistsCalifications instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteArtistsCalifications(ArtistsCalifications ArtistsCalifications) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(ArtistsCalifications);
      trans.commit();
  }
  
  public List<ArtistsCalifications> getArtistCalificationByIdArtist(int idArtist) {
	    try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from ArtistsCalifications where artist = :idArtist");
	        query.setParameter("idArtist", idArtist);
	        java.util.List<ArtistsCalifications> results = query.list();
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
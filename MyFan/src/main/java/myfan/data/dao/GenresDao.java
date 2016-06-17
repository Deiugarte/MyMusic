package myfan.data.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import myfan.data.models.Genres;
import myfan.data.models.Ubications;
import myfan.resources.util.HibernateUtil;

public class GenresDao extends GenresHome {

  private static final Log log = LogFactory.getLog(GenresDao.class);
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
  
  public void save(Genres Genres){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Genres);
      trans.commit();
  }

  public Genres getGenresById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Genres instance = findById(id);
      trans.commit();
      return instance;
  }
  
  public Genres findByName(String genderName) {
	    try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from Genres where name = :genderName");
	        query.setParameter("genderName", genderName);
	        java.util.List results = query.list();
	        System.out.println("Result list: " + results.size());
	        Genres instance = (results != null && results.size() == 1) ? (Genres) results.get(0) : null;
	        trans.commit();
	        log.debug("get successful, instance found");
	        return instance;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
	}
  
  
  public List<Genres> findAll() {
    try {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction trans= session.beginTransaction();
        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
            log.debug(" >>> Transaction close.");
        Query query = session.createQuery("from Genres ");
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

  public void deleteGenres(Genres Genres) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Genres);
      trans.commit();
  }
}
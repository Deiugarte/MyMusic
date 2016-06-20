package myfan.data.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import myfan.comunicacion.comunicacion.resources.HibernateUtil;
import myfan.data.models.Ubications;
import myfan.data.models.Users;

public class UbicationsDao extends UbicationsHome {

  private static final Log log = LogFactory.getLog(UbicationsDao.class);
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
  
  public void save(Ubications Ubications){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Ubications);
      trans.commit();
  }

  public Ubications getUbicationsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Ubications instance = findById(id);
      trans.commit();
      return instance;
  }
  
  public Ubications findByName(String nameUbication) {
	    try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from Ubications where name = :nameUbication");
	        query.setParameter("nameUbication", nameUbication);
	        java.util.List results = query.list();
	        System.out.println("Result list: " + results.size());
	        Ubications instance = (results != null && results.size() == 1) ? (Ubications) results.get(0) : null;
	        trans.commit();
	        log.debug("get successful, instance found");
	        return instance;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
	}
  
  public List<Ubications> findAll() {
	    try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from Ubications ");
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

  public void deleteUbications(Ubications Ubications) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Ubications);
      trans.commit();
  }
}
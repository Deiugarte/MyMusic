package myfan.data.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import myfan.data.models.DiscsCalifications;
import myfan.data.models.Fanatics;
import myfan.resources.util.HibernateUtil;

public class DiscsCalificationsDao extends DiscsCalificationsHome {

  private static final Log log = LogFactory.getLog(DiscsCalificationsDao.class);
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
  
  public void save(DiscsCalifications DiscsCalifications){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(DiscsCalifications);
      trans.commit();
  }

  public DiscsCalifications getDiscsCalificationsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      DiscsCalifications instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteDiscsCalifications(DiscsCalifications DiscsCalifications) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(DiscsCalifications);
      trans.commit();
  }
  
  public List<DiscsCalifications> getCalificationsOfDiscs(int idDisc) {
	    try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from DiscsCalifications where disc = :idDisc");
	        query.setParameter("idDisc", idDisc);
	        java.util.List<DiscsCalifications> results = query.list();
	      //  java.util.List <Fanatics> results= session.createCriteria(Fanatics.class).list();
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
}
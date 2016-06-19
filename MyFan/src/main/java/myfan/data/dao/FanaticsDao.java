package myfan.data.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import myfan.data.models.Artists;
import myfan.data.models.Fanatics;
import myfan.resources.util.HibernateUtil;

public class FanaticsDao extends FanaticsHome {

  private static final Log log = LogFactory.getLog(FanaticsDao.class);
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
  
  public void save(Fanatics Fanatics){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Fanatics);
      trans.commit();
  }

  public Fanatics getFanaticsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Fanatics instance = findById(id);
      trans.commit();
      return instance;
  }
  
  public Fanatics getFanaticsByUserId(int idUser) {
	    try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from Fanatics where userid = :idUser");
	        query.setParameter("idUser", idUser);
	        java.util.List<Fanatics> results = query.list();
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results.get(0);
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
	}
  
  public void deleteFanatics(Fanatics Fanatics) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Fanatics);
      trans.commit();
  }
}
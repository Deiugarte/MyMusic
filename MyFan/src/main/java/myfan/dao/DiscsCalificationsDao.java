package myfan.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import myfan.models.DiscsCalifications;
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
}
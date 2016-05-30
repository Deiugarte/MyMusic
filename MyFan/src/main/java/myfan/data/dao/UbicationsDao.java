package myfan.data.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import myfan.data.models.Ubications;
import myfan.resources.util.HibernateUtil;

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

  public void deleteUbications(Ubications Ubications) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Ubications);
      trans.commit();
  }
}
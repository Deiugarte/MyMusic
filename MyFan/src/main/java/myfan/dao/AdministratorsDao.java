package myfan.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import myfan.models.Administrators;
import myfan.resources.util.HibernateUtil;

public class AdministratorsDao extends AdministratorsHome {

  private static final Log log = LogFactory.getLog(AdministratorsDao.class);
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
  
  public void save(Administrators Administrators){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Administrators);
      trans.commit();
  }

  public Administrators getAdministratorsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Administrators instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteAdministrators(Administrators Administrators) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Administrators);
      trans.commit();
  }
}
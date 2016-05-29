package myfan.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import myfan.models.FanaticsGenres;
import myfan.resources.util.HibernateUtil;

public class FanaticsGenresDao extends FanaticsGenresHome {

  private static final Log log = LogFactory.getLog(FanaticsGenresDao.class);
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
  
  public void save(FanaticsGenres FanaticsGenres){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(FanaticsGenres);
      trans.commit();
  }

  public FanaticsGenres getFanaticsGenresById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      FanaticsGenres instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteFanaticsGenres(FanaticsGenres FanaticsGenres) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(FanaticsGenres);
      trans.commit();
  }
}
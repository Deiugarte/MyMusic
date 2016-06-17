package myfan.data.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import myfan.data.models.FanaticsArtists;
import myfan.resources.util.HibernateUtil;

public class FanaticsArtistsDao extends FanaticsArtistsHome {

  private static final Log log = LogFactory.getLog(FanaticsArtistsDao.class);
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
  
  public void save(FanaticsArtists Events){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Events);
      trans.commit();
  }

  public void deleteEvents(FanaticsArtists fanaticsArtists) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(fanaticsArtists);
      trans.commit();
  }
}
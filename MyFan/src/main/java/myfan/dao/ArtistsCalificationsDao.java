package myfan.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import myfan.models.ArtistsCalifications;
import myfan.resources.util.HibernateUtil;

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
}
package myfest.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import myfest.models.Artistsgenres;
import myfest.models.ArtistsgenresId;
import myfest.utils.HibernateUtil;


public class ArtistsGenresDAO extends ArtistsgenresHome {

  private static final Log log = LogFactory.getLog(ArtistsGenresDAO.class);
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
  
  public void save(Artistsgenres Artists){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Artists);
      trans.commit();
  }

  public Artistsgenres getArtistsById(ArtistsgenresId id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Artistsgenres instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteArtists(Artistsgenres Artists) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Artists);
      trans.commit();
  }
}
package myfest.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import myfest.datasource.databaseconection.HibernateUtil;
import myfest.models.Artistsscores;


public class ArtistsScoresDAO extends ArtistsscoresHome {

  private static final Log log = LogFactory.getLog(ArtistsScoresDAO.class);
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
  
  public void save(Artistsscores Artistsscores){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      merge(Artistsscores);
      trans.commit();
  }

  public Artistsscores getArtistsScoreById(int idArtist) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Artistsscores instance = findById(idArtist);
      trans.commit();
      return instance;
  }

  public void deleteArtists(Artistsscores Artistsscores) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Artistsscores);
      trans.commit();
  }
}
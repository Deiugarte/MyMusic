package myfest.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import myfest.models.ArtistsScores;
import myfest.utils.HibernateUtil;


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
  
  public void save(ArtistsScores ArtistsScores){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      merge(ArtistsScores);
      trans.commit();
  }

  public ArtistsScores getArtistsScoreById(int idArtist) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      ArtistsScores instance = findById(idArtist);
      trans.commit();
      return instance;
  }

  public void deleteArtists(ArtistsScores ArtistsScores) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(ArtistsScores);
      trans.commit();
  }
}
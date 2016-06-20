package myfest.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import myfest.datasource.databaseconection.HibernateUtil;
import myfest.models.Concertsscores;


public class ConcertScoresDAO extends ConcertsscoresHome {

  private static final Log log = LogFactory.getLog(ConcertScoresDAO.class);
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
  
  public void save(Concertsscores Concertsscores){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Concertsscores);
      trans.commit();
  }

  public Concertsscores getArtistsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Concertsscores instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteArtists(Concertsscores Concertsscores) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Concertsscores);
      trans.commit();
  }
}
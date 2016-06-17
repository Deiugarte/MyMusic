package myfest.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import myfest.models.Musicalgenres;
import myfest.utils.HibernateUtil;


public class MusicalGenresDAO extends MusicalgenresHome {

  private static final Log log = LogFactory.getLog(MusicalGenresDAO.class);
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
  
  public void save(Musicalgenres Musicalgenres){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Musicalgenres);
      trans.commit();
  }

  public Musicalgenres getArtistsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Musicalgenres instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteArtists(Musicalgenres Musicalgenres) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Musicalgenres);
      trans.commit();
  }
}
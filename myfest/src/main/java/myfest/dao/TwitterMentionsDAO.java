package myfest.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import myfest.models.Twittermentions;
import myfest.utils.HibernateUtil;


public class TwitterMentionsDAO extends TwittermentionsHome {

  private static final Log log = LogFactory.getLog(TwitterMentionsDAO.class);
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
  
  public void save(Twittermentions Twittermentions){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Twittermentions);
      trans.commit();
  }

  public Twittermentions getArtistsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Twittermentions instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteArtists(Twittermentions Twittermentions) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Twittermentions);
      trans.commit();
  }
}
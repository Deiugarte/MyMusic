package myfan.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import myfan.models.EventsCalifications;
import myfan.resources.util.HibernateUtil;

public class EventsCalificationsDao extends EventsCalificationsHome {

  private static final Log log = LogFactory.getLog(EventsCalificationsDao.class);
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
  
  public void save(EventsCalifications EventsCalifications){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(EventsCalifications);
      trans.commit();
  }

  public EventsCalifications getEventsCalificationsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      EventsCalifications instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteEventsCalifications(EventsCalifications EventsCalifications) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(EventsCalifications);
      trans.commit();
  }
}
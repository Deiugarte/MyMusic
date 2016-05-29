package myfan.dao;
// Generated May 28, 2016 11:43:27 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import myfan.models.EventsCalifications;

/**
 * Home object for domain model class EventsCalifications.
 * @see myfan.models.EventsCalifications
 * @author Hibernate Tools
 */
public class EventsCalificationsHome {

  private static final Log log = LogFactory.getLog(EventsCalificationsHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(EventsCalifications transientInstance) {
    log.debug("persisting EventsCalifications instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(EventsCalifications instance) {
    log.debug("attaching dirty EventsCalifications instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(EventsCalifications instance) {
    log.debug("attaching clean EventsCalifications instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(EventsCalifications persistentInstance) {
    log.debug("deleting EventsCalifications instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public EventsCalifications merge(EventsCalifications detachedInstance) {
    log.debug("merging EventsCalifications instance");
    try {
      EventsCalifications result = (EventsCalifications) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public EventsCalifications findById(int id) {
    log.debug("getting EventsCalifications instance with id: " + id);
    try {
      EventsCalifications instance = (EventsCalifications) sessionFactory.getCurrentSession()
          .get("myfan.dao.EventsCalifications", id);
      if (instance == null) {
        log.debug("get successful, no instance found");
      } else {
        log.debug("get successful, instance found");
      }
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    }
  }

  public List findByExample(EventsCalifications instance) {
    log.debug("finding EventsCalifications instance by example");
    try {
      List results = sessionFactory.getCurrentSession().createCriteria("myfan.dao.EventsCalifications")
          .add(Example.create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

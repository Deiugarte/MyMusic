package myfan.data.dao;
// Generated Jun 19, 2016 12:46:28 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import myfan.data.models.Events;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Events.
 * @see myfan.data.models.Events
 * @author Hibernate Tools
 */
public class EventsHome {

  private static final Log log = LogFactory.getLog(EventsHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(Events transientInstance) {
    log.debug("persisting Events instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(Events instance) {
    log.debug("attaching dirty Events instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(Events instance) {
    log.debug("attaching clean Events instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(Events persistentInstance) {
    log.debug("deleting Events instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public Events merge(Events detachedInstance) {
    log.debug("merging Events instance");
    try {
      Events result = (Events) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public Events findById(java.lang.Integer id) {
    log.debug("getting Events instance with id: " + id);
    try {
      Events instance = (Events) sessionFactory.getCurrentSession().get("myfan.data.models.Events", id);
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

  public List<Events> findByExample(Events instance) {
    log.debug("finding Events instance by example");
    try {
      List<Events> results = (List<Events>) sessionFactory.getCurrentSession().createCriteria("myfan.data.models.Events")
          .add(create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

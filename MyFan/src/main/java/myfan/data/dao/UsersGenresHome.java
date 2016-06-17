package myfan.data.dao;
// Generated Jun 13, 2016 1:18:21 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import myfan.data.models.UsersGenres;

/**
 * Home object for domain model class UsersGenres.
 * @see myfan.data.models.UsersGenres
 * @author Hibernate Tools
 */


public class UsersGenresHome {

  private static final Log log = LogFactory.getLog(UsersGenresHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(UsersGenres transientInstance) {
    log.debug("persisting UsersGenres instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(UsersGenres instance) {
    log.debug("attaching dirty UsersGenres instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(UsersGenres instance) {
    log.debug("attaching clean UsersGenres instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(UsersGenres persistentInstance) {
    log.debug("deleting UsersGenres instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public UsersGenres merge(UsersGenres detachedInstance) {
    log.debug("merging UsersGenres instance");
    try {
      UsersGenres result = (UsersGenres) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public UsersGenres findById(int id) {
    log.debug("getting UsersGenres instance with id: " + id);
    try {
      UsersGenres instance = (UsersGenres) sessionFactory.getCurrentSession().get("myfan.data.models.UsersGenres", id);
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

  public List findByExample(UsersGenres instance) {
    log.debug("finding UsersGenres instance by example");
    try {
      List results = sessionFactory.getCurrentSession().createCriteria("myfan.data.models.UsersGenres")
          .add(Example.create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

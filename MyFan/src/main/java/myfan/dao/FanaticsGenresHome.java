package myfan.dao;
// Generated May 28, 2016 11:43:27 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import myfan.models.FanaticsGenres;

/**
 * Home object for domain model class FanaticsGenres.
 * @see myfan.models.FanaticsGenres
 * @author Hibernate Tools
 */
public class FanaticsGenresHome {

  private static final Log log = LogFactory.getLog(FanaticsGenresHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(FanaticsGenres transientInstance) {
    log.debug("persisting FanaticsGenres instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(FanaticsGenres instance) {
    log.debug("attaching dirty FanaticsGenres instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(FanaticsGenres instance) {
    log.debug("attaching clean FanaticsGenres instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(FanaticsGenres persistentInstance) {
    log.debug("deleting FanaticsGenres instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public FanaticsGenres merge(FanaticsGenres detachedInstance) {
    log.debug("merging FanaticsGenres instance");
    try {
      FanaticsGenres result = (FanaticsGenres) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public FanaticsGenres findById(int id) {
    log.debug("getting FanaticsGenres instance with id: " + id);
    try {
      FanaticsGenres instance = (FanaticsGenres) sessionFactory.getCurrentSession().get("myfan.dao.FanaticsGenres", id);
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

  public List findByExample(FanaticsGenres instance) {
    log.debug("finding FanaticsGenres instance by example");
    try {
      List results = sessionFactory.getCurrentSession().createCriteria("myfan.dao.FanaticsGenres")
          .add(Example.create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

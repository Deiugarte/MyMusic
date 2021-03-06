package myfan.data.dao;
// Generated Jun 17, 2016 12:28:37 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import myfan.data.models.Fanatics;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Fanatics.
 * @see myfan.data.models.Fanatics
 * @author Hibernate Tools
 */
public class FanaticsHome {

  private static final Log log = LogFactory.getLog(FanaticsHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(Fanatics transientInstance) {
    log.debug("persisting Fanatics instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(Fanatics instance) {
    log.debug("attaching dirty Fanatics instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(Fanatics instance) {
    log.debug("attaching clean Fanatics instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(Fanatics persistentInstance) {
    log.debug("deleting Fanatics instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public Fanatics merge(Fanatics detachedInstance) {
    log.debug("merging Fanatics instance");
    try {
      Fanatics result = (Fanatics) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public Fanatics findById(java.lang.Integer id) {
    log.debug("getting Fanatics instance with id: " + id);
    try {
      Fanatics instance = (Fanatics) sessionFactory.getCurrentSession().get("myfan.data.models.Fanatics", id);
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

  public List<Fanatics> findByExample(Fanatics instance) {
    log.debug("finding Fanatics instance by example");
    try {
      List<Fanatics> results = (List<Fanatics>) sessionFactory.getCurrentSession()
          .createCriteria("myfan.dao.temp.Fanatics").add(create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

package myfan.data.dao;
// Generated Jun 13, 2016 1:18:21 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import myfan.data.models.Ubications;

/**
 * Home object for domain model class Ubications.
 * @see myfan.data.models.Ubications
 * @author Hibernate Tools
 */
public class UbicationsHome {

  private static final Log log = LogFactory.getLog(UbicationsHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(Ubications transientInstance) {
    log.debug("persisting Ubications instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(Ubications instance) {
    log.debug("attaching dirty Ubications instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(Ubications instance) {
    log.debug("attaching clean Ubications instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(Ubications persistentInstance) {
    log.debug("deleting Ubications instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public Ubications merge(Ubications detachedInstance) {
    log.debug("merging Ubications instance");
    try {
      Ubications result = (Ubications) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public Ubications findById(java.lang.Integer id) {
    log.debug("getting Ubications instance with id: " + id);
    try {
      Ubications instance = (Ubications) sessionFactory.getCurrentSession().get("myfan.dao.temp.Ubications", id);
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

  public List findByExample(Ubications instance) {
    log.debug("finding Ubications instance by example");
    try {
      List results = sessionFactory.getCurrentSession().createCriteria("myfan.dao.temp.Ubications")
          .add(Example.create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

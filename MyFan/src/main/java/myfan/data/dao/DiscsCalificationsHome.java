package myfan.data.dao;
// Generated Jun 17, 2016 12:28:37 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import myfan.data.models.DiscsCalifications;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class DiscsCalifications.
 * @see myfan.data.models.DiscsCalifications
 * @author Hibernate Tools
 */
public class DiscsCalificationsHome {

  private static final Log log = LogFactory.getLog(DiscsCalificationsHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(DiscsCalifications transientInstance) {
    log.debug("persisting DiscsCalifications instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(DiscsCalifications instance) {
    log.debug("attaching dirty DiscsCalifications instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(DiscsCalifications instance) {
    log.debug("attaching clean DiscsCalifications instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(DiscsCalifications persistentInstance) {
    log.debug("deleting DiscsCalifications instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public DiscsCalifications merge(DiscsCalifications detachedInstance) {
    log.debug("merging DiscsCalifications instance");
    try {
      DiscsCalifications result = (DiscsCalifications) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public DiscsCalifications findById(java.lang.Integer id) {
    log.debug("getting DiscsCalifications instance with id: " + id);
    try {
      DiscsCalifications instance = (DiscsCalifications) sessionFactory.getCurrentSession()
          .get("myfan.dao.temp.DiscsCalifications", id);
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

  public List<DiscsCalifications> findByExample(DiscsCalifications instance) {
    log.debug("finding DiscsCalifications instance by example");
    try {
      List<DiscsCalifications> results = (List<DiscsCalifications>) sessionFactory.getCurrentSession()
          .createCriteria("myfan.dao.temp.DiscsCalifications").add(create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

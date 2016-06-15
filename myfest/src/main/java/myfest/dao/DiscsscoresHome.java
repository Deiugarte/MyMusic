package myfest.dao;
// Generated Jun 14, 2016 9:46:17 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import myfest.models.Discsscores;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Discsscores.
 * @see myfest.models.Discsscores
 * @author Hibernate Tools
 */
public class DiscsscoresHome {

  private static final Log log = LogFactory.getLog(DiscsscoresHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(Discsscores transientInstance) {
    log.debug("persisting Discsscores instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(Discsscores instance) {
    log.debug("attaching dirty Discsscores instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(Discsscores instance) {
    log.debug("attaching clean Discsscores instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(Discsscores persistentInstance) {
    log.debug("deleting Discsscores instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public Discsscores merge(Discsscores detachedInstance) {
    log.debug("merging Discsscores instance");
    try {
      Discsscores result = (Discsscores) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public Discsscores findById(int id) {
    log.debug("getting Discsscores instance with id: " + id);
    try {
      Discsscores instance = (Discsscores) sessionFactory.getCurrentSession().get("myfest.dao.temp.Discsscores", id);
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

  public List<Discsscores> findByExample(Discsscores instance) {
    log.debug("finding Discsscores instance by example");
    try {
      List<Discsscores> results = (List<Discsscores>) sessionFactory.getCurrentSession()
          .createCriteria("myfest.dao.temp.Discsscores").add(create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

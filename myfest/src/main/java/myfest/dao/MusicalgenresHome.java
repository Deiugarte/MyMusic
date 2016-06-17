package myfest.dao;
// Generated Jun 14, 2016 9:46:17 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import myfest.models.Musicalgenres;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Musicalgenres.
 * @see myfest.models.Musicalgenres
 * @author Hibernate Tools
 */
public class MusicalgenresHome {

  private static final Log log = LogFactory.getLog(MusicalgenresHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(Musicalgenres transientInstance) {
    log.debug("persisting Musicalgenres instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(Musicalgenres instance) {
    log.debug("attaching dirty Musicalgenres instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(Musicalgenres instance) {
    log.debug("attaching clean Musicalgenres instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(Musicalgenres persistentInstance) {
    log.debug("deleting Musicalgenres instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public Musicalgenres merge(Musicalgenres detachedInstance) {
    log.debug("merging Musicalgenres instance");
    try {
      Musicalgenres result = (Musicalgenres) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public Musicalgenres findById(int id) {
    log.debug("getting Musicalgenres instance with id: " + id);
    try {
      Musicalgenres instance = (Musicalgenres) sessionFactory.getCurrentSession().get("myfest.dao.temp.Musicalgenres",
          id);
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

  public List<Musicalgenres> findByExample(Musicalgenres instance) {
    log.debug("finding Musicalgenres instance by example");
    try {
      List<Musicalgenres> results = (List<Musicalgenres>) sessionFactory.getCurrentSession()
          .createCriteria("myfest.dao.temp.Musicalgenres").add(create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

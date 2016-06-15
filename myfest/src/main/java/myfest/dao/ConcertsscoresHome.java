package myfest.dao;
// Generated Jun 14, 2016 9:46:17 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import myfest.models.Concertsscores;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Concertsscores.
 * @see myfest.models.Concertsscores
 * @author Hibernate Tools
 */
public class ConcertsscoresHome {

  private static final Log log = LogFactory.getLog(ConcertsscoresHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(Concertsscores transientInstance) {
    log.debug("persisting Concertsscores instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(Concertsscores instance) {
    log.debug("attaching dirty Concertsscores instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(Concertsscores instance) {
    log.debug("attaching clean Concertsscores instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(Concertsscores persistentInstance) {
    log.debug("deleting Concertsscores instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public Concertsscores merge(Concertsscores detachedInstance) {
    log.debug("merging Concertsscores instance");
    try {
      Concertsscores result = (Concertsscores) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public Concertsscores findById(int id) {
    log.debug("getting Concertsscores instance with id: " + id);
    try {
      Concertsscores instance = (Concertsscores) sessionFactory.getCurrentSession()
          .get("myfest.dao.temp.Concertsscores", id);
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

  public List<Concertsscores> findByExample(Concertsscores instance) {
    log.debug("finding Concertsscores instance by example");
    try {
      List<Concertsscores> results = (List<Concertsscores>) sessionFactory.getCurrentSession()
          .createCriteria("myfest.dao.temp.Concertsscores").add(create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

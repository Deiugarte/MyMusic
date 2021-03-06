package myfest.dao;
// Generated Jun 14, 2016 9:46:17 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import myfest.models.Twittermentions;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Twittermentions.
 * @see myfest.models.Twittermentions
 * @author Hibernate Tools
 */
public class TwittermentionsHome {

  private static final Log log = LogFactory.getLog(TwittermentionsHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(Twittermentions transientInstance) {
    log.debug("persisting Twittermentions instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(Twittermentions instance) {
    log.debug("attaching dirty Twittermentions instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(Twittermentions instance) {
    log.debug("attaching clean Twittermentions instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(Twittermentions persistentInstance) {
    log.debug("deleting Twittermentions instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public Twittermentions merge(Twittermentions detachedInstance) {
    log.debug("merging Twittermentions instance");
    try {
      Twittermentions result = (Twittermentions) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public Twittermentions findById(int id) {
    log.debug("getting Twittermentions instance with id: " + id);
    try {
      Twittermentions instance = (Twittermentions) sessionFactory.getCurrentSession()
          .get("myfest.dao.temp.Twittermentions", id);
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

  public List<Twittermentions> findByExample(Twittermentions instance) {
    log.debug("finding Twittermentions instance by example");
    try {
      List<Twittermentions> results = (List<Twittermentions>) sessionFactory.getCurrentSession()
          .createCriteria("myfest.dao.temp.Twittermentions").add(create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

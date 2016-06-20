package myfest.dao;
// Generated Jun 14, 2016 9:46:17 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import myfest.models.ArtistsScores;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class ArtistsScores.
 * @see myfest.models.ArtistsScores
 * @author Hibernate Tools
 */
public class ArtistsscoresHome {

  private static final Log log = LogFactory.getLog(ArtistsscoresHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(ArtistsScores transientInstance) {
    log.debug("persisting ArtistsScores instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(ArtistsScores instance) {
    log.debug("attaching dirty ArtistsScores instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(ArtistsScores instance) {
    log.debug("attaching clean ArtistsScores instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(ArtistsScores persistentInstance) {
    log.debug("deleting ArtistsScores instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public ArtistsScores merge(ArtistsScores detachedInstance) {
    log.debug("merging ArtistsScores instance");
    try {
      ArtistsScores result = (ArtistsScores) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public ArtistsScores findById(int id) {
    log.debug("getting ArtistsScores instance with id: " + id);
    try {
      ArtistsScores instance = (ArtistsScores) sessionFactory.getCurrentSession().get("myfest.models.ArtistsScores",
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

  public List<ArtistsScores> findByExample(ArtistsScores instance) {
    log.debug("finding ArtistsScores instance by example");
    try {
      List<ArtistsScores> results = (List<ArtistsScores>) sessionFactory.getCurrentSession()
          .createCriteria("myfest.models.ArtistsScores").add(create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

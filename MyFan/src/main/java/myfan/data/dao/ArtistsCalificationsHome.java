package myfan.data.dao;
// Generated Jun 17, 2016 12:28:37 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import myfan.data.models.ArtistsCalifications;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class ArtistsCalifications.
 * @see myfan.data.models.ArtistsCalifications
 * @author Hibernate Tools
 */
public class ArtistsCalificationsHome {

  private static final Log log = LogFactory.getLog(ArtistsCalificationsHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(ArtistsCalifications transientInstance) {
    log.debug("persisting ArtistsCalifications instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(ArtistsCalifications instance) {
    log.debug("attaching dirty ArtistsCalifications instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(ArtistsCalifications instance) {
    log.debug("attaching clean ArtistsCalifications instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(ArtistsCalifications persistentInstance) {
    log.debug("deleting ArtistsCalifications instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public ArtistsCalifications merge(ArtistsCalifications detachedInstance) {
    log.debug("merging ArtistsCalifications instance");
    try {
      ArtistsCalifications result = (ArtistsCalifications) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public ArtistsCalifications findById(java.lang.Integer id) {
    log.debug("getting ArtistsCalifications instance with id: " + id);
    try {
      ArtistsCalifications instance = (ArtistsCalifications) sessionFactory.getCurrentSession()
          .get("myfan.dao.temp.ArtistsCalifications", id);
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

  public List<ArtistsCalifications> findByExample(ArtistsCalifications instance) {
    log.debug("finding ArtistsCalifications instance by example");
    try {
      List<ArtistsCalifications> results = (List<ArtistsCalifications>) sessionFactory.getCurrentSession()
          .createCriteria("myfan.dao.temp.ArtistsCalifications").add(create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

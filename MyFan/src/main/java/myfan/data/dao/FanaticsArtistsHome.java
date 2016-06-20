package myfan.data.dao;
// Generated Jun 17, 2016 12:28:37 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import myfan.data.models.FanaticsArtists;
import myfan.data.models.FanaticsArtistsId;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class FanaticsArtists.
 * @see myfan.data.models.FanaticsArtists
 * @author Hibernate Tools
 */
public class FanaticsArtistsHome {

  private static final Log log = LogFactory.getLog(FanaticsArtistsHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(FanaticsArtists transientInstance) {
    log.debug("persisting FanaticsArtists instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(FanaticsArtists instance) {
    log.debug("attaching dirty FanaticsArtists instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(FanaticsArtists instance) {
    log.debug("attaching clean FanaticsArtists instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(FanaticsArtists persistentInstance) {
    log.debug("deleting FanaticsArtists instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public FanaticsArtists merge(FanaticsArtists detachedInstance) {
    log.debug("merging FanaticsArtists instance");
    try {
      FanaticsArtists result = (FanaticsArtists) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public FanaticsArtists findById(myfan.data.models.FanaticsArtistsId id) {
    log.debug("getting FanaticsArtists instance with id: " + id);
    try {
      FanaticsArtists instance = (FanaticsArtists) sessionFactory.getCurrentSession()
          .get("myfan.dao.temp.FanaticsArtists", id);
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

  public List<FanaticsArtists> findByExample(FanaticsArtists instance) {
    log.debug("finding FanaticsArtists instance by example");
    try {
      List<FanaticsArtists> results = (List<FanaticsArtists>) sessionFactory.getCurrentSession()
          .createCriteria("myfan.dao.temp.FanaticsArtists").add(create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

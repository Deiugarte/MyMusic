package myfan.data.dao;
// Generated Jun 19, 2016 12:46:28 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import myfan.data.models.Songs;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Songs.
 * @see myfan.data.models.Songs
 * @author Hibernate Tools
 */
public class SongsHome {

  private static final Log log = LogFactory.getLog(SongsHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(Songs transientInstance) {
    log.debug("persisting Songs instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(Songs instance) {
    log.debug("attaching dirty Songs instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(Songs instance) {
    log.debug("attaching clean Songs instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(Songs persistentInstance) {
    log.debug("deleting Songs instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public Songs merge(Songs detachedInstance) {
    log.debug("merging Songs instance");
    try {
      Songs result = (Songs) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public Songs findById(java.lang.Integer id) {
    log.debug("getting Songs instance with id: " + id);
    try {
      Songs instance = (Songs) sessionFactory.getCurrentSession().get("myfan.dao.temp.Songs", id);
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

  public List<Songs> findByExample(Songs instance) {
    log.debug("finding Songs instance by example");
    try {
      List<Songs> results = (List<Songs>) sessionFactory.getCurrentSession().createCriteria("myfan.dao.temp.Songs")
          .add(create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

package myfan.data.dao;
// Generated Jun 17, 2016 12:28:37 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import myfan.data.models.UsersRoles;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class UsersRoles.
 * @see myfan.data.models.UsersRoles
 * @author Hibernate Tools
 */
public class UsersRolesHome {

  private static final Log log = LogFactory.getLog(UsersRolesHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(UsersRoles transientInstance) {
    log.debug("persisting UsersRoles instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(UsersRoles instance) {
    log.debug("attaching dirty UsersRoles instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(UsersRoles instance) {
    log.debug("attaching clean UsersRoles instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(UsersRoles persistentInstance) {
    log.debug("deleting UsersRoles instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public UsersRoles merge(UsersRoles detachedInstance) {
    log.debug("merging UsersRoles instance");
    try {
      UsersRoles result = (UsersRoles) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public UsersRoles findById(java.lang.Integer id) {
    log.debug("getting UsersRoles instance with id: " + id);
    try {
      UsersRoles instance = (UsersRoles) sessionFactory.getCurrentSession().get("myfan.dao.temp.UsersRoles", id);
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

  public List<UsersRoles> findByExample(UsersRoles instance) {
    log.debug("finding UsersRoles instance by example");
    try {
      List<UsersRoles> results = (List<UsersRoles>) sessionFactory.getCurrentSession()
          .createCriteria("myfan.dao.temp.UsersRoles").add(create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

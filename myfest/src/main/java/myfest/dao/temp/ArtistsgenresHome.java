package myfest.dao.temp;
// Generated Jun 14, 2016 9:46:17 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import myfest.models.Artistsgenres;
import myfest.models.ArtistsgenresId;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Artistsgenres.
 * @see myfest.models.Artistsgenres
 * @author Hibernate Tools
 */
public class ArtistsgenresHome {

  private static final Log log = LogFactory.getLog(ArtistsgenresHome.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory() {
    try {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e) {
      log.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(Artistsgenres transientInstance) {
    log.debug("persisting Artistsgenres instance");
    try {
      sessionFactory.getCurrentSession().persist(transientInstance);
      log.debug("persist successful");
    } catch (RuntimeException re) {
      log.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(Artistsgenres instance) {
    log.debug("attaching dirty Artistsgenres instance");
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(Artistsgenres instance) {
    log.debug("attaching clean Artistsgenres instance");
    try {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void delete(Artistsgenres persistentInstance) {
    log.debug("deleting Artistsgenres instance");
    try {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    }
  }

  public Artistsgenres merge(Artistsgenres detachedInstance) {
    log.debug("merging Artistsgenres instance");
    try {
      Artistsgenres result = (Artistsgenres) sessionFactory.getCurrentSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    }
  }

  public Artistsgenres findById(myfest.models.ArtistsgenresId id) {
    log.debug("getting Artistsgenres instance with id: " + id);
    try {
      Artistsgenres instance = (Artistsgenres) sessionFactory.getCurrentSession().get("myfest.dao.temp.Artistsgenres",
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

  public List<Artistsgenres> findByExample(Artistsgenres instance) {
    log.debug("finding Artistsgenres instance by example");
    try {
      List<Artistsgenres> results = (List<Artistsgenres>) sessionFactory.getCurrentSession()
          .createCriteria("myfest.dao.temp.Artistsgenres").add(create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    }
  }
}

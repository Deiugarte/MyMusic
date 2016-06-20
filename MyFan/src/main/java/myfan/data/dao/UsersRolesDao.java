package myfan.data.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import myfan.comunicacion.comunicacion.resources.HibernateUtil;
import myfan.data.models.Users;
import myfan.data.models.UsersRoles;

public class UsersRolesDao extends UsersRolesHome {

  private static final Log log = LogFactory.getLog(UsersRolesDao.class);
  private final SessionFactory sessionFactory = getSessionFactory();

  @Override
  public SessionFactory getSessionFactory(){
      try {
          return (SessionFactory) HibernateUtil.getSessionFactory();
      } catch (Exception e) {
          log.error("Could not locate SessionFactory in JNDI", e);
          throw new IllegalStateException("Could not locate SessionFactory in JNDI");
      }
  }
  
  public void save(UsersRoles UsersRoles){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(UsersRoles);
      trans.commit();
  }

  public UsersRoles getUsersRolesById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      UsersRoles instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteUsersRoles(UsersRoles UsersRoles) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(UsersRoles);
      trans.commit();
  }
  
  public UsersRoles findByRoleName(String roleName) {
	    log.debug("getting RefiereUser instance with username: " + roleName);
	    try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from UsersRoles where rolename = :rolename");
	        query.setParameter("rolename", roleName);
	        java.util.List results = query.list();
	        System.out.println("Result list: " + results.size());
	        UsersRoles instance = (results != null && results.size() == 1) ? (UsersRoles) results.get(0) : null;
	        trans.commit();
	        log.debug("get successful, instance found");
	        return instance;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
  }
}
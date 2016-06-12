package myfan.data.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import myfan.data.models.Users;
import myfan.data.models.UsersRoles;
import myfan.resources.util.HibernateUtil;

public class UsersDao extends UsersHome {

  private static final Log log = LogFactory.getLog(UsersDao.class);
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
  
  public void save(Users Users){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Users);
      trans.commit();
  }

  public Users getUsersById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Users instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteUsers(Users Users) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Users);
      trans.commit();
  }
  
  public Users findByusername(String username) {
    log.debug("getting RefiereUser instance with username: " + username);
    try {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction trans= session.beginTransaction();
        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
            log.debug(" >>> Transaction close.");
        Query query = session.createQuery("from Users su join fetch su.usersRoles where username = :username");
        query.setParameter("username", username);
        java.util.List results = query.list();
        System.out.println("Result list: " + results.size());
        Users instance = (results != null && results.size() == 1) ? (Users) results.get(0) : null;
        trans.commit();
        log.debug("get successful, instance found");
        return instance;
    } catch (RuntimeException re) {
        log.error("get failed", re);
        throw re;
    }
}

}
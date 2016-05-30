package myfan.data.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import myfan.data.models.UsersRoles;
import myfan.resources.util.HibernateUtil;

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
}
package myfan.data.dao;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import myfan.data.models.Genres;
import myfan.data.models.UsersGenres;
import myfan.resources.util.HibernateUtil;

public class UsersGenresDao extends UsersGenresHome{

  private static final Log log = LogFactory.getLog(UsersGenresDao.class);
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
  
  public void save(UsersGenres UsersGenres){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      merge(UsersGenres);
      trans.commit();
  }
 
  public List<UsersGenres> findGenresByUsersId(int idUser) {
	    try {
	        Session session = sessionFactory.getCurrentSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	       
	        Query query = session.createQuery("from UsersGenres where iduser = :idUser");
	        query.setParameter("idUser", idUser); 
	        
	      //  java.util.List <UsersGenres> results = query.list();
	        java.util.List <UsersGenres> results= session.createCriteria(UsersGenres.class).list();
	        for(int i=0; i< results.size();i++){
	        	   Hibernate.initialize(results.get(i));  
	        }
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
	}


	  public UsersGenres findGenresByUserGenressId(int id) {
	      Session session = sessionFactory.getCurrentSession();
	      org.hibernate.Transaction trans= session.beginTransaction();
	      UsersGenres instance = findById(id);
	      trans.commit();
	      return instance;
	  }
  public void deleteUsersGenres(UsersGenres UsersGenres) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(UsersGenres);
      trans.commit();
  }
}
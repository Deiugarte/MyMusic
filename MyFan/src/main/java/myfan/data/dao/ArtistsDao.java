package myfan.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import myfan.comunicacion.comunicacion.resources.HibernateUtil;
import myfan.data.models.Artists;
import myfan.data.models.Fanatics;
import myfan.data.models.Ubications;
import myfan.data.models.Users;

public class ArtistsDao extends ArtistsHome {

  private static final Log log = LogFactory.getLog(ArtistsDao.class);
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

  public void save(Artists Artists){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      merge(Artists);
      trans.commit();
  }

  public Artists getArtistsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Artists instance = findById(id);
      trans.commit();
      return instance;
  }

  public Artists getArtistsByUserId(int idUser) {
	    try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from Artists where userid = :idUser");
	        query.setParameter("idUser", idUser);
	        java.util.List<Artists> results = query.list();
	        //java.util.List <Artists> results= session.createCriteria(Artists.class).list();
	        for(int i=0; i< results.size();i++){
	        	   Hibernate.initialize(results.get(i));
	        }
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results.size()==0?null:results.get(0);
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
	}
  
  public List<Users> getArtistsByName(String nameArtist) {
	    try {
	    	 nameArtist="%"+nameArtist+"%";
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from Users where name like :nameArtist and role = 11");
	        query.setParameter("nameArtist", nameArtist);
	        java.util.List<Users> results = query.list();
	      //  java.util.List<Artists> resultsFinal = new ArrayList();
	     //   for (int i = 0; i < results.size(); i++) {
		//		resultsFinal.add(getArtistsByUserId(results.get(i).getUserId()));
		//	}
	        //java.util.List <Artists> results= session.createCriteria(Artists.class).list();
	        for(int i=0; i< results.size();i++){
	        	   Hibernate.initialize(results.get(i));
	        }
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
	}
  
  public List<Users> getArtistsByNameAndUbication(String nameArtist,int idUbication) {
	    try {
	    	nameArtist="%"+nameArtist+"%";
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from Users where name like :nameArtist and ubication=:idUbication and role = 11 ");
	        query.setParameter("nameArtist", nameArtist);
	        query.setParameter("idUbication", idUbication);
	        java.util.List<Users> results = query.list();
	        //java.util.List <Artists> results= session.createCriteria(Artists.class).list();
	        for(int i=0; i< results.size();i++){
	        	   Hibernate.initialize(results.get(i));
	        }
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
	}
  
  public List<Users> getArtistsByUbication(int idUbication) {
	    try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from Users where ubication=:idUbication and role = 11 ");
	        query.setParameter("idUbication", idUbication);
	        java.util.List<Users> results = query.list();
	        //java.util.List <Artists> results= session.createCriteria(Artists.class).list();
	        for(int i=0; i< results.size();i++){
	        	   Hibernate.initialize(results.get(i));
	        }
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
	}

  public void deleteArtists(Artists Artists) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Artists);
      trans.commit();
  }
}

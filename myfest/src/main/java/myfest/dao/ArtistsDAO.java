package myfest.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import Objects.DBObject;
import Objects.GUISearchSpecific;
import myfest.models.Artists;
import myfest.models.Musicalgenres;
import myfest.utils.HibernateUtil;


public class ArtistsDAO extends ArtistsHome {

  private static final Log log = LogFactory.getLog(ArtistsDAO.class);
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
  
  public List<String> getArtistNameByCountry(DBObject dbObject){
	  String resultsAmount = dbObject.getResultsAmount();
	  String value = dbObject.getValue();	  
	  try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("SELECT A.artistname FROM artists A WHERE A.ubication = '"+value+"' LIMIT "+resultsAmount);
	        java.util.List results = query.list();
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
  }
  
  //revisar query
  public List<String> getArtistData(GUISearchSpecific guiObject){
	  String name = guiObject.getArtistName();
	  try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("SELECT A.artistname, A.followersamount, A.artistscore, A.concertscore, A.discscore FROM artists A WHERE A.artistname ="+name);
	        java.util.List results = query.list();
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
  }
  
  // falta query
  public List<String> getArtisNameByName(DBObject dbObject){
	  String resultsAmount = dbObject.getResultsAmount();
	  String value = dbObject.getValue();	  
	  try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("SELECT A.artistname FROM artists A join artistgenres AG join musicalgenres MA WHERE MA.genrename = '"+value+"' LIMIT "+resultsAmount);
	        java.util.List results = query.list();
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
  }
  
  // falta query
  public List<String> getArtistNameByGenre(DBObject dbObject){
	  String resultsAmount = dbObject.getResultsAmount();
	  String value = dbObject.getValue();	  
	  try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("SELECT A.artistname FROM artists A join artistgenres AG join musicalgenres MA WHERE MA.genrename = '"+value+"' LIMIT "+resultsAmount);
	        java.util.List results = query.list();
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
  }
  
  public void save(Artists Artists){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Artists);
      trans.commit();
  }
  
  public List<String> getUbicationsArtists(){ 
	  try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("SELECT DISTINCT A.ubication FROM Artists A");
	        java.util.List results = query.list();
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
  }
  
  public List<Artists> findAll() {
	    try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from Artists");
	        java.util.List results = query.list();
	        System.out.println("Result list: " + results.size());
	        trans.commit();
	        log.debug("get successful, instance found");
	        return results;
	    } catch (RuntimeException re) {
	        log.error("get failed", re);
	        throw re;
	    }
	}

  public Artists getArtistsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Artists instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteArtists(Artists Artists) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Artists);
      trans.commit();
  }
}
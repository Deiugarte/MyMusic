package myfan.data.dao;

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
import myfan.data.models.Members;

public class MembersDao extends MembersHome {

  private static final Log log = LogFactory.getLog(MembersDao.class);
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
  
  public void save(Members Members){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      merge(Members);
      trans.commit();
  }

  public Members getMembersById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Members instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteMembers(Members Members) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Members);
      trans.commit();
  }
  
  public List<Members> getArtistsByUserId(int idArtist) {
	    try {
	        Session session = sessionFactory.openSession();
	        org.hibernate.Transaction trans= session.beginTransaction();
	        if(trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
	            log.debug(" >>> Transaction close.");
	        Query query = session.createQuery("from Members where artist = :idArtist");
	        query.setParameter("idArtist", idArtist);
	        java.util.List<Members> results = query.list();
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

}
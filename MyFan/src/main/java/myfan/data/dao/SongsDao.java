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
import myfan.data.models.Discs;
import myfan.data.models.Songs;

public class SongsDao extends SongsHome {

  private static final Log log = LogFactory.getLog(SongsDao.class);
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
  
  public void save(Songs Songs){
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      persist(Songs);
      trans.commit();
  }

  public Songs getSongsById(int id) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      Songs instance = findById(id);
      trans.commit();
      return instance;
  }

  public void deleteSongs(Songs Songs) {
      Session session = sessionFactory.getCurrentSession();
      org.hibernate.Transaction trans= session.beginTransaction();
      delete(Songs);
      trans.commit();
  }
  
  public List<Songs> getSongsByIdDisc(int idDisc) {
		try {
			Session session = sessionFactory.openSession();
			org.hibernate.Transaction trans = session.beginTransaction();
			if (trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
				log.debug(" >>> Transaction close.");
			Query query = session.createQuery("from Songs where disc = :idDisc");
			query.setParameter("idDisc", idDisc);
			java.util.List<Songs> results = query.list();
			for (int i = 0; i < results.size(); i++) {
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
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
import myfan.data.models.ArtistsCalifications;
import myfan.data.models.Discs;

public class DiscsDao extends DiscsHome {

	private static final Log log = LogFactory.getLog(DiscsDao.class);
	private final SessionFactory sessionFactory = getSessionFactory();

	@Override
	public SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void save(Discs Discs) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction trans = session.beginTransaction();
		merge(Discs);
		trans.commit();
	}

	public Discs getDiscsById(int id) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction trans = session.beginTransaction();
		Discs instance = findById(id);
		trans.commit();
		return instance;
	}

	public Discs getDiscsByDisc(Discs discs) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction trans = session.beginTransaction();
		Discs instance = (Discs) findByExample(discs);
		trans.commit();
		return instance;
	}

	public void deleteDiscs(Discs Discs) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction trans = session.beginTransaction();
		delete(Discs);
		trans.commit();
	}

	public List<Discs> getDiscByIdArtist(int idArtist) {
		try {
			Session session = sessionFactory.openSession();
			org.hibernate.Transaction trans = session.beginTransaction();
			if (trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
				log.debug(" >>> Transaction close.");
			Query query = session.createQuery("from Discs where artist = :idArtist");
			query.setParameter("idArtist", idArtist);
			java.util.List<Discs> results = query.list();
			System.out.println("Result list: " + results.size());
			trans.commit();
			log.debug("get successful, instance found");
			return results;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Discs getDiscsByArtistAndName(int artist, String name) {
		try {
			Session session = sessionFactory.openSession();
			org.hibernate.Transaction trans = session.beginTransaction();
			if (trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
				log.debug(" >>> Transaction close.");
			Query query = session.createQuery("from Discs where artist = :idArtist and name= :name");
			query.setParameter("idArtist", artist);
			query.setParameter("name", name);
			java.util.List<Discs> results = query.list();
			System.out.println("Result list: " + results.size());
			trans.commit();
			log.debug("get successful, instance found");
			return results.get(0);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Discs> getDiscsByIdArtist(int artist) {
		try {
			Session session = sessionFactory.openSession();
			org.hibernate.Transaction trans = session.beginTransaction();
			if (trans.getStatus().equals(TransactionStatus.NOT_ACTIVE))
				log.debug(" >>> Transaction close.");
			Query query = session.createQuery("from Discs where artist = :idArtist");
			query.setParameter("idArtist", artist);
			java.util.List<Discs> results = query.list();
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
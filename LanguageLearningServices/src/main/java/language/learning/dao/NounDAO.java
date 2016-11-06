package language.learning.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import language.learning.exception.EntityNotFoundException;
import language.learning.model.Noun;

@Stateless
public class NounDAO {
	@PersistenceContext
	private EntityManager em;

	public List<Noun> getAllNouns() {
		System.out.println("Trying to get all nouns DAO");
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Noun> criteria = builder.createQuery(Noun.class);
		Root<Noun> root = criteria.from(Noun.class);
		criteria.select(root);

		return em.createQuery(criteria).getResultList();
	}

	public Noun getNounById(Long idNoun) throws EntityNotFoundException {
		try {
			System.out.println("Trying to get Noun with id: [" + idNoun + "] DAO");
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Noun> criteria = builder.createQuery(Noun.class);
			Root<Noun> root = criteria.from(Noun.class);
			criteria.select(root).where(builder.equal(root.get("idNoun"), idNoun));

			return em.createQuery(criteria).getSingleResult();
		} catch (NoResultException nre) {
			throw new EntityNotFoundException("Entity with id [" + idNoun + "] not found");
		}
	}
}

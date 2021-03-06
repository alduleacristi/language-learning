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
import language.learning.model.Level;

@Stateless
public class LevelDAO {
	@PersistenceContext
	private EntityManager em;

	public List<Level> getAllLevels() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Level> criteria = builder.createQuery(Level.class);
		Root<Level> root = criteria.from(Level.class);
		criteria.select(root);

		return em.createQuery(criteria).getResultList();
	}

	public Level getLevelById(Long idLevel) throws EntityNotFoundException {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Level> criteria = builder.createQuery(Level.class);
			Root<Level> root = criteria.from(Level.class);
			criteria.select(root).where(builder.equal(root.get("idLevel"), idLevel));

			return em.createQuery(criteria).getSingleResult();
		} catch (NoResultException nre) {
			throw new EntityNotFoundException("Entity with id [" + idLevel + "] not found");
		}
	}
}

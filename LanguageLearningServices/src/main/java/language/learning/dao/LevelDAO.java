package language.learning.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

	public Level getLevelById(Long idLevel) {
		Level level = new Level();
		level.setIdLevel(idLevel);

		return em.find(Level.class, level);
	}
}

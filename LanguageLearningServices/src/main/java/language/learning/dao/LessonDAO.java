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
import language.learning.model.Lesson;

@Stateless
public class LessonDAO {
	@PersistenceContext
	private EntityManager em;

	public List<Lesson> getAllLessons() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Lesson> criteria = builder.createQuery(Lesson.class);
		Root<Lesson> root = criteria.from(Lesson.class);
		criteria.select(root);

		return em.createQuery(criteria).getResultList();
	}

	public Lesson getLessonById(Long idLesson) throws EntityNotFoundException {
		try {
			System.out.println("Trying to get lesson with id: [" + idLesson + "] DAO");
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Lesson> criteria = builder.createQuery(Lesson.class);
			Root<Lesson> root = criteria.from(Lesson.class);
			criteria.select(root).where(builder.equal(root.get("idLesson"), idLesson));

			return em.createQuery(criteria).getSingleResult();
		} catch (NoResultException nre) {
			throw new EntityNotFoundException("Entity with id [" + idLesson + "] not found");
		}
	}
}

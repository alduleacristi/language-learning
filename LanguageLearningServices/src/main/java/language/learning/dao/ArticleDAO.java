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
import language.learning.model.Article;

@Stateless
public class ArticleDAO {
	@PersistenceContext
	private EntityManager em;

	public List<Article> getAllArticles() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Article> criteria = builder.createQuery(Article.class);
		Root<Article> root = criteria.from(Article.class);
		criteria.select(root);

		return em.createQuery(criteria).getResultList();
	}

	public Article getArticleById(Long idArticle) throws EntityNotFoundException {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Article> criteria = builder.createQuery(Article.class);
			Root<Article> root = criteria.from(Article.class);
			criteria.select(root).where(builder.equal(root.get("idArticle"), idArticle));

			return em.createQuery(criteria).getSingleResult();
		} catch (NoResultException nre) {
			throw new EntityNotFoundException("Entity with id [" + idArticle + "] not found");
		}
	}
}

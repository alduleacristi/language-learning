package language.learning.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import language.learning.dao.ArticleDAO;
import language.learning.exception.EntityNotFoundException;
import language.learning.model.Article;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArticleJaxRS {
	@Inject
	private ArticleDAO articleDAO;

	@GET
	@Path("/article")
	public List<Article> getAllArticles() {
		return articleDAO.getAllArticles();
	}

	@GET
	@Path("/articleById")
	public Article getArticleById(@QueryParam("id") Long idArticle) {
		try {
			System.out.println("Trying to get article with id: [" + idArticle + "]");
			return articleDAO.getArticleById(idArticle);
		} catch (EntityNotFoundException enf) {
			throw new NotFoundException(enf.getMessage());
		}
	}
}

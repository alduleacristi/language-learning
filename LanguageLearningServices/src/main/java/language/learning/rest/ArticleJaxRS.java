package language.learning.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import language.learning.convertor.ArticleConvertor;
import language.learning.dao.ArticleDAO;
import language.learning.dto.ArticleDTO;
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
	public List<ArticleDTO> getAllArticles() {
		List<Article> articles = articleDAO.getAllArticles();
		List<ArticleDTO> articlesDTO = new ArrayList<>();
		articles.forEach((Article a) -> {
			articlesDTO.add(ArticleConvertor.convertToDTO(a));
		});
		return articlesDTO;
	}

	@GET
	@Path("/articleById")
	public ArticleDTO getArticleById(@QueryParam("id") Long idArticle) {
		try {
			System.out.println("Trying to get article with id: [" + idArticle + "]");
			Article article = articleDAO.getArticleById(idArticle);

			return ArticleConvertor.convertToDTO(article);
		} catch (EntityNotFoundException enf) {
			throw new NotFoundException(enf.getMessage());
		}
	}
}

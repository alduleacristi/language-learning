package language.learning.convertor;

import language.learning.dto.ArticleDTO;
import language.learning.model.Article;

public class ArticleConvertor {
	public static Article convertToModel(ArticleDTO articleDTO) {
		Article article = new Article();
		article.setGermanArticle(articleDTO.getGermanArticle());
		article.setIdArticle(articleDTO.getIdArticle());

		return article;
	}

	public static ArticleDTO convertToDTO(Article article) {
		ArticleDTO articleDTO = new ArticleDTO();
		articleDTO.setEnglishArticle(article.getEnglishArticle());
		articleDTO.setGermanArticle(article.getGermanArticle());
		articleDTO.setIdArticle(article.getIdArticle());
		articleDTO.setRomanianArticle(article.getRomanianArticle());

		return articleDTO;
	}
}

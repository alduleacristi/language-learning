package language.learning.convertor;

import language.learning.dto.NounDTO;
import language.learning.model.Article;
import language.learning.model.Lesson;
import language.learning.model.Level;
import language.learning.model.Noun;

public class NounConverter {
	public static Noun convertToModel(NounDTO nounDTO) {
		Noun noun = new Noun();
		noun.setAddDate(nounDTO.getAddDate());

		Article article = new Article();
		article.setIdArticle(nounDTO.getIdArticle());
		noun.setArticle(article);

		Lesson lesson = new Lesson();
		lesson.setIdLesson(nounDTO.getIdLesson());
		noun.setLesson(lesson);

		Level level = new Level();
		level.setIdLevel(nounDTO.getIdLevel());
		noun.setLevel(level);

		noun.setIdNoun(nounDTO.getIdNoun());
		noun.setEnglishWord(nounDTO.getEnglishWord());
		noun.setGermanWord(nounDTO.getGermanWord());
		noun.setRomanianWord(nounDTO.getRomanianWord());

		return noun;
	}

	public static NounDTO convertToDTO(Noun noun) {
		NounDTO nounDTO = new NounDTO();
		nounDTO.setIdNoun(noun.getIdNoun());
		nounDTO.setAddDate(noun.getAddDate());
		nounDTO.setEnglishWord(noun.getEnglishWord());
		nounDTO.setGermanWord(noun.getGermanWord());
		nounDTO.setIdArticle(noun.getArticle().getIdArticle());
		nounDTO.setIdLesson(noun.getLesson().getIdLesson());
		nounDTO.setIdLevel(noun.getLevel().getIdLevel());
		nounDTO.setRomanianWord(noun.getRomanianWord());

		return nounDTO;
	}
}

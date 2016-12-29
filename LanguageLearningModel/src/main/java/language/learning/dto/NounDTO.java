package language.learning.dto;

import java.time.LocalDate;
import java.util.Date;

public class NounDTO {
	private Long idNoun;
	private String germanWord;
	private String romanianWord;
	private String englishWord;
	private Date addDate;
	private Long idLevel;
	private Long idLesson;
	private Long idArticle;

	public NounDTO() {
		super();
	}

	public NounDTO(Long idNoun, String germanWord, String romanianWord, String englishWord, Date addDate,
			Long idLevel, Long idLesson, Long idArticle) {
		super();
		this.idNoun = idNoun;
		this.germanWord = germanWord;
		this.romanianWord = romanianWord;
		this.englishWord = englishWord;
		this.addDate = addDate;
		this.idLevel = idLevel;
		this.idLesson = idLesson;
		this.idArticle = idArticle;
	}

	public Long getIdNoun() {
		return idNoun;
	}

	public void setIdNoun(Long idNoun) {
		this.idNoun = idNoun;
	}

	public String getGermanWord() {
		return germanWord;
	}

	public void setGermanWord(String germanWord) {
		this.germanWord = germanWord;
	}

	public String getRomanianWord() {
		return romanianWord;
	}

	public void setRomanianWord(String romanianWord) {
		this.romanianWord = romanianWord;
	}

	public String getEnglishWord() {
		return englishWord;
	}

	public void setEnglishWord(String englishWord) {
		this.englishWord = englishWord;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Long getIdLevel() {
		return idLevel;
	}

	public void setIdLevel(Long idLevel) {
		this.idLevel = idLevel;
	}

	public Long getIdLesson() {
		return idLesson;
	}

	public void setIdLesson(Long idLesson) {
		this.idLesson = idLesson;
	}

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}
}

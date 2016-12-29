package language.learning.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "noun")
public class Noun implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6952727842451731748L;
	private Long idNoun;
	private String germanWord;
	private String romanianWord;
	private String englishWord;
	private Date addDate;
	private Level level;
	private Lesson lesson;
	private Article article;

	@Id
	@Column(name = "id_noun")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdNoun() {
		return idNoun;
	}

	public void setIdNoun(Long idNoun) {
		this.idNoun = idNoun;
	}

	@Column(name = "german_word")
	public String getGermanWord() {
		return germanWord;
	}

	public void setGermanWord(String germanWord) {
		this.germanWord = germanWord;
	}

	@Column(name = "romanian_word")
	public String getRomanianWord() {
		return romanianWord;
	}

	public void setRomanianWord(String romanianWord) {
		this.romanianWord = romanianWord;
	}

	@Column(name = "english_word")
	public String getEnglishWord() {
		return englishWord;
	}

	public void setEnglishWord(String englishWord) {
		this.englishWord = englishWord;
	}

	@Column(name = "add_date")
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	@ManyToOne
	@JoinColumn(name = "id_level")
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	@ManyToOne
	@JoinColumn(name = "id_lesson")
	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	@ManyToOne
	@JoinColumn(name = "id_article")
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
}

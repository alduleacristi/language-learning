package language.learning.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "article")
public class Article implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7847276411891522455L;
	private Long idArticle;
	private String germanArticle;

	@Id
	@Column(name = "id_article")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	@Column(name = "german_article")
	public String getGermanArticle() {
		return germanArticle;
	}

	public void setGermanArticle(String germanArticle) {
		this.germanArticle = germanArticle;
	}
}

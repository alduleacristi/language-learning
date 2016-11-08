package language.learning.dto;

public class ArticleDTO {
	private Long idArticle;
	private String germanArticle;
	private String englishArticle;
	private String romanianArticle;

	public ArticleDTO() {
		super();
	}

	public ArticleDTO(Long idArticle, String germanArticle, String englishArticle, String romanianArticle) {
		super();
		this.idArticle = idArticle;
		this.germanArticle = germanArticle;
		this.englishArticle = englishArticle;
		this.romanianArticle = romanianArticle;
	}

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public String getGermanArticle() {
		return germanArticle;
	}

	public void setGermanArticle(String germanArticle) {
		this.germanArticle = germanArticle;
	}

	public String getEnglishArticle() {
		return englishArticle;
	}

	public void setEnglishArticle(String englishArticle) {
		this.englishArticle = englishArticle;
	}

	public String getRomanianArticle() {
		return romanianArticle;
	}

	public void setRomanianArticle(String romanianArticle) {
		this.romanianArticle = romanianArticle;
	}
}

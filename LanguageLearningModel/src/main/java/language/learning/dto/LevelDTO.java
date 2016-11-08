package language.learning.dto;

public class LevelDTO {
	private Long idLevel;
	private String levelName;

	public LevelDTO() {
		super();
	}

	public LevelDTO(Long idLevel, String levelName) {
		super();
		this.idLevel = idLevel;
		this.levelName = levelName;
	}

	public Long getIdLevel() {
		return idLevel;
	}

	public void setIdLevel(Long idLevel) {
		this.idLevel = idLevel;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
}

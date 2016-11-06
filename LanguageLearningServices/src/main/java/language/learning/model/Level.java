package language.learning.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "level")
public class Level implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7847276411891522455L;
	private Long idLevel;
	private String levelName;

	@Id
	@Column(name = "id_level")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdLevel() {
		return idLevel;
	}

	public void setIdLevel(Long idLevel) {
		this.idLevel = idLevel;
	}

	@Column(name = "level_name")
	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
}

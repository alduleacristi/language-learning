package language.learning.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "lesson")
public class Lesson implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7847276411891522455L;
	private Long idLesson;
	private String lessonName;

	@Id
	@Column(name = "id_lesson")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdLesson() {
		return idLesson;
	}

	public void setIdLesson(Long idLesson) {
		this.idLesson = idLesson;
	}

	@Column(name = "lesson_name")
	public String getLevelName() {
		return lessonName;
	}

	public void setLevelName(String lessonName) {
		this.lessonName = lessonName;
	}
}

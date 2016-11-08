package language.learning.dto;

public class LessonDTO {
	private Long idLesson;
	private String lessonName;

	public LessonDTO(Long idLesson, String lessonName) {
		super();
		this.idLesson = idLesson;
		this.lessonName = lessonName;
	}

	public LessonDTO() {
		super();
	}

	public Long getIdLesson() {
		return idLesson;
	}

	public void setIdLesson(Long idLesson) {
		this.idLesson = idLesson;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
}

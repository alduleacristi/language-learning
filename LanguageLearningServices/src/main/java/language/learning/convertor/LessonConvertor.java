package language.learning.convertor;

import language.learning.dto.LessonDTO;
import language.learning.model.Lesson;

public class LessonConvertor {
	public static Lesson convertToModel(LessonDTO lessonDTO) {
		Lesson lesson = new Lesson();
		lesson.setLessonName(lessonDTO.getLessonName());
		lesson.setIdLesson(lessonDTO.getIdLesson());

		return lesson;
	}

	public static LessonDTO convertToDTO(Lesson lesson) {
		LessonDTO lessonDTO = new LessonDTO();
		lessonDTO.setLessonName(lesson.getLessonName());
		lessonDTO.setIdLesson(lessonDTO.getIdLesson());

		return lessonDTO;
	}
}

package language.learning.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import language.learning.dao.LessonDAO;
import language.learning.exception.EntityNotFoundException;
import language.learning.model.Lesson;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LessonJaxRS {
	@Inject
	private LessonDAO lessonDAO;

	@GET
	@Path("/lesson")
	public List<Lesson> getAllLessons() {
		System.out.println("Trying to get all the lessons");
		return lessonDAO.getAllLessons();
	}

	@GET
	@Path("/lessonById")
	public Lesson getLessonById(@QueryParam("id") Long idLesson) {
		try {
			System.out.println("Trying to get lesson with id: [" + idLesson + "] Web Service");
			return lessonDAO.getLessonById(idLesson);
		} catch (EntityNotFoundException enf) {
			throw new NotFoundException(enf.getMessage());
		}
	}
}

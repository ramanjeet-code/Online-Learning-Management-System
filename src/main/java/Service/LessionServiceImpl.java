package Service;

import java.util.List;

import Dao.LessonDao;
import Entity.Lesson;
import Exception.SomeThingWentWrongException;

public class LessionServiceImpl implements LessionService{

	private LessonDao lessonDao;

    public void LessonServiceImpl(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    @Override
    public void createLesson(Lesson lesson) throws SomeThingWentWrongException {
        try {
           lessonDao.createLesson(lesson);
        } catch (SomeThingWentWrongException e) {
            // Handle the exception or rethrow it
        }
    }

    @Override
    public void updateLesson(Lesson lesson) throws SomeThingWentWrongException {
        try {
            lessonDao.updateLesson(lesson);
        } catch (SomeThingWentWrongException e) {
            // Handle the exception or rethrow it
        }
    }

    @Override
    public void deleteLesson(int lessonId) throws SomeThingWentWrongException {
        try {
            lessonDao.deleteLesson(lessonId);
        } catch (SomeThingWentWrongException e) {
            // Handle the exception or rethrow it
        }
    }

    @Override
    public Lesson getLessonById(int lessonId) throws SomeThingWentWrongException {
        try {
            return lessonDao.getLessonById(lessonId);
        } catch (SomeThingWentWrongException e) {
            // Handle the exception or rethrow it
        }
        return null;
    }

    @Override
    public List<Lesson> getAllLessons() throws SomeThingWentWrongException {
        try {
            return lessonDao.getAllLessons();
        } catch (SomeThingWentWrongException e) {
            // Handle the exception or rethrow it
        }
        return null;
    }

	@Override
	public int getLessonCount() throws SomeThingWentWrongException {
		 try {
	            return lessonDao.getLessonCount();
	        } catch (SomeThingWentWrongException e) {
	            // Handle the exception or rethrow it
	        }
	        return 0;
	}

	@Override
	public List<Lesson> getLessonsByCourse(Long courseId) throws SomeThingWentWrongException {
		  try {
	            return lessonDao.getLessonsByCourse(courseId);
	        } catch (SomeThingWentWrongException e) {
	            // Handle the exception or rethrow it
	        }
	        return null;
	}

}

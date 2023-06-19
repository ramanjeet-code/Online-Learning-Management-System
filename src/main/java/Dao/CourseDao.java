package Dao;

import java.util.List;

import Entity.Course;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;

public interface CourseDao {
	Course getCourseById(Long courseId)  throws SomeThingWentWrongException;;
	   List<Course> getAllCourses() throws SomeThingWentWrongException, NoRecordFoundException;
	   Course addCourse(Course course) throws SomeThingWentWrongException;
	    void deleteCourse(Long courseId) throws SomeThingWentWrongException, NoRecordFoundException;
	    void updateCourse(Long CourseId, String title, int duration) throws NoRecordFoundException, SomeThingWentWrongException;
}


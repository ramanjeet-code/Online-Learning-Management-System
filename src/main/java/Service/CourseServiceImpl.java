package Service;

import java.util.List;

import Dao.CourseDao;
import Dao.CourseDaoImpl;
import Entity.Course;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;

public class CourseServiceImpl implements CourseService {
	
	    public CourseServiceImpl() {
	      
	    }
	

	    @Override
	    public Course getCourseById(Long courseId) throws SomeThingWentWrongException {
	    	 CourseDao courseDao =new CourseDaoImpl();

	    	try {
	            return courseDao.getCourseById(courseId);
	        } catch (SomeThingWentWrongException e) {
	            throw e;
	        }
	    }

	    @Override
	    public List<Course> getAllCourses() throws SomeThingWentWrongException, NoRecordFoundException {
	   	 CourseDao courseDao =new CourseDaoImpl();
	    	try {
	            List<Course> courses = courseDao.getAllCourses();
	            if (courses.isEmpty()) {
	                throw new NoRecordFoundException("No courses found.");
	            }
	            return courses;
	        } catch (SomeThingWentWrongException | NoRecordFoundException e) {
	            throw e;
	        }
	    }

	    @Override
	    public Course addCourse(Course course) throws SomeThingWentWrongException {
	   	 CourseDao courseDao =new CourseDaoImpl();
	    	try {
	            return courseDao.addCourse(course);
	        } catch (SomeThingWentWrongException e) {
	            throw e;
	        }
	    }

	    @Override
	    public void deleteCourse(Long courseId) throws SomeThingWentWrongException, NoRecordFoundException {
	   	 CourseDao courseDao =new CourseDaoImpl();
	    	try {
	            courseDao.deleteCourse(courseId);
	        } catch (SomeThingWentWrongException | NoRecordFoundException e) {
	            throw e;
	        }
	    }


		@Override
		public void updateCourse(Long CourseId, String title, int duration) throws NoRecordFoundException, SomeThingWentWrongException {
			// TODO Auto-generated method stub
			 CourseDao courseDao =new CourseDaoImpl();
			 courseDao.updateCourse(CourseId,title,duration);
		}



	
}

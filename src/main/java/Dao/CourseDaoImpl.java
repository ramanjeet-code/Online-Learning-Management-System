package Dao;

import java.util.List;
import java.util.Scanner;

import Entity.Course;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;
import UI.AdminUI;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CourseDaoImpl implements CourseDao{
	 private EntityManager entityManager=EMUtils.getEntityManager();
	public CourseDaoImpl() {	
	}

	@Override

	    public Course getCourseById(Long courseId) throws SomeThingWentWrongException {
	        try {
	            return entityManager.find(Course.class, courseId);
	        } catch (Exception e) {
	            throw new SomeThingWentWrongException("Failed to retrieve course. Reason: " + e.getMessage());
	        }
	    }

	    @Override
	    public List<Course> getAllCourses() throws SomeThingWentWrongException, NoRecordFoundException {
	        try {
	            TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c", Course.class);
	            List<Course> courses = query.getResultList();
	            if (courses.isEmpty()) {
	                throw new NoRecordFoundException("No courses found.");
	            }
	            return courses;
	        } catch (Exception e) {
	            throw new SomeThingWentWrongException("Failed to retrieve courses. Reason: " + e.getMessage());
	        }
	    }

	    @Override
	    public Course addCourse(Course course) throws SomeThingWentWrongException {
	        try {
	            entityManager.getTransaction().begin();
	            entityManager.persist(course);
	            entityManager.getTransaction().commit();
	            return course;
	        } catch (Exception e) {
	            entityManager.getTransaction().rollback();
	            throw new SomeThingWentWrongException("Failed to add course. Reason: " + e.getMessage());
	        }
	    }

	    @Override
	    public void deleteCourse(Long courseId) throws SomeThingWentWrongException, NoRecordFoundException {
	        try {
	            Course course = entityManager.find(Course.class, courseId);
	            if (course == null) {
	                throw new NoRecordFoundException("Course not found with ID: " + courseId);
	            }
	            entityManager.getTransaction().begin();
	            entityManager.remove(course);
	            entityManager.getTransaction().commit();
	        } catch (NoRecordFoundException e) {
	            throw e;
	        } catch (Exception e) {
	            entityManager.getTransaction().rollback();
	            throw new SomeThingWentWrongException("Failed to delete course. Reason: " + e.getMessage());
	        }
	    }

		@Override
		public void updateCourse(Long CourseId, String title, int duration) throws NoRecordFoundException, SomeThingWentWrongException {
			// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			try {
				 Course course = entityManager.find(Course.class, CourseId);
				  if (course == null) {
		                System.out.println("Course not found with ID: " + CourseId);
		                AdminUI.courseMenu(sc);
		            }
					 
			
				 entityManager.getTransaction().begin();
				 course.setDuration(duration);
				 course.setTitle(title);
				
				 entityManager.persist(course);
				 entityManager.getTransaction().commit();
			} catch (Exception e) {
				 entityManager.getTransaction().rollback();
				 throw new SomeThingWentWrongException("Please check Entered id again may be there is not data of this id");
				 
			 }
			}
		}


		
		


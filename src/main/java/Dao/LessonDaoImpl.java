package Dao;

import java.util.List;

import Entity.Lesson;
import Exception.SomeThingWentWrongException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class LessonDaoImpl implements LessonDao{
	private EntityManager entityManager;
	public LessonDaoImpl() {
		// TODO Auto-generated constructor stub
		entityManager = EMUtils.getEntityManager();
	}

	@Override
	public void createLesson(Lesson lesson) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(lesson);
			entityManager.getTransaction().commit();
			
			
		} catch (Exception e) {
			  entityManager.getTransaction().rollback();
	            throw new SomeThingWentWrongException("Failed to add grade. Reason: " + e.getMessage());
		}
	}

	public void updateLesson(Lesson lesson) throws SomeThingWentWrongException {
	    try {
	        entityManager.getTransaction().begin();
	        entityManager.merge(lesson);
	        entityManager.getTransaction().commit();
	    } catch (Exception e) {
	        entityManager.getTransaction().rollback();
	        throw new SomeThingWentWrongException("Failed to update lesson. Reason: " + e.getMessage());
	    }
	}

	@Override
	public void deleteLesson(int lessonId) throws SomeThingWentWrongException {
	    try {
	        entityManager.getTransaction().begin();
	        Lesson lesson = entityManager.find(Lesson.class, lessonId);
	        entityManager.remove(lesson);
	        entityManager.getTransaction().commit();
	    } catch (Exception e) {
	        entityManager.getTransaction().rollback();
	        throw new SomeThingWentWrongException("Failed to delete lesson. Reason: " + e.getMessage());
	    }
	}

	@Override
	public Lesson getLessonById(int lessonId) throws SomeThingWentWrongException {
	    try {
	        return entityManager.find(Lesson.class, lessonId);
	    } catch (Exception e) {
	        throw new SomeThingWentWrongException("Failed to retrieve lesson by ID. Reason: " + e.getMessage());
	    }
	}

	@Override
	
		public List<Lesson> getAllLessons() throws SomeThingWentWrongException {
		    try {
		        TypedQuery<Lesson> query = entityManager.createQuery("SELECT l FROM Lesson l", Lesson.class);
		        return query.getResultList();
		    } catch (Exception e) {
		        throw new SomeThingWentWrongException("Failed to retrieve all lessons. Reason: " + e.getMessage());
		    }
		}

		@Override
		public List<Lesson> getLessonsByCourse(Long courseId) throws SomeThingWentWrongException {
		    try {
		        TypedQuery<Lesson> query = entityManager.createQuery("SELECT l FROM Lesson l WHERE l.courseId = :courseId", Lesson.class);
		        query.setParameter("courseId", courseId);
		        return query.getResultList();
		    } catch (Exception e) {
		        throw new SomeThingWentWrongException("Failed to retrieve lessons by course ID. Reason: " + e.getMessage());
		    }
		}

		@Override
		public int getLessonCount() throws SomeThingWentWrongException {
		    try {
		        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(l) FROM Lesson l", Long.class);
		        return query.getSingleResult().intValue();
		    } catch (Exception e) {
		        throw new SomeThingWentWrongException("Failed to retrieve lesson count. Reason: " + e.getMessage());
		    }
	}
	}
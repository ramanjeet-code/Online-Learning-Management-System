package Dao;

import java.time.LocalDate;
import java.util.List;

import Entity.Course;
import Entity.Enrollment;
import Entity.Student;
import Exception.SomeThingWentWrongException;
import Service.EnrollmentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class EnrollmentDaoImpl implements EnrollmentDao{

	public EnrollmentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enrollStudent(Long courseId, Long studentId) throws SomeThingWentWrongException {
		EntityManager entityManager = null;
		try {
			entityManager=EMUtils.getEntityManager();
		
		        entityManager.getTransaction().begin();

		        // Check if the enrollment already exists
		        Enrollment enrollment = entityManager.createQuery("SELECT e FROM Enrollment e WHERE e.course.id = :courseId AND e.student.id = :studentId", Enrollment.class)
		                .setParameter("courseId", courseId)
		                .setParameter("studentId", studentId)
		                .getSingleResult();

		        if (enrollment != null) {
		            throw new SomeThingWentWrongException("Student is already enrolled in the course.");
		        }

		        // Retrieve the student and course entities
		        Student student = entityManager.find(Student.class, studentId);
		        Course course = entityManager.find(Course.class, courseId);

		        // Create a new enrollment
		        enrollment = new Enrollment(student, course, LocalDate.now());
		        entityManager.persist(enrollment);

		        entityManager.getTransaction().commit();
		    } catch (NoResultException e) {
		        // Enrollment doesn't exist, proceed with enrollment creation
		        try {
		            Student student = entityManager.find(Student.class, studentId);
		            Course course = entityManager.find(Course.class, courseId);
		            Enrollment enrollment = new Enrollment(student, course, LocalDate.now());
		            entityManager.persist(enrollment);
		            entityManager.getTransaction().commit();
		        } catch (Exception ex) {
		            entityManager.getTransaction().rollback();
		            throw new SomeThingWentWrongException("Failed to enroll student in the course."+ex);
		        }
		    }
		
	}

	@Override
	public void dropStudent(Long courseId, Long studentId) throws SomeThingWentWrongException {
		EntityManager entityManager = null;
		try {
			entityManager=EMUtils.getEntityManager();
		
		        entityManager.getTransaction().begin();

		        // Check if the enrollment exists
		        Enrollment enrollment = entityManager.createQuery("SELECT e FROM Enrollment e WHERE e.course.id = :courseId AND e.student.id = :studentId", Enrollment.class)
		                .setParameter("courseId", courseId)
		                .setParameter("studentId", studentId)
		                .getSingleResult();

		        if (enrollment == null) {
		            throw new SomeThingWentWrongException("No enrollment found for the student in the course.");
		        }

		        // Remove the enrollment
		        entityManager.remove(enrollment);

		        entityManager.getTransaction().commit();
		    } catch (NoResultException e) {
		        throw new SomeThingWentWrongException("No enrollment found for the student in the course.");
		    } catch (Exception e) {
		        entityManager.getTransaction().rollback();
		        throw new SomeThingWentWrongException("Failed to drop student from the course."+ e);
		    }
		
	}

	@Override
	public List<Enrollment> getEnrollmentsByCourse(Long courseId) throws SomeThingWentWrongException {
		EntityManager entityManager = null;
		try {
			entityManager=EMUtils.getEntityManager();
	        entityManager.getTransaction().begin();

	        List<Enrollment> enrollments = entityManager.createQuery("SELECT e FROM Enrollment e WHERE e.course.id = :courseId", Enrollment.class)
	                .setParameter("courseId", courseId)
	                .getResultList();

	        entityManager.getTransaction().commit();
	        
	        return enrollments;
	    } catch (Exception e) {
	        entityManager.getTransaction().rollback();
	        throw new SomeThingWentWrongException("Failed to retrieve enrollments by course."+ e);
	    }
	}

	@Override
	public List<Enrollment> getEnrollmentsByStudent(Long studentId) throws SomeThingWentWrongException {
		EntityManager entityManager = null;
		try {
			entityManager=EMUtils.getEntityManager();
	        entityManager.getTransaction().begin();

	        List<Enrollment> enrollments = entityManager.createQuery("SELECT e FROM Enrollment e WHERE e.student.id = :studentId", Enrollment.class)
	                .setParameter("studentId", studentId)
	                .getResultList();

	        entityManager.getTransaction().commit();
	        
	        return enrollments;
	    } catch (Exception e) {
	        entityManager.getTransaction().rollback();
	        throw new SomeThingWentWrongException("Failed to retrieve enrollments by student."+e);
	    }
	}

	@Override
	public boolean isEnrolled(Long courseId, Long studentId) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTotalEnrolledStudents(Long courseId) throws SomeThingWentWrongException {
		EntityManager entityManager = null;
		try {
			entityManager=EMUtils.getEntityManager();
	        entityManager.getTransaction().begin();

	        Long count = entityManager.createQuery("SELECT COUNT(e) FROM Enrollment e WHERE e.course.id = :courseId", Long.class)
	                .setParameter("courseId", courseId)
	                .getSingleResult();

	        entityManager.getTransaction().commit();
	        
	        return count.intValue();
	    } catch (Exception e) {
	        entityManager.getTransaction().rollback();
	        throw new SomeThingWentWrongException("Failed to get total enrolled students for the course."+ e);
	    }
	}

	@Override
	public Enrollment getEnrollmentById(Long enrollmentId) throws SomeThingWentWrongException {
		EntityManager entityManager = null;
		try {
			entityManager=EMUtils.getEntityManager();
	            return entityManager.find(Enrollment.class, enrollmentId);
	        } catch (Exception e) {
	            // Handle any exceptions or log the error
	            return null;
	        }
	}

}

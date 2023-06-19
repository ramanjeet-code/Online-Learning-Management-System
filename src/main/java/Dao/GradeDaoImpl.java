package Dao;

import java.util.List;

import Entity.Grade;
import Exception.SomeThingWentWrongException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class GradeDaoImpl implements GradeDao {
	private EntityManager entityManager;
	public GradeDaoImpl() {
		// TODO Auto-generated constructor stub
		entityManager = EMUtils.getEntityManager();
	}

	@Override
	public void addGrade(Grade grade) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		 try {
	            entityManager.getTransaction().begin();
	            entityManager.persist(grade);
	            entityManager.getTransaction().commit();
	        } catch (Exception e) {
	            entityManager.getTransaction().rollback();
	            throw new SomeThingWentWrongException("Failed to add grade. Reason: " + e.getMessage());
	        }
	}

	@Override
	public void updateGrade(Grade grade) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		try {
            entityManager.getTransaction().begin();
            entityManager.merge(grade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new SomeThingWentWrongException("Failed to update grade. Reason: " + e.getMessage());
        }
	}

	@Override
	public void deleteGrade(Long gradeId) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		try {
            entityManager.getTransaction().begin();
            Grade grade = entityManager.find(Grade.class, gradeId);
            entityManager.remove(grade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new SomeThingWentWrongException("Failed to delete grade. Reason: " + e.getMessage());
        }
	}

	@Override
	public Grade getGradeById(Long gradeId) throws SomeThingWentWrongException {
		try {
            return entityManager.find(Grade.class, gradeId);
        } catch (Exception e) {
            throw new SomeThingWentWrongException("Failed to get grade by ID. Reason: " + e.getMessage());
        }
	}

	@Override
	public List<Grade> getGradesByStudent(Long studentId) throws SomeThingWentWrongException {
		  try {
	            TypedQuery<Grade> query = entityManager.createQuery("SELECT g FROM Grade g WHERE g.student.id = :studentId", Grade.class);
	            query.setParameter("studentId", studentId);
	            return query.getResultList();
	        } catch (Exception e) {
	            throw new SomeThingWentWrongException("Failed to get grades by student ID. Reason: " + e.getMessage());
	        }
	    
	} 

	public List<Grade> getGradesByCourse(Long courseId) throws SomeThingWentWrongException {
        try {
            TypedQuery<Grade> query = entityManager.createQuery("SELECT g FROM Grade g WHERE g.course.id = :courseId", Grade.class);
            query.setParameter("courseId", courseId);
            return query.getResultList();
        } catch (Exception e) {
            throw new SomeThingWentWrongException("Failed to get grades by course ID. Reason: " + e.getMessage());
        }
    }

    @Override
    public double getAverageGradeForCourse(Long courseId) throws SomeThingWentWrongException {
        try {
            TypedQuery<Double> query = entityManager.createQuery("SELECT AVG(g.grade) FROM Grade g WHERE g.course.id = :courseId", Double.class);
            query.setParameter("courseId", courseId);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new SomeThingWentWrongException("Failed to get average grade for course. Reason: " + e.getMessage());
        }
    }

}

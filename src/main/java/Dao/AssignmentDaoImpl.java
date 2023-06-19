package Dao;

import java.util.List;

import Entity.Assignment;
import Exception.SomeThingWentWrongException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AssignmentDaoImpl implements AssignmentDao {

	public AssignmentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createAssignement(Assignment assignement) throws SomeThingWentWrongException {
		EntityManager em = null;
		 EntityTransaction tx = null;
		try {
			em=EMUtils.getEntityManager();
	            tx = em.getTransaction();
	            tx.begin();
	            em.persist(assignement);
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null && tx.isActive()) {
	                tx.rollback();
	            }
	            throw new SomeThingWentWrongException("Failed to create assignment"+ e);
	        } finally {
	            em.close();
	        }

	}

	@Override
	public Assignment getAssignementById(Long assignementId) throws SomeThingWentWrongException {
		EntityManager em = null;
		 EntityTransaction tx = null;
		try {
			em=EMUtils.getEntityManager();
	            return em.find(Assignment.class, assignementId);
	        } catch (Exception e) {
	            throw new SomeThingWentWrongException("Failed to get assignment by ID"+ e);
	        } finally {
	            em.close();
	        }
	}

	@Override
	public List<Assignment> getAllAssignements() throws SomeThingWentWrongException {
		EntityManager em = null;
		 EntityTransaction tx = null;
		try {
			em=EMUtils.getEntityManager();
            return em.createQuery("SELECT a FROM Assignment a", Assignment.class).getResultList();
        } catch (Exception e) {
            throw new SomeThingWentWrongException("Failed to get all assignments"+ e);
        } finally {
            em.close();
        }
		
	}

	@Override
	public     void updateAssignement(Assignment assignement) throws SomeThingWentWrongException {
		EntityManager em = null;
		 EntityTransaction tx = null;
		try {
			em=EMUtils.getEntityManager();
	            tx = em.getTransaction();
	            tx.begin();
	            em.merge(assignement);
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null && tx.isActive()) {
	                tx.rollback();
	            }
	            throw new SomeThingWentWrongException("Failed to update assignment"+e);
	        } finally {
	            em.close();
	        }
	}

	@Override
	public void deleteAssignement(Long assignementId) throws SomeThingWentWrongException {
		EntityManager em = null;
		 EntityTransaction tx = null;
		try {
			em=EMUtils.getEntityManager();
            tx = em.getTransaction();
            tx.begin();
            Assignment assignment = em.find(Assignment.class, assignementId);
            if (assignment != null) {
                em.remove(assignment);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new SomeThingWentWrongException("Failed to delete assignment"+ e);
        } finally {
            em.close();
        }
    }
		
	

}

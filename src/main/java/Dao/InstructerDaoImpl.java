package Dao;

import java.util.List;

import Entity.Instructor;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class InstructerDaoImpl implements InstructerDao {

	public InstructerDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addInstructer(Instructor inst) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;// TODO Auto-generated method stub
		try {
			em=EMUtils.getEntityManager();
			Query query=em.createQuery("SELECT COUNT(c) FROM Instructor c where email=:email");
			query.setParameter("email", inst.getEmail());
			if((Long)query.getSingleResult()>0) {
				System.out.println("The username" + inst.getEmail() + " is already Registered");
				throw new SomeThingWentWrongException("The username" +  inst.getEmail()+ " is already Registered");
			}
			EntityTransaction tx=em.getTransaction();
			  tx.begin();
			  em.persist(inst);
			  tx.commit();
			
		} catch (Exception e) {
			throw new SomeThingWentWrongException("Unable to process request, try again later"+e);
		}finally{
			 if (em != null) {
			        em.close();
			    }
		}
	}
	

	@Override
	public void login(String email, String password) throws SomeThingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			Query query = em.createQuery("SELECT c.id FROM Instructor c WHERE email = :email AND password = :email");
			query.setParameter("email", email);
			query.setParameter("password", password);
			List<Integer> listInt = (List<Integer>)query.getResultList();
			if(listInt.size() == 0) {
				//you are here means company with given name exists so throw exceptions
				throw new SomeThingWentWrongException("The username or password is incorrect");
			}
			
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}// TOD
		
	}

}

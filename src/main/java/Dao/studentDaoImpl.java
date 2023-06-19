package Dao;

import java.util.List;


import Entity.Student;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class studentDaoImpl implements StudentDao {
	private EntityManager entityManager;
	public studentDaoImpl() {
		entityManager = EMUtils.getEntityManager();
	}

	@Override
	public void addStudent(Student student) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		  try {
	            entityManager.getTransaction().begin();
	            entityManager.persist(student);
	            entityManager.getTransaction().commit();
	        } catch (Exception e) {
	            entityManager.getTransaction().rollback();
	            e.printStackTrace();
	        }
	}

	@Override
	public void updateStudent(Student student) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		  try {
	            entityManager.getTransaction().begin();
	            entityManager.merge(student);
	            entityManager.getTransaction().commit();
	        } catch (Exception e) {
	            entityManager.getTransaction().rollback();
	            e.printStackTrace();
	        }
	}

	@Override
	public void deleteStudent(Long studentId) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		 try {
	            entityManager.getTransaction().begin();
	            Student student = entityManager.find(Student.class, studentId);
	            if (student != null) {
	                entityManager.remove(student);
	            }
	            entityManager.getTransaction().commit();
	        } catch (Exception e) {
	            entityManager.getTransaction().rollback();
	            e.printStackTrace();
	        }
	}

	@Override
	public Student getStudentById(Long studentId) throws NoRecordFoundException {
		  return entityManager.find(Student.class, studentId);
	}

	@Override
	public List<Student> getAllStudents() throws SomeThingWentWrongException, NoRecordFoundException {
		 TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
	        return query.getResultList();
	}

	@Override
	public void login(String email, String password) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		try {
			Query query = entityManager.createQuery("SELECT c.id FROM Student c WHERE email = :email AND password = :password AND isActive = 0");
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
			entityManager.close();
		}// TODO Auto-generated method stub
		
		
	}

}

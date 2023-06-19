package Service;

import java.util.List;

import Dao.AssignmentDao;
import Dao.AssignmentDaoImpl;
import Entity.Assignment;
import Exception.SomeThingWentWrongException;

public class AssignementServiceImpl implements AssignementService{

	public AssignementServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createAssignement(Assignment assignement) throws SomeThingWentWrongException {
		AssignmentDao assignmentDao= new AssignmentDaoImpl();
		  assignmentDao.createAssignement(assignement);
	}

	@Override
	public Assignment getAssignementById(Long assignementId) throws SomeThingWentWrongException {
		AssignmentDao assignmentDao= new AssignmentDaoImpl();
		 return assignmentDao.getAssignementById(assignementId);
    }
	

	@Override
	public List<Assignment> getAllAssignements() throws SomeThingWentWrongException {
		AssignmentDao assignmentDao= new AssignmentDaoImpl(); 
		return assignmentDao.getAllAssignements();
	}

	@Override
	public void updateAssignement(Assignment assignement) throws SomeThingWentWrongException {
		AssignmentDao assignmentDao= new AssignmentDaoImpl(); 
		 assignmentDao.updateAssignement(assignement);
	}

	@Override
	public void deleteAssignement(Long assignementId) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		AssignmentDao assignmentDao= new AssignmentDaoImpl(); 
		 assignmentDao.deleteAssignement(assignementId);
	}

}

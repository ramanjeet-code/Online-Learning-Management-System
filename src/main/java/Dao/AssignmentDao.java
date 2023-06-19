package Dao;

import java.util.List;

import Entity.Assignment;
import Exception.SomeThingWentWrongException;

public interface AssignmentDao {
	 void createAssignement(Assignment assignement) throws SomeThingWentWrongException;

	 Assignment getAssignementById(Long assignementId) throws SomeThingWentWrongException;

	    List<Assignment> getAllAssignements() throws SomeThingWentWrongException;

	    void updateAssignement(Assignment assignement) throws SomeThingWentWrongException;

	    void deleteAssignement(Long assignementId) throws SomeThingWentWrongException;

}

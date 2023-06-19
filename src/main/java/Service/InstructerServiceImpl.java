package Service;

import Dao.InstructerDao;
import Dao.InstructerDaoImpl;
import Entity.Instructor;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;

public class InstructerServiceImpl implements InstructerService{

	public InstructerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addInstructer(Instructor inst) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		InstructerDao instDao=new InstructerDaoImpl();
		 instDao.addInstructer(inst);
	}

	@Override
	public void login(String email, String password) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		InstructerDao instDao=new InstructerDaoImpl();
		instDao.login(email, password);
	}

}

package services;

import java.util.List;

import daos.ReimbursementDao;
import daos.ReimbursementHibernate;
import exceptions.UserNotFoundException;
import models.Reimbursement;


public class ReimbursementService {
	
	private ReimbursementDao rd = new ReimbursementHibernate();

	
	public Reimbursement getReimbursementById(int id) throws UserNotFoundException {
		Reimbursement r = rd.getReimbursementById(id);
		if (r == null) {
			throw new UserNotFoundException();
		}
		return r;
	}
	
	public List<Reimbursement> getReimbursement(){
		
		List<Reimbursement> reim = rd.getReimbursement();
		
		return reim;
	}
}

package daos;

import java.util.List;

import org.hibernate.Session;

import models.Reimbursement;
import models.User;
import util.HibernateUtil;

public class ReimbursementHibernate implements ReimbursementDao {

	@Override
	public Reimbursement createReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
			Reimbursement reim = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			reim = s.get(Reimbursement.class, id);
		}
		
		return reim;
	}

	@Override
	public Reimbursement getReimbursementByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursement() {
		List<Reimbursement> reim = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			reim = s.createQuery("from Reimbursement", Reimbursement.class).list();
		}
		
		return reim;
	}

}

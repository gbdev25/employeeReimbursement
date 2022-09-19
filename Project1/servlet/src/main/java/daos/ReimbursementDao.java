package daos;

import java.util.List;

import models.Reimbursement;

public interface ReimbursementDao {

	Reimbursement createReimbursement(Reimbursement r );
	Reimbursement getReimbursementById(int id);
	Reimbursement getReimbursementByUsername(String username);
	List<Reimbursement> getReimbursement();

}

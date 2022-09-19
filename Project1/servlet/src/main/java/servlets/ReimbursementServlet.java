package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dtos.UserDto;
import exceptions.UserNotFoundException;
import models.Reimbursement;
import models.User;
import services.ReimbursementService;
import util.CorsFix;

public class ReimbursementServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ReimbursementService rs = new ReimbursementService();
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type","application/json" );
		
		String pathInfo = req.getPathInfo();
		
		if (pathInfo == null) {
			
			List<Reimbursement> reimburse = rs.getReimbursement();
			List<Reimbursement> reim = new ArrayList<>();
			reimburse.forEach(r-> reim.add(r));
			PrintWriter pw = res.getWriter();
			pw.write(om.writeValueAsString(reim));
			pw.close();
			
		} else {
			// /1, /11, /{some-value}
			// Have to remove "/" to get the id to be retrieved
			int id = Integer.parseInt(pathInfo.substring(1));

			try (PrintWriter pw = res.getWriter()) {
				// retrieve user by id
				Reimbursement r = rs.getReimbursementById(id);
				

				// convert user to JSON and write to response body
				pw.write(om.writeValueAsString(r));

				res.setStatus(200);
			} catch (UserNotFoundException e) {
				
				res.setStatus(404);
				e.printStackTrace();
			}
		}
	}
}

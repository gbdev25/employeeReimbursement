package daos;

import java.util.List;

import models.User;

public interface UserDao {
	
	User insertUser(User u);
	User getUserById(int id);
	User getUserByUsername(String username);
	List<User> getUsers();
}



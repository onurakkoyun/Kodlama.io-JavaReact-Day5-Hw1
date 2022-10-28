package eCommercePackages.business.abstracts;


import java.util.List;

import eCommercePackages.entities.concretes.User;

public interface IUserService {
	
	void signUp(User user, List<User> userList);
	void signIn(String email, String password, List<User> userList);
	

}

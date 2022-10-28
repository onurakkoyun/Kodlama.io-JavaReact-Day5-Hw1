package eCommercePackages.dataAccess.abstracts;

import java.util.List;

import eCommercePackages.entities.concretes.User;

public interface IGoogleUserDao {
	void signUp(User user, List<User> userList);
	void signIn(User user, List<User> userList);

}

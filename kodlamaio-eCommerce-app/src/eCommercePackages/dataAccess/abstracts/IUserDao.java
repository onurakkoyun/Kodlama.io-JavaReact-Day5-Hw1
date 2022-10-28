package eCommercePackages.dataAccess.abstracts;

import java.util.List;

import eCommercePackages.entities.concretes.User;

public interface IUserDao {

	void signUp(User user, List<User> userList);
	void signIn(User user, List<User> userList);
}

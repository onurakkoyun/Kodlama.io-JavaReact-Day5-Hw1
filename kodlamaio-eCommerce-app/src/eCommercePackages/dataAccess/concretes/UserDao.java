package eCommercePackages.dataAccess.concretes;

import java.util.List;

import eCommercePackages.dataAccess.abstracts.IUserDao;
import eCommercePackages.entities.concretes.User;

public class UserDao implements IUserDao{

	@Override
	public void signUp(User user, List<User> userList) {
		System.out.println("Signing up is successful.\n");
	}

	@Override
	public void signIn(User user, List<User> userList) {
		
	}

}

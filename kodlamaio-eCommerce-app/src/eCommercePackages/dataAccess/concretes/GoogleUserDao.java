package eCommercePackages.dataAccess.concretes;

import java.util.List;

import eCommercePackages.dataAccess.abstracts.IGoogleUserDao;
import eCommercePackages.entities.concretes.User;

public class GoogleUserDao implements IGoogleUserDao{

	@Override
	public void signUp(User user, List<User> userList) {
		System.out.println("Signing up is successful with Google account.\n");
		
	}

	@Override
	public void signIn(User user, List<User> userList) {
		
	}

}

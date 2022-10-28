package eCommercePackages.business.abstracts;

import java.util.List;

import eCommercePackages.entities.concretes.User;

public interface IUserCheckService {
	boolean checkUserInfo(User user, List<User> userList);
	boolean IsEmailVerified(User user, List<User> userList);
	boolean validateEmail(User user);
	boolean isEmailUnique(User user, List<User> userList);

}

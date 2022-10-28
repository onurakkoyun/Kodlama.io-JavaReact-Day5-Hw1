package eCommercePackages.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommercePackages.business.abstracts.IUserCheckService;
import eCommercePackages.business.abstracts.IUserService;
import eCommercePackages.dataAccess.concretes.GoogleUserDao;
import eCommercePackages.entities.concretes.User;

public class GoogleUserManager implements IUserService{
	
	private IUserCheckService userCheckService;
    private GoogleUserDao googleUserDao;

	public GoogleUserManager(GoogleUserDao googleUserDao, IUserCheckService userCheckService) {
		this.googleUserDao = googleUserDao;
		this.userCheckService = userCheckService;
	}

	@Override
	public void signUp(User user, List<User> userList) {

		if (userCheckService.checkUserInfo(user, userList)) {
			userList.add(user);
			googleUserDao.signUp(user, userList);
		}
	}

	@Override
	public void signIn(String email, String password,List<User> userList) {
		
		boolean checkSign = false;
		for (int i = 0; i < userList.size(); i++) {
			
			if (userList.get(i).getEmail().equals(email) && userList.get(i).getPassword().equals(password)) {
				System.out.println("Login successful");
				checkSign = true;
			}
		}
		
		if (!checkSign) {
			System.out.println("Email or password is incorrect!");
		}
	}

}

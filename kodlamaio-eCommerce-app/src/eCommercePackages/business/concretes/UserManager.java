package eCommercePackages.business.concretes;

import java.util.List;

import eCommercePackages.business.abstracts.IUserService;
import eCommercePackages.dataAccess.concretes.UserDao;
import eCommercePackages.entities.concretes.User;

public class UserManager implements IUserService{
	
	
    private UserCheckManager userCheckManager;
	private UserDao userDao;
	
	public UserManager(UserDao userDao, UserCheckManager userCheckManager) {
		this.userDao = userDao;
		this.userCheckManager = userCheckManager;
	}

	@Override
	public void signUp(User user, List<User> userList) {
		if (userCheckManager.checkUserInfo(user, userList)) {
			userList.add(user);
			userDao.signUp(user,userList);
		}
	}

	@Override
	public void signIn(String email, String password, List<User> userList) {
		
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

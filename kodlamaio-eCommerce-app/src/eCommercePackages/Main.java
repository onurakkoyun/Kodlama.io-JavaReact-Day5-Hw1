package eCommercePackages;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import eCommercePackages.business.abstracts.IUserService;
import eCommercePackages.business.concretes.GoogleUserManager;
import eCommercePackages.business.concretes.UserCheckManager;
import eCommercePackages.dataAccess.concretes.GoogleUserDao;
import eCommercePackages.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		List<User> userList = new ArrayList<>();
		
		IUserService userService = new GoogleUserManager(new GoogleUserDao(), new UserCheckManager());
		
		User user1 = new User("Onur", "AKKOYUN", "onur@gmail.com", "123456");
		userService.signUp(user1,userList);
		
		User user2 = new User("Can", "AKKOYUN", "can@gmail.com", "654321");
		userService.signUp(user2, userList);
		
		System.out.print("Your e-mail : ");
		String email = scanner.nextLine();
		System.out.print("Your password : ");
		String password = scanner.nextLine();
		userService.signIn(email, password, userList);
		
		
		

	}

}

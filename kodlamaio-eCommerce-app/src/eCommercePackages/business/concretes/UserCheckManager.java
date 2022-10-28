package eCommercePackages.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommercePackages.business.abstracts.IUserCheckService;
import eCommercePackages.entities.concretes.User;

public class UserCheckManager implements IUserCheckService{
	
	private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public boolean checkUserInfo(User user, List<User> userList) {
		if (user.getFirstName() != null  && user.getLastName() != null && user.getEmail() != null && user.getPassword() != null) {
			if (user.getPassword().length() >= 6) {
				
				if (validateEmail(user)) {
					if (isEmailUnique(user, userList)) {
						
						if (user.getFirstName().length() >=  2 && user.getLastName().length() >=  2) {
							
							if (IsEmailVerified(user, userList)) {
								return true;
							}
						}
						else {
							System.out.println("Name and surname must be at least 2 digits!");
							return false;
						}
					}
					else {
						System.out.println("Email is not unique");
						return false;
					}
					
				}
				else {
					System.out.println("Invalid e-mail address");
					return false;
				}
				
			}
			else 
			{
				System.out.println("Password length must be at least 6 digits!");
				return false;
			}
		}
		else {
			System.out.println("User information must be entered completely!");
			return false;
		}
		return false;
	}

	@Override
	public boolean IsEmailVerified(User user, List<User> userList) {
		if (true) {
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean validateEmail(User user) {
		pattern = Pattern.compile(EMAIL_REGEX);
		matcher = pattern.matcher(user.getEmail());
        return matcher.matches();
	}

	@Override
	public boolean isEmailUnique(User user, List<User> userList) {
		boolean checkEmail = true;
		for (int i = 0; i < userList.size(); i++) {
			
			if (userList.get(i).getEmail().equals(user.getEmail())) {
				checkEmail = false;
			}
		}
		if (checkEmail) {
			return true;
		}
		else
			return false;
	}

}

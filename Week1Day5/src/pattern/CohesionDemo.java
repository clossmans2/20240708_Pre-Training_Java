package pattern;

// Coupling & Cohesion
// Coupling: The degree to all classes in an application depend on or know about other
// classes inside the application.  We want loose coupling = because it means changes
// in one class are less likely to affect another, and makes maintenance easier
// Cohesion: how closely related the responsibilities of a single class are
// High cohesion = everything in a class is focused on a single task
// Low cohesion = a class tries to do everything

public class CohesionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


// Tight Coupling
//class UserService {
//	EmailService emailService = new EmailService();
//	
//	void registerUser(String username) {
//		emailService.sendEmail("Welcome " + username);
//	}
//}

// Looser Coupling
//class UserService {
//	private EmailService emailService;
//	
//	public UserService(EmailService emailService) {
//		this.emailService = emailService;
//	}
//	
//	void registerUser(String username) {
//		emailService.sendEmail("Welcome " + username);
//	}
//}

// Loose Coupling
interface INotificationService {
	void sendMessage(String msg);
}

class EmailService implements INotificationService {
	public void sendMessage(String msg) {
		// logic to send email
	}
}

class UserService {
	private INotificationService emailService;
	
	public UserService(INotificationService emailService) {
		this.emailService = emailService;
	}
	
	void registerUser(String username) {
		emailService.sendMessage("Welcome " + username);
	}
}





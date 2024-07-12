package pattern;

public class SingletonDemo {

	public static void main(String[] args) {
		DatabaseConnectionService dbConn = 
				DatabaseConnectionService.getInstance("my connection string");
	}

}

final class DatabaseConnectionService {
	private static DatabaseConnectionService instance;
	private String connectionString;
	
	// Private constructor
	private DatabaseConnectionService(String connString) {
		this.connectionString = connString;
	}
	
	// Static creation method
	public static DatabaseConnectionService getInstance(String connString) {
		if (instance == null) {
			instance = new DatabaseConnectionService(connString);
		}
		return instance;
	}
}
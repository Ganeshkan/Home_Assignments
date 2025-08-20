package week3.day2;

public class JavaConnection implements DatabaseConnection{



	public static void main(String[] args) {
		JavaConnection jc = new JavaConnection();
		jc.connect();
		jc.disconnect();
		jc.executeUpdate();
	}

	@Override
	public void connect() {
		System.out.println("Connected to database");

	}

	@Override
	public void disconnect() {
		System.out.println("Disconnected from database");

	}

	@Override
	public void executeUpdate() {
		System.out.println("Executed database update");

	}

}

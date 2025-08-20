package week3.day1.Polymorphism;

public class APIClient {
	//method with one argument
	public void sendRequest(String endpoint) {
		System.out.println(endpoint);
	}

	//method with three argument
	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		System.out.println(endpoint + " " +requestBody+" "+ requestStatus);
	}

	public static void main(String[] args) {
		APIClient api = new APIClient();
		api.sendRequest("120.098.98");
		api.sendRequest("120.098.98", "GET", false);
	}
}

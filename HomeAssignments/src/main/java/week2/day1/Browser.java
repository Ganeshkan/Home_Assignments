package week2.day1;

public class Browser {
	static String browsername= "Edge";
	
public static void main(String[] args) {
	Browser browser = new Browser();
	System.out.println(browser.launchBrowser(browsername));
	browser.loadUrl();
}

String launchBrowser(String browsername) {
	return browsername;
}

void loadUrl() {
	System.out.println("Url loaded successfully");
}


}

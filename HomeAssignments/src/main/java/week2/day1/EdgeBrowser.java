package week2.day1;

public class EdgeBrowser {
	static String browsername = "EdgeBrowser";
	public static void main(String[] args) {
		Browser browser = new Browser();
		System.out.println(browser.launchBrowser(browsername));
		browser.loadUrl();

	}

}

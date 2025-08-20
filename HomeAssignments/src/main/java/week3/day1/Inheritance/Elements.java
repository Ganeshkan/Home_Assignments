package week3.day1.Inheritance;

public class Elements extends Button {

	public static void main(String[] args) {
		//button subclasses inherits from WebElement base class
		Button ob1 = new Button();
		ob1.settext();
		ob1.click();
		ob1.submit();
		System.out.println();
		// TextField subclasses inherits from WebElement base class
		TextField ob4 = new TextField();
		ob4.click();
		ob4.settext();
		ob4.getText();
		System.out.println();
		//CheckBoxButton subclasses inherits from Button subclasses class and Button subclasses inherits from WebElement base class
		CheckBoxButton ob2 = new CheckBoxButton();
		ob2.settext();
		ob2.submit();
		ob2.clickCheckButton();
		ob2.click();
		System.out.println();
		//RadioButton subclasses inherits from Button subclasses class and Button subclasses inherits from WebElement base class
		RadioButton ob3 = new RadioButton();
		ob3.click();
		ob3.selectRadioButton();
		ob3.submit();
		ob3.settext();

	}

}

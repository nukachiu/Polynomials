package MVC;
import Model.*;
import View.*;
import Controller.*;

public class MVC {

	public static void main(String[] args) {
		MyPanel myPanel = new MyPanel();
		MyModel myModel = new MyModel();
		
		MyController myController = new MyController(myModel,myPanel);
	}

}

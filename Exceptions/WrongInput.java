package Exceptions;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WrongInput extends Exception{
	public WrongInput()
	{
		super("Ati introdus o valoare nepermisa!");
		JFrame frame = new JFrame ("Simple Frame");
		JDialog a = new JDialog(frame,"Rezultat");
		a.add(new JLabel("Input invalid!"));
		a.setSize(500,500);
		a.setVisible(true);
		a.setLocation(100,100);
	}
}

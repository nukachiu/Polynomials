package Controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Exceptions.*;

import Model.*;
import View.*;

public class MyController {
	private MyModel myModel;
	private MyPanel myPanel;

	public MyController(MyModel newModel, MyPanel newPanel)
	{
		this.myModel = newModel;
		this.myPanel = newPanel;

		this.myPanel.addButtonListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e)
		{
			Polinom p1, p2;
			try {
				for(int i = 0; i < myPanel.getTextField().length(); i ++)
					if(myPanel.getTextField().charAt(i) >= 'a' && myPanel.getTextField().charAt(i) < 'x' || myPanel.getTextField().charAt(i) > 'x' && myPanel.getTextField().charAt(i) <= 'z')
						throw new WrongInput();
				for(int i = 0; i < myPanel.getTextField1().length(); i ++)
					if(myPanel.getTextField1().charAt(i) >= 'a' && myPanel.getTextField1().charAt(i) < 'x' || myPanel.getTextField1().charAt(i) > 'x' && myPanel.getTextField1().charAt(i) <= 'z')
						throw new WrongInput();

				p1 = new Polinom(myPanel.getTextField());
				p2 = new Polinom(myPanel.getTextField1());

				int option = myPanel.getOperation();
				switch(option)
				{
				case 0:{
					JFrame frame = new JFrame ("Simple Frame");
					JDialog a = new JDialog(frame,"Rezultat");
					myModel.adunare(p1,p2);
					Polinom result = myModel.getResult();
					a.add(new JLabel(result.toMyString()));
					a.setSize(500,500);
					a.setVisible(true);
					a.setLocation(100,100);
					break;
				}
				case 1:{
					JFrame frame = new JFrame ("Simple Frame");
					JDialog a = new JDialog(frame,"Rezultat");
					myModel.scadere(p1,p2);
					Polinom result = myModel.getResult();
					a.add(new JLabel(result.toMyString()));
					a.setSize(500,500);
					a.setVisible(true);
					a.setLocation(100,100);
					break;
				}
				case 2:{

					JFrame frame = new JFrame ("Simple Frame");
					JDialog a = new JDialog(frame,"Rezultat");
					myModel.inmultire(p1,p2);
					Polinom result = myModel.getResult();
					a.add(new JLabel(result.toMyString()));
					a.setSize(500,500);
					a.setVisible(true);
					a.setLocation(100,100);
					break;
				}
				case 3:{

					JFrame frame = new JFrame ("Simple Frame");
					JDialog a = new JDialog(frame,"Rezultat");
					myModel.impartire(p1,p2);
					Polinom result = myModel.getResult();
					a.add(new JLabel(result.toMyString()));
					a.setSize(500,500);
					a.setVisible(true);
					a.setLocation(100,100);
					break;
				}
				case 4:{

					JFrame frame = new JFrame ("Simple Frame");
					JDialog a = new JDialog(frame,"Rezultat");
					myModel.derivare(p1);
					Polinom result = myModel.getResult();
					a.add(new JLabel(result.toMyString()));
					a.setSize(500,500);
					a.setVisible(true);
					a.setLocation(100,100);
					break;
				}
				case 5:{

					JFrame frame = new JFrame ("Simple Frame");
					JDialog a = new JDialog(frame,"Rezultat");
					myModel.integrare(p1);
					Polinom result = myModel.getResult();
					a.add(new JLabel(result.toMyString()));
					a.setSize(500,500);
					a.setVisible(true);
					a.setLocation(100,100);
					break;
				}

				}

			} catch (WrongInput e1) {
				System.out.println(e1.getMessage());
			}
		}
	}
}
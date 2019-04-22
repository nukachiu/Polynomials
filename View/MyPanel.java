package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel extends JPanel {
	
	private JFrame frame = new JFrame ("Simple Frame");
	private JLabel l = new JLabel ("Polinomul 1: ");
	private JLabel l1 = new JLabel ("Polinomul 2: ");
	private JTextField tf = new JTextField("1x^2 -3x^1 +2x^0");
	private JTextField tf1 = new JTextField("1x^1 -2x^0");
	private JButton b2 = new JButton("Creeaza rezultat");
	private String operatii[] = {"Adunare", "Scadere", "Inmultire", "Impartire", "Derivare", "Integrare"};
	private JList list = new JList(operatii);
	
	public int getOperation()
	{
		return list.getSelectedIndex();
	}
	
	public String getTextField()
	{
		return tf.getText();
	}
	
	public String getTextField1()
	{
		return tf1.getText();
	}
	
	public void setResult(String s)
	{
		JDialog d = new JDialog(frame,"Rezultat");
		d.add(new JLabel(s));
		d.setSize(100,100);
		d.setVisible(true);
		d.setLocation(100,100);
	}
	
	public void addButtonListener(ActionListener button)
	{
		b2.addActionListener(button);
	}
	
	public MyPanel(){
		JPanel p = new JPanel();
			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 520);
		
		
		l.setFont(new Font("Ariel", Font.PLAIN, 17));
		
		tf.setMaximumSize(new Dimension(500,25));
		
		
		l1.setFont(new Font("Ariel", Font.PLAIN, 17));
		
		tf1.setMaximumSize(new Dimension(400,25));
		
		p.add(l);
		p.add(tf);
		p.add(l1);
		p.add(tf1);
		p.add(list);
		p.add(b2);
		 
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
	
		frame.setContentPane(p);
		frame.setVisible(true); 
	}
	
} 
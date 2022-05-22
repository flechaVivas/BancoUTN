package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	
	JPanel panel = new JPanel();
	JLabel usuario = new JLabel();
	JLabel contrasenia = new JLabel();
	JTextField user = new JTextField();
	JPasswordField passwd = new JPasswordField();
	JButton boton = new JButton();
	
	public Login() {
		
		this.setSize(500, 500);
		this.setLocationRelativeTo(null); 
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle("Login Page");
		
		this.setMinimumSize(new Dimension(200,200));
		
		
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		
		panel.setBackground(new Color(122,108,240)); 
		
		this.getContentPane().add(panel);
		
		panel.setLayout(null); 
		
		
		
		
		
	}
	
	
}

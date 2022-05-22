package ui;

import entities.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	
	JPanel panel = new JPanel();
	JLabel contenedorLogo = new JLabel();
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
		
		colocarLogo();
		colocarTextos();
		colocarCamposDeTexto();
		colocarBoton();
		
	}
	
	private void colocarLogo() {
	
		ImageIcon logo = new ImageIcon("logo-utn.png");
		
		//contenedorLogo.setIcon(logo);
		
		contenedorLogo.setBounds(50, 10, 200,50);
		contenedorLogo.setOpaque(true);
		contenedorLogo.setBackground(Color.WHITE);
		
		contenedorLogo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(
				contenedorLogo.getWidth(), contenedorLogo.getHeight(), Image.SCALE_SMOOTH)));
		
		panel.add(contenedorLogo);
	}
	
	private void colocarTextos() {
		
		usuario.setText("Usuario: ");
		usuario.setBounds(50, 110, 130, 30);
		usuario.setForeground(Color.white);
		usuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		//usuario.setHorizontalAlignment(SwingConstants.CENTER); 
		
		
		contrasenia.setText("Contraseña: ");
		contrasenia.setBounds(50, 180, 130, 30);
		contrasenia.setForeground(Color.white);
		contrasenia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		panel.add(usuario);
		panel.add(contrasenia);
		
	}
	
	private void colocarCamposDeTexto() {
		
		user.setBounds(50, 145,150, 30);
		passwd.setBounds(50, 210, 150, 30);
		panel.add(user);
		panel.add(passwd);
	}
	
	private void colocarBoton() {
	
		boton.setBounds(50, 270, 120, 25);
		boton.setText("Aceptar");
		boton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		panel.add(boton);

		accionarBoton();
		
	}
	
	private void accionarBoton() {
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String usr = user.getText();
				@SuppressWarnings("deprecation")
				String pass = passwd.getText();
				
				//System.out.println(usr + pass);
				
				validarDatos(usr,pass);
				
			}

			
		});
	
	}

	protected void validarDatos(String usr, String pass) {
		
		for (User u : usuarios) {
			
		}
		
	}
	
	
	
}

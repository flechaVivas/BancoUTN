package ui;

import entities.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel panel = new JPanel();
	JLabel contenedorLogo = new JLabel();
	JLabel usuario = new JLabel();
	JLabel contrasenia = new JLabel();
	JTextField user = new JTextField();
	JPasswordField passwd = new JPasswordField();
	JButton boton = new JButton();
	JLabel saludo = new JLabel();
	ArrayList<Cliente>usuarios = new ArrayList<Cliente>();
	int cont = -1;
	Cliente admin = new Cliente();
	Cliente facundo = new Cliente();
	Cliente userX = new Cliente();
	
	public Login() {
		
		definicionClientes();

		this.setSize(500, 500);
		this.setLocationRelativeTo(null); 	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Login Page");
		this.setMinimumSize(new Dimension(200,200));
		
		iniciarComponentes();
	}
	
	private void definicionClientes() {
		
		facundo.setUser("facundo");
		facundo.setPassword("1234");
		CajaDeAhorro ca1 = new CajaDeAhorro();
		ca1.setNroCuenta("11899212");
		ca1.setSaldo(9000.50);
		CuentaCorriente cc1 = new CuentaCorriente();
		cc1.setNroCuenta("000027812");
		cc1.setSaldo(315506);
		facundo.setCa(ca1);
		facundo.setCc(cc1);
	
		admin.setUser("admin");
		admin.setPassword("admin");
		CajaDeAhorro ca2 = new CajaDeAhorro();
		ca2.setNroCuenta("8891262233");
		ca2.setSaldo(189000.50);
		CuentaCorriente cc2 = new CuentaCorriente();
		cc2.setNroCuenta("789234348");
		cc2.setSaldo(2010);
		admin.setCa(ca2);
		admin.setCc(cc2);
		
		userX.setUser("user");
		userX.setPassword("user");
		CajaDeAhorro ca3 = new CajaDeAhorro();
		ca3.setNroCuenta("000017123");
		ca3.setSaldo(120600);
		CuentaCorriente cc3 = new CuentaCorriente();
		cc3.setNroCuenta("00015672");
		cc3.setSaldo(14700);
		userX.setCa(ca3);
		userX.setCc(cc3);
		
		usuarios.add(facundo);
		usuarios.add(admin);
		usuarios.add(userX);
	}

	private void iniciarComponentes() {
		
//		panel.setBackground(new Color(63,143,225)); 
		panel.setBackground(new Color(46,57,162)); 
		
		this.getContentPane().add(panel);
		
		panel.setLayout(null); 
		
		colocarLogo();
		colocarTextos();
		colocarCamposDeTexto();
		colocarBoton();
		
	}
	
	private void colocarLogo() {
	
		ImageIcon logo = new ImageIcon("src/logo-utn.png");
		
		contenedorLogo.setBounds(50, 15, 220,50);
		
		contenedorLogo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(
				contenedorLogo.getWidth(), contenedorLogo.getHeight(), Image.SCALE_SMOOTH)));
		
		panel.add(contenedorLogo);
	}
	
	private void colocarTextos() {
		
		usuario.setText("Usuario: ");
		usuario.setBounds(50, 110, 130, 30);
		usuario.setForeground(Color.white);
		usuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		
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
		boton.setMnemonic('\n');
		
		panel.add(boton);
		
		saludo.setBounds(50, 305, 400, 30);
		saludo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel.add(saludo);
		
		accionarBoton();
		
	}
	
	private void accionarBoton() {
		
		boton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					for (Cliente u : usuarios) {
						if (user.getText().equals(u.getUser()) && passwd.getText().equals(u.getPassword())) {
							u.setHabilitado(true);
							
							if (u.getHabilitado() == true) {
								panel.setVisible(false);
								dispose(); // Destroys JFrame object
								new Menu(u).start();
							}
						}
						
						else {
							if(u.getHabilitado() == false) {
								
								saludo.setText("Usuario y/o contraseña inválidos");
								saludo.setForeground(Color.red);
								cont=cont+1;
								
								if (cont > 3) {
									saludo.setText("Demasiados intentos fallidos");
									user.setEnabled(false);
									passwd.setEnabled(false);
									boton.setEnabled(false);
								}
							}
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}

}

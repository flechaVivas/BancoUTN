package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import entities.*;


public class Menu extends JFrame implements ActionListener  {
	
	Cliente u;
	
	public Cliente getU() {
		return u;
	}


	public void setU(Cliente u) {
		this.u = u;
	}


	JPanel panelMenu = new JPanel();
	
	JPanel panelIzq = new JPanel();
	JLabel contenedorLogo = new JLabel();
	JRadioButton cajaAhorro = new JRadioButton();
	JRadioButton cCorriente = new JRadioButton();
	ButtonGroup grupoRadioBotones = new ButtonGroup();
	ButtonGroup grupoOpciones = new ButtonGroup();
	
	JRadioButton botonSaldo = new JRadioButton();
	JRadioButton botonTransf = new JRadioButton();
	JRadioButton botonExt = new JRadioButton();
	JRadioButton botonDep = new JRadioButton();
	
	JButton salir = new JButton();
	JButton cs = new JButton();
	
	
	JPanel panelDer = new JPanel();
	JLabel infoCuenta = new JLabel();
	JLabel informaSaldo = new JLabel();
	JLabel ingresaMonto = new JLabel();
	JTextField monto = new JTextField();
	JButton botonTransferir = new JButton();
	
	public Menu(Cliente u) {
		this.setU(u);
	}
	
	
	public void start() {
		this.setSize(700, 500);
		this.setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Menu");
		this.setMinimumSize(new Dimension(200,200));
		this.setVisible(true);
		iniciarComponentes(u);
	}
	
	private void iniciarComponentes(Cliente u) {

		panelMenu.setBackground(new Color(63,143,225)); 
		this.getContentPane().add(panelMenu);
		panelMenu.setLayout(null); 
		
		
		panelIzq.setLayout(null);
		panelIzq.setBounds(0, 0, 220, 800);
		panelIzq.setBackground(Color.DARK_GRAY);
		panelMenu.add(panelIzq);
		
		
		panelDer.setLayout(null);
		panelDer.setBounds(300, 0, 650, 800);
		panelDer.setBackground(new Color(63,143,225));
		panelMenu.add(panelDer);
		
		colocarLogo();
		colocarBotonSalir();
		colocarBotonCerrarSesion();
		colocarCuentas(u);
		colocarBotones();
		
		panelIzq.add(contenedorLogo);
		panelIzq.add(cCorriente);
		panelIzq.add(cajaAhorro);
		panelIzq.add(botonSaldo);
		panelIzq.add(botonTransf);
		panelIzq.add(botonExt);
		panelIzq.add(botonDep);
		panelIzq.add(salir);
		panelIzq.add(cs);
		
		panelDer.add(infoCuenta);
		panelDer.add(informaSaldo);
		panelDer.add(ingresaMonto);
		panelDer.add(monto);
		panelDer.add(botonTransferir);
	
	}
	
	private void colocarLogo() {
		ImageIcon logo = new ImageIcon("src/logo-utn.png");
		contenedorLogo.setBounds(30, 15, 220,50);
		contenedorLogo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(
				contenedorLogo.getWidth(), contenedorLogo.getHeight(), Image.SCALE_SMOOTH)));
	}
	
	private void colocarBotonSalir() {
		salir.setBounds(20, 420, 180, 30);
		salir.setText("Salir");
		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});	
	}
	private void colocarBotonCerrarSesion() {
		cs.setBounds(20, 380, 180, 30);
		cs.setText("Cerrar Sesion");
		cs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login l = new Login();
				l.setVisible(true);
			}
		});	
	}
	private void colocarBotones() {
		
		botonSaldo.setBounds(20, 200, 180, 30);
		botonTransf.setBounds(20, 230, 180, 30);
		botonExt.setBounds(20, 260, 180, 30);
		botonDep.setBounds(20, 290, 180, 30);
		
		botonSaldo.setText("Saldo");
		botonTransf.setText("Transferencia");
		botonExt.setText("Extraccion");
		botonDep.setText("Depósito");
		
		botonSaldo.setVisible(false);
		botonTransf.setVisible(false);
		botonExt.setVisible(false);
		botonDep.setVisible(false);
		
		
		botonSaldo.addActionListener(this);
		botonTransf.addActionListener(this);
		botonExt.addActionListener(this);
		botonDep.addActionListener(this);
		
		botonTransferir.addActionListener(this);
		
		grupoOpciones.add(botonSaldo);
		grupoOpciones.add(botonTransf);
		grupoOpciones.add(botonExt);
		grupoOpciones.add(botonDep);
		
	}
	
	private void colocarDatosCuenta(Cliente u, String c) {
		
		infoCuenta.setBounds(20, 15, 500, 30);
		infoCuenta.setForeground(Color.white);
		
		if (c=="cc") {
			infoCuenta.setText("INFORMACION DE LA CUENTA N° " + u.getCc().getNroCuenta());
		}
		if (c=="ca") {
			infoCuenta.setText("INFORMACION DE LA CUENTA N° " + u.getCa().getNroCuenta());
		}
	}
	
	private void limpiarComponentes() {
		for (int i = 0; i < panelDer.getComponentCount(); i++) {
			panelDer.getComponent(i).setVisible(false);	
		}
		infoCuenta.setVisible(true);
		
	}

	private void colocarCuentas(Cliente u) {
	
		cCorriente.setText("CuentaCorriente");		
		cCorriente.setBounds(20, 100, 180, 30);
		cCorriente.setBackground(Color.LIGHT_GRAY);
		
		cajaAhorro.setText("Caja De Ahorro");
		cajaAhorro.setBounds(20, 140, 180, 30);
		cajaAhorro.setBackground(Color.LIGHT_GRAY);
		
		grupoRadioBotones.add(cajaAhorro);
		grupoRadioBotones.add(cCorriente);
		
		cCorriente.addActionListener(this);
		cajaAhorro.addActionListener(this);
		
		botonSaldo.setVisible(false);
		botonTransf.setVisible(false);
		botonExt.setVisible(false);
		botonDep.setVisible(false);
	}
	
	private boolean validaSaldoPositivo() {
		if (Double.parseDouble(monto.getText()) > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		limpiarComponentes();
		
		if (e.getSource().equals(cCorriente)) {
			limpiarComponentes();
			botonSaldo.setVisible(true);
			botonTransf.setVisible(true);
			botonExt.setVisible(true);
			botonDep.setVisible(true);
			colocarDatosCuenta(u,"cc");
		}
		
		
		if (e.getSource().equals(cajaAhorro)) {
			limpiarComponentes();
			botonSaldo.setVisible(true);
			botonTransf.setVisible(true);
			botonExt.setVisible(true);
			botonDep.setVisible(true);
			colocarDatosCuenta(u,"ca");
					
		}
		
		
		if (e.getSource().equals(botonSaldo)) {
			limpiarComponentes();
			if (cCorriente.isSelected()) {
				informaSaldo.setBounds(60, 90, 400, 20);
				informaSaldo.setForeground(Color.WHITE);
				informaSaldo.setText("Su saldo actual es: "+u.getCc().getSaldo());
				informaSaldo.setVisible(true);
			}
			if (cajaAhorro.isSelected()) {
				informaSaldo.setBounds(60, 90, 400, 20);
				informaSaldo.setForeground(Color.WHITE);
				informaSaldo.setText("Su saldo actual es: "+u.getCa().getSaldo());
				informaSaldo.setVisible(true);
			}
		}
		
		ingresaMonto.setBounds(0,90,270,30);
		ingresaMonto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ingresaMonto.setForeground(Color.WHITE);
		monto.setBounds(215, 90, 90, 30);
		botonTransferir.setBounds(200, 140, 100, 30);
		
		if (e.getSource().equals(botonTransf)) {
			limpiarComponentes();
			ingresaMonto.setText("Ingrese monto a transferir: $");
			botonTransferir.setText("Transferir");
			ingresaMonto.setVisible(true);
			monto.setVisible(true);
			botonTransferir.setVisible(true);
			monto.setText("0");
			
		}
		
		if (e.getSource().equals(botonExt)) {
			limpiarComponentes();
			ingresaMonto.setText("Ingrese monto a extrer: $");
			botonTransferir.setText("Extraer");
			ingresaMonto.setVisible(true);
			monto.setVisible(true);
			botonTransferir.setVisible(true);
			monto.setText("0");
		}
		
		if (e.getSource().equals(botonDep)) {
			limpiarComponentes();
			ingresaMonto.setText("Ingrese monto a depositar: $");
			botonTransferir.setText("Depositar");
			ingresaMonto.setVisible(true);
			monto.setVisible(true);
			botonTransferir.setVisible(true);
			monto.setText("0");
		}
			
			
		if (e.getSource().equals(botonTransferir)) {
			
			ingresaMonto.setVisible(true);
			monto.setVisible(true);
			botonTransferir.setVisible(true);
			
			
			/*  CUENTA CORRIENTE   */
			
			if (cCorriente.isSelected()) {
				
				/*  TRANSFERIR EN CUENTA CORRIENTE     */
				
				if(botonTransf.isSelected()) {
					try {
						
						System.out.println(monto.getText());
						
						if (validaSaldoPositivo()) {
							
							if (Double.parseDouble(monto.getText()) > u.getCc().getSaldo()) {
								JOptionPane.showMessageDialog(null, "Saldo insuficiente");	
							}
								
							else if (JOptionPane.showConfirmDialog(null, "¿Desea transferir $"+monto.getText()+ " a su Caja de Ahorro?") == 0) {
								u.getCc().setSaldo(u.getCc().getSaldo() - Double.parseDouble(monto.getText()));
								u.getCa().setSaldo(u.getCa().getSaldo() + Double.parseDouble(monto.getText()));
								
								JOptionPane.showMessageDialog(null, "Dinero enviado con exito");
								monto.setText("0");
								
							}
							else {
								JOptionPane.showMessageDialog(null, "Operacion cancelada");
								monto.setText("0");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
						}
					} 
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
			
				
				/*  EXTRAER EN CUENTA CORRIENTE    */
				
				if (botonExt.isSelected()) {
					try {
						if (validaSaldoPositivo()) {
							if (Double.parseDouble(monto.getText()) > u.getCc().getSaldo()) {
								JOptionPane.showMessageDialog(null, "Saldo insuficiente");	
							}
							else if (JOptionPane.showConfirmDialog(null, "¿Desea extraer $"+monto.getText()+ "?") == 0) {
								
								u.getCc().setSaldo(u.getCc().getSaldo() - Double.parseDouble(monto.getText()));
								JOptionPane.showMessageDialog(null, "Extraccion exitosa, retire su dinero");
								monto.setText("0");
								
							}
							else {
								JOptionPane.showMessageDialog(null, "Operacion cancelada");
								monto.setText("0");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
						}
					} 
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
					}
				}
				
				/*  DEPOSITAR EN CUENTA CORRIENTE     */
				
				if (botonDep.isSelected()) {
					
					try {
						
						if (validaSaldoPositivo()) {
								
							if (JOptionPane.showConfirmDialog(null, "¿Desea depositar $"+monto.getText()+ "?") == 0) {
								
								u.getCc().setSaldo(u.getCc().getSaldo() + Double.parseDouble(monto.getText()));
								JOptionPane.showMessageDialog(null, "Dinero depositado con exito");
								monto.setText("0");
								
							}
							else {
								JOptionPane.showMessageDialog(null, "Operacion cancelada");
								monto.setText("0");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
						}
					} 
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
					}
					
				}
		}
			
			
		/*  CAJA DE AHORRO   */
			
		if (cajaAhorro.isSelected()) {	
			
			/*  TRANSFERIR EN CAJA DE AHORRO     */
			
			if (botonTransf.isSelected()) {
				try {
					
					if (validaSaldoPositivo()) {
						if (Double.parseDouble(monto.getText()) > u.getCa().getSaldo()) {
							JOptionPane.showMessageDialog(null, "Saldo insuficiente");	
						}
						else if (JOptionPane.showConfirmDialog(null, "¿Desea transferir $"+monto.getText()+ " a su Cuenta Corriente?") == 0) {
							u.getCa().setSaldo(u.getCa().getSaldo() - Double.parseDouble(monto.getText()));
							u.getCc().setSaldo(u.getCc().getSaldo() + Double.parseDouble(monto.getText()));
							
							JOptionPane.showMessageDialog(null, "Dinero enviado con exito");
							monto.setText("0");
						}
						else {
							JOptionPane.showMessageDialog(null, "Operacion cancelada");
							monto.setText("0");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
					}
				} 
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
			
			/*  EXTRAER EN CAJA DE AHORRO     */
			
			if (botonExt.isSelected()) {
				try {
					
					if (validaSaldoPositivo()) {
						
						if (Double.parseDouble(monto.getText()) > u.getCa().getSaldo()) {
							JOptionPane.showMessageDialog(null, "Saldo insuficiente");	
						}
							
						else if (JOptionPane.showConfirmDialog(null, "¿Desea extraer $"+monto.getText()+ "?") == 0) {
							
							u.getCa().setSaldo(u.getCa().getSaldo() - Double.parseDouble(monto.getText()));
							
							JOptionPane.showMessageDialog(null, "Extraccion exitosa, retire su dinero");
							monto.setText("0");
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Operacion cancelada");
							monto.setText("0");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
					}
				} 
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
				}
			}
			
			
			/*  DEPOSITAR EN CAJA DE AHORRO     */
			
			if (botonDep.isSelected()) {
				
				try {
					
					if (validaSaldoPositivo()) {
							
						if (JOptionPane.showConfirmDialog(null, "¿Desea depositar $"+monto.getText()+ "?") == 0) {
							
							u.getCa().setSaldo(u.getCa().getSaldo() + Double.parseDouble(monto.getText()));
							JOptionPane.showMessageDialog(null, "Dinero depositado con exito");
							monto.setText("0");
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Operacion cancelada");
							monto.setText("0");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
					}
				} 
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
				}
				
			}
			
			
		}
		}
	}
}

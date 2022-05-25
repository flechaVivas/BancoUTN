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


public class Menu extends JFrame  {
	
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
	
	
	JPanel panelDer = new JPanel();
	JLabel infoCuenta = new JLabel();
	JLabel informaSaldo = new JLabel();
	JLabel ingresaMonto = new JLabel();
	JTextField monto = new JTextField();
	JLabel mensaje = new JLabel();
	JButton botonTransferir = new JButton();
	
	public void start(Cliente u) {
		
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
		colocarCuentas(u);
		
		agregarComponentes();
	
	}
	
	private void agregarComponentes() {
		panelIzq.add(contenedorLogo);
		panelIzq.add(cCorriente);
		panelIzq.add(cajaAhorro);
		panelIzq.add(botonSaldo);
		panelIzq.add(botonTransf);
		panelIzq.add(botonExt);
		panelIzq.add(botonDep);
		panelIzq.add(salir);
		
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
		
		salir.setBounds(20, 400, 180, 30);
		salir.setText("Salir");
		
		salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);	
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
		
		// Eventos
		cCorriente.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				limpiarComponentes();
				
				colocarBotones();

				colocarDatosCuenta(u,"cc");
				
				eventoSaldo(u,"cc");
				
				eventoTransf(u,"cc");
				
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		cajaAhorro.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				limpiarComponentes();
				
				colocarBotones();

				colocarDatosCuenta(u,"ca");
				
				eventoSaldo(u,"ca");
				
				eventoTransf(u,"ca");
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		
	}
	private void eventoSaldo(Cliente u, String c) {
		botonSaldo.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				limpiarComponentes();
				informaSaldo.setBounds(60, 90, 400, 20);
				informaSaldo.setForeground(Color.WHITE);
				if (c=="cc") {
					informaSaldo.setVisible(true);
					informaSaldo.setText("Su saldo actual es: "+u.getCc().getSaldo());
				}
				if (c=="ca") {
					informaSaldo.setVisible(true);
					informaSaldo.setText("Su saldo actual es: "+u.getCa().getSaldo());
				}
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
	}
	

	private void eventoTransf(Cliente u, String c) {
		
		botonTransf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				limpiarComponentes();
				
				ingresaMonto.setBounds(0,90,270,30);
				ingresaMonto.setText("Ingrese monto a transferir: $");
				ingresaMonto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				ingresaMonto.setForeground(Color.WHITE);
				monto.setBounds(215, 90, 90, 30);
				monto.setText("0");
				
				botonTransferir.setText("Transferir");
				botonTransferir.setBounds(200, 140, 100, 30);
				
				
				if (c=="cc") {
					ingresaMonto.setVisible(true);
					monto.setVisible(true);
					botonTransferir.setVisible(true);
						
					botonTransferir.addMouseListener(new MouseListener() {
							
					@Override
						public void mouseClicked(MouseEvent arg0) {
						
							try {
								
								if (Double.parseDouble(monto.getText()) > 0) {
									if (Double.parseDouble(monto.getText()) > u.getCc().getSaldo()) {
										JOptionPane.showMessageDialog(null, "Saldo insuficiente");	
									}
										
									else if (JOptionPane.showConfirmDialog(null, "¿Desea transferir $"+monto.getText()+ " a su Caja de Ahorro?") == 1) {
										u.getCc().setSaldo(u.getCc().getSaldo() - Double.parseDouble(monto.getText()));
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
								}
							} 
							catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
							}
						}

						@Override
						public void mouseEntered(MouseEvent arg0) {
						}
						@Override
						public void mouseExited(MouseEvent arg0) {
						}
						@Override
						public void mousePressed(MouseEvent arg0) {
						}
						@Override
						public void mouseReleased(MouseEvent arg0) {
						}
					});
					
				}
				
				if (c=="ca") {
					ingresaMonto.setVisible(true);
					monto.setVisible(true);
					botonTransferir.setVisible(true);
						
					botonTransferir.addMouseListener(new MouseListener() {
							
					@Override
						public void mouseClicked(MouseEvent arg0) {
						
							try {
								
								if (Double.parseDouble(monto.getText()) > 0) {
									if (Double.parseDouble(monto.getText()) > u.getCa().getSaldo()) {
										JOptionPane.showMessageDialog(null, "Saldo insuficiente");	
									}
										
									else if (JOptionPane.showConfirmDialog(null, "¿Desea transferir $"+monto.getText()+ " a su Cuenta Corriente?") == 1) {
										u.getCa().setSaldo(u.getCa().getSaldo() - Double.parseDouble(monto.getText()));
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
								}
							} 
							catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
							}
							
						}
						@Override
						public void mouseEntered(MouseEvent arg0) {
						}
						@Override
						public void mouseExited(MouseEvent arg0) {
						}
						@Override
						public void mousePressed(MouseEvent arg0) {
						}
						@Override
						public void mouseReleased(MouseEvent arg0) {
						}
					});
				}
				
			}
		});
	}
	
	

	
	
	
	
	
	
	
	
}

package ui;

import java.util.ArrayList;

import entities.*;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<User>usuarios = new ArrayList<User>();
		
		User admin = new User();
		admin.setUser("admin");
		admin.setPassword("admin");
		
		usuarios.add(admin);
		
		Login l = new Login();
		l.setVisible(true);
	}

}

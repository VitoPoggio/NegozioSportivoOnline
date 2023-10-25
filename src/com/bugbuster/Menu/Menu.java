package com.bugbuster.Menu;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
	
	
	public static void start() {
		int input = 0;
		boolean loop = true;
		while(loop) {
			System.out.println("----BENVENUTO AL NEGOZIO SPORTIVO ONLINE! ----- \n"
					+ "1 -> Zona Admin\n"
					+ "2 -> Zona Utente\n"
					+ "3 -> Esci"
					);
			
			input = Integer.parseInt(Menu.scan());
			
			switch(input) {
			case 1: {
				boolean l1 = true;
				while(l1) {
					System.out.println("----ZONA ADMIN ----- \n"
							+ "1 -> Registrati\n"
							+ "2 -> Log In\n"
							);
					
					input = Integer.parseInt(Menu.scan());
					switch(input) {
					case 1: {
						Menu.registrazioneAdmin();
					} break;
					case 2: { 
						Menu.logInAdmin();					
					} break;
					default: System.out.println("Input non accettato."); break;
					}
				}
			} break;
			case 2: { 
				boolean l2 = true;
				while(l2) {
					System.out.println("----ZONA UTENTE ----- \n"
							+ "1 -> Registrati\n"
							+ "2 -> Log In\n"
							);
					
					input = Integer.parseInt(Menu.scan());
					switch(input) {
					case 1: {
						Menu.registrazioneUtente();
					} break;
					case 2: { 
						Menu.logInUtente();					
					} break;
					default: System.out.println("Input non accettato."); break;
					}
				}
			} break;
			case 3: {
				System.out.println("Sei uscito dal Negozio");
				System.exit(0);
			} break;
			default: System.out.println("Input non accettato."); break;
			}
		}
	}
	
	
	//Log ins
	private static void logInAdmin() throws IOException {
		
		String username;
		String password;

		System.out.println("----LOG IN ----- ");
		System.out.println("Inserire username: ");
		username = Menu.scan(); 
		
		System.out.println("Inserire password: ");
		password = Menu.scan();
		
		Menu.menuAdmin();
		
	}
	
	private static void logInUtente() throws IOException {
		
		String username;
		String password;
	
		System.out.println("----LOG IN ----- ");
		System.out.println("Inserire username: ");
		username = Menu.scan(); 
		
		System.out.println("Inserire password: ");
		password = Menu.scan(); 
		
		Menu.menuUtente();
		
		
	}
	
	//Registrazioni
	private static void registrazioneUtente() throws IOException {
		String nome;
	    String cognome;
	    String indirizzo;
	    String cap;
	    String username;
	    String password;
	    String email;


		System.out.println("---- REGISTRAZIONE ----- ");
		System.out.println("Inserire nome: ");
		nome = Menu.scan(); 
			
		System.out.println("Inserire cognome: ");
		cognome = Menu.scan(); 
			
		System.out.println("Inserire indirizzo: ");
		indirizzo = Menu.scan(); 
			
		System.out.println("Inserire Cap: ");
		cap = Menu.scan();
			
		System.out.println("Inserire email: ");
		email = Menu.scan(); 
			
		System.out.println("Inserire username: ");
		username = Menu.scan(); 
			
		System.out.println("Inserire password: ");
		password =  Menu.scan();
		
		//crea nuovo utente
		Menu.menuUtente();
						
	}
	
	private static void registrazioneAdmin() {
		String username;
	    String password;
	    String email;
	    
	    System.out.println("---- REGISTRAZIONE ----- ");			
		System.out.println("Inserire email: ");
		email = Menu.scan(); 
			
		System.out.println("Inserire username: ");
		username = Menu.scan(); 
			
		System.out.println("Inserire password: ");
		password =  Menu.scan();
		
		//crea nuovo admin
		
		Menu.menuAdmin();
	}
	
	//Menus
	private static void menuAdmin() {
		boolean loop = true;
		int input;
		
		while(loop) {
			System.out.println("Scegli tra le seguenti opzioni: \n"
					+ "1 -> inserisci Prodotto\n"
					+ "2 -> inserisci Utente\n"
					+ "3 -> inserisci Ordine\n"
					+ "4 -> elimina Prodotto\n"
					+ "5 -> elimina Utente\n"
					+ "6 -> elimina Ordine\n"
					+ "7 -> aggiorna Prodotto\n"
					+ "8 -> aggiorna Utente\n"
					+ "9 -> aggiorna Ordine\n"
					+ "10 -> torna all'inizio\n"
					+ "11 -> esci"
					);
			
			input = Integer.parseInt(Menu.scan());
			
			switch(input) {
			case 1: { 
				//inserisci Prodotto
			
			} break;
			case 2: { 
				//inserisci Utente
				
				} break;
			case 3:{ 
				//inserisci Ordine
				
				} break;
			case 4:{ 
				//elimina Prodotto
				
				} break;
			case 5:{ 
				//elimina Utente
				
			} break;
			case 6:{ 
				//elimina Ordine
				
			} break;
			case 7:{ 
				//aggiorna Prodotto
				
			} break;
			case 8:{ 
				//aggiorna Utente
				
			} break;
			case 9:{ 
				//aggiorna Ordine
				
			} break;
			case 10: Menu.start();
			case 11: {
				System.out.println("Sei uscito dal Negozio");
				System.exit(0);
			} break;
			default: System.out.println("Input non accettato."); break;
			}
		}
	}
	
	private static void menuUtente() {
		boolean loop = true;
		int input;
		
		while(loop) {
			System.out.println("Scegli tra le seguenti opzioni: \n"
					+ "1 -> visualizza catalogo\n"
					+ "2 -> acquista prodotto\n"
					+ "3 -> visualizza carrello\n"
					+ "4 -> procedi con ordine\n"
					+ "5 -> torna all'inizio\n"
					+ "6 -> esci"
					);
			
			input = Integer.parseInt(Menu.scan());
			//cB = this.S.nextLine();
			
			switch(input) {
			case 1: { 
				//visualizza catalogo
				}break;
			case 2: { 
				//acquista prodotto
				} break;
			case 3: { 
				//visualizza carrello
			} break;
			case 4: { 
				//procedi con ordine
			} break;
			case 5: Menu.start();
			case 6: {
				System.out.println("Sei uscito dal Negozio");
				System.exit(0);
			}
			default: System.out.println("Input non accettato."); break;
			}
		}
	}
	
	
	
	//Utility
	public static String scan() {
			Scanner S = new Scanner(System.in);
			return S.next();
			
		}
		
		
}

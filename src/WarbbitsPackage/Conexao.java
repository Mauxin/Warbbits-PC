package WarbbitsPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexao {
	
	public DataOutputStream dos;
	public DataInputStream dis;
	ServerSocket serverSocket;
	Socket socket;

	String ip = "localhost";
	int porta = 1234;

	
	
	public Conexao (String ip, int porta) {
		this.ip = ip; 
		this.porta = porta; 
	}
	
	public boolean conecta() {
		try {
			socket = new Socket(ip, porta);
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			//TODO : enviar feedback para o jogo dizendo que está conectado 
		} catch (IOException e) {
			System.out.println("Não se conectou com: " + ip + ":" + porta + " | Estamos começando um Server...");
			return false;
		}
		System.out.println("Estamos conectados!");
		return true;
	}
	
	public void iniciaServer() {
		
		try {
			serverSocket = new ServerSocket(porta, 8, InetAddress.getByName(ip));
			System.out.println("Server Aberto. Chame seu amigo pelo ip: >" + ip + "< e pela porta: "+ porta);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//TODO : avisar que é o servidor e que ele inicia a jogada
		
		
	}
	
	 
}



package sockets_0;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor  {
	public static void main(String[] args) {
		MarcoServidor mimarco=new MarcoServidor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
}

class MarcoServidor extends JFrame implements Runnable {
	private	JTextArea areatexto;
	public MarcoServidor(){
		setBounds(1200,300,280,350);
		JPanel milamina= new JPanel();
		milamina.setLayout(new BorderLayout());
		areatexto=new JTextArea();
		milamina.add(areatexto,BorderLayout.CENTER);
		add(milamina);
		setVisible(true);
		Thread hilo = new Thread(this);
		hilo.start();
		}

	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(9999);
			String nick, message, ip, ipClientLocation;
			DataPackage packedDataReceived;

			while(true) {
				Socket mi_socket = server.accept();
				//Detecta la direccion ip del cliente
				ipClientLocation = mi_socket.getInetAddress().getHostAddress();
				System.out.println(ipClientLocation);
				// -------------------------------
				ObjectInputStream objectInputStream = new ObjectInputStream(mi_socket.getInputStream());
				packedDataReceived = ( DataPackage ) objectInputStream.readObject();

				nick = packedDataReceived.getNickName();
				message = packedDataReceived.getMessage();
				ip = packedDataReceived.getIp();

				areatexto.append("\n" + nick +" - " + ip +":\n" + message);
				/*DataInputStream data_in_flow = new DataInputStream(mi_socket.getInputStream());
				String message_received = data_in_flow.readUTF();*/
				/*areatexto.append("\n"+message_received);
				data_in_flow.close();*/

				Socket sendToAdressee = new Socket(ip, 9090);
				ObjectOutputStream packageToBeSent = new ObjectOutputStream(sendToAdressee.getOutputStream());

				packageToBeSent.writeObject(packedDataReceived);

				packageToBeSent.close();
				sendToAdressee.close();
				mi_socket.close();
			}
		} catch( IOException | ClassNotFoundException e ) {
			throw new RuntimeException( e );
		}
	}
}



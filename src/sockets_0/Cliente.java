package sockets_0;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) {
		MarcoCliente mimarco=new MarcoCliente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoCliente extends JFrame{
	public MarcoCliente(){
		setBounds(600,300,280,350);
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		add(milamina);
		setVisible(true);

		addWindowListener(new Online());
		}
}

// Envio de la ip del cliente al servidor
class Online extends WindowAdapter {
	 public void windowOpened(WindowEvent e) {
		 try {
			 Socket socket = new Socket("192.168.0.11", 9999);
			 DataPackage packedData = new DataPackage();
			 packedData.setMessage("Online");

			 ObjectOutputStream outFlowData = new ObjectOutputStream( socket.getOutputStream() );
			 outFlowData.writeObject(packedData);

			 socket.close();
		 } catch(IOException ex) {
			 throw new RuntimeException(ex);
		 }

	 }
}

class LaminaMarcoCliente extends JPanel implements Runnable{
	private String user;
	private JTextField messagesArea;
	private JComboBox< String > ip;
	/*private JLabel nickName;*/
	/*private JTextField ip;*/
	private JButton miboton;
	private JTextArea chatField;
	public LaminaMarcoCliente(){
		user = JOptionPane.showInputDialog("Your Nickname: ");
		JLabel nickLabel = new JLabel("Nick: " + user);
		/*nickName = new JLabel();
		nickName.setText(user);*/
		JLabel texto = new JLabel("Online: ");
		ip = new JComboBox<>();
		ip.addItem("Usuario - 1");
		ip.addItem("Usuario - 2");
		ip.addItem("Usuario - 3");

		chatField = new JTextArea(10,20);
		messagesArea = new JTextField(20);
		miboton = new JButton("Enviar");
		SendText sendText = new SendText();

		miboton.addActionListener(sendText);

		add(nickLabel);
		/*add(nickName);*/
		add(texto);
		add(ip);
		add(chatField);
		add(messagesArea);
		add(miboton);
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		try {
			ServerSocket server_client = new ServerSocket(9090);
			Socket client;
			DataPackage packedDataReceived;

			while(true) {
				client = server_client.accept();
				ObjectInputStream inFlowData = new ObjectInputStream( client.getInputStream() );

				packedDataReceived = ( DataPackage ) inFlowData.readObject();
				chatField.append("\n" + packedDataReceived.getNickName() +" - " + packedDataReceived.getIp() +":\n" + packedDataReceived.getMessage());
			}
		} catch( IOException e ) {
			System.out.println(e.getMessage());
		} catch( ClassNotFoundException e ) {
			throw new RuntimeException( e );
		}
	}

	private class SendText implements ActionListener {
		@Override
		public void actionPerformed( ActionEvent event ) {
			chatField.append( "\n" + messagesArea.getText() );
			try {
				Socket miSocket = new Socket("192.168.0.11", 9999);
				DataPackage packedData = new DataPackage(user, messagesArea.getText(), ip.getSelectedItem().toString());
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(miSocket.getOutputStream());

				/*objectOutputStream.writeObject(packedData);*/
				/*DataOutputStream data_out_flow = new DataOutputStream(miSocket.getOutputStream());
				data_out_flow.writeUTF( campo1.getText());

				data_out_flow.close();*/
				miSocket.close();
			} catch( IOException e ) {
				System.out.println(e.getMessage());
			}
		}
	}
}
//"192.168.0.11"
class DataPackage implements Serializable {
	private String nickName;
	private String message;
	private String ip;
	public DataPackage( String nickName, String message, String ip )  {
		this.nickName = nickName;
		this.message = message;
		this.ip = ip;
	}

	public DataPackage() {
	}

	public String getNickName() {
		return nickName;
	}
	public String getMessage() {
		return message;
	}
	public String getIp() {
		return ip;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
package sockets_0;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
		}
}

class LaminaMarcoCliente extends JPanel{
	private JTextField campo1;
	private JButton miboton;
	public LaminaMarcoCliente(){
		JLabel texto=new JLabel("CLIENTE");
		add(texto);
		campo1=new JTextField(20);
		add(campo1);
		miboton=new JButton("Enviar");
		sendText sendText = new sendText();
		miboton.addActionListener(sendText);
		add(miboton);
	}

	private class sendText implements ActionListener {
		@Override
		public void actionPerformed( ActionEvent event ) {
			try {
				Socket miSocket = new Socket("192.168.0.11", 9999);

			} catch( IOException e ) {
				System.out.println(e.getMessage());
			}
		}
	}
}
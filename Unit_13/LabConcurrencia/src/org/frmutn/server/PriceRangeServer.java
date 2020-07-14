package org.frmutn.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class PriceRangeServer implements Runnable {
	private String price;
	private ServerSocket ss;
	
	
    public PriceRangeServer(int port, int low, int high) throws IOException {
        ss = new ServerSocket(port);
        ss.setSoTimeout(250);
        double d = Math.random() * (high - low) + low;
        price = String.format("%.2f", d);
    }
	
	@Override
	public void run() {
		try {
			accept();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}



	public  void accept() throws  IOException{
		System.out.println("Aceptando conexión en el puerto: "+ ss.getLocalPort());
		while(!Thread.interrupted()) {
			try(Socket socket = ss.accept();
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())) ){
				try {
					Thread.sleep(2000);
				}catch(InterruptedException e) {
					return;
				}
				
				bw.write(price);
				
					}catch(SocketTimeoutException e) {
						
					}
		}
		System.out.println("Listo Aceptando");
		
	}

}

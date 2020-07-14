package org.frmutn.cliente;

import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class NetworkClientCallable implements Callable<RequestResponse> {
	private RequestResponse lookup;
	
	
	public NetworkClientCallable(RequestResponse lookup) {
		super();
		this.lookup = lookup;
	}


	@Override
	public RequestResponse call() throws Exception {
		try(Socket sock = new Socket(lookup.getHost(),lookup.getPort());
			Scanner scanner = new Scanner(sock.getInputStream())) {
				lookup.setResponse(scanner.next());
			}
		return lookup;
	}

}

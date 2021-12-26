package proxyVersion.connect4.distributed.dispatchers;

import proxyVersion.connect4.types.PlayerType;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import proxyVersion.connect4.types.Error;

public class TCPIP extends proxyVersion.utils.TCPIP {

	public static TCPIP createServerSocket() {
		try {
			ServerSocket serverSocket = new ServerSocket(2020);
			System.out.println("Servidor> Esperando conexion...");
			Socket socket = serverSocket.accept();
			System.out.println("Servidor> Recibida conexion de " + socket.getInetAddress().getHostAddress() + ":"
					+ socket.getPort());
			return new TCPIP(serverSocket, socket);
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public TCPIP(ServerSocket serverSocket, Socket socket) {
		super(serverSocket, socket);
	}

	public void send(PlayerType value) {
		if (value == null) {
			this.send("null");
		}else {
			this.send(value.name());			
		}
	}

	public void send(Error value) {
		if (value == null) {
			this.send("null");
		}else {
			this.send(value.name());
		}
	}

	public Error receiveError() {
		String error = this.receiveLine();
		if (error.equals("null")) {
			return null;
		}
		return Error.valueOf(error);
	}
}

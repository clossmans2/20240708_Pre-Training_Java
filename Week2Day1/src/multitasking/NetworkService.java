package multitasking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkService implements Runnable {
	private final ServerSocket serverSocket;
	private final ExecutorService pool;
	
	public NetworkService(int port, int poolSize) throws IOException {
		this.serverSocket = new ServerSocket(port);
		this.pool = Executors.newFixedThreadPool(poolSize);
	}
	
	@Override
	public void run() {
		try {
			for (;;) {
				pool.execute(new Handler(serverSocket.accept()));
			}
		} catch (IOException ex) {
			pool.shutdown();
		}
	}
	
}

class Handler implements Runnable {
	private final Socket socket;
	public Handler(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		// read and service request on socket
		
	}
}

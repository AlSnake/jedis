import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Jedis {
	private static final Logger LOGGER = LoggerFactory.getLogger(Jedis.class);

    public static void main(String[] args) {
		LOGGER.info("JEDIS");

//		ServerSocket serverSocket = null;
//		Socket clientSocket = null;
//
//		int port = 6379;
//
//		try {
//			serverSocket = new ServerSocket(port);
//			serverSocket.setReuseAddress(true);
//
//			clientSocket = serverSocket.accept();
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				if(clientSocket != null)
//					clientSocket.close();
//			} catch (IOException e) {
//				System.out.println(e.getMessage());
//			}
//		}
    }
}

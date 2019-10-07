package tcpserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Cagni Lorenzo, Lin Jiale, Valloncini Stefano 
 */
public class TCPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        ServerSocket serverSocket= new ServerSocket(8000);
        
        while(true){
            
            System.out.println("Server in ascolto sulla porta "+ serverSocket.getLocalPort());
            
            Socket clientSocket= serverSocket.accept();
            
            BufferedReader in= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            BufferedWriter out=new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            
            String clientSentence= in.readLine();
            
            System.out.println("Stringa ricevuta: " + clientSentence);
            
            String capitalizedSentence= clientSentence.toUpperCase();
            
            out.write(capitalizedSentence);
            
            out.newLine();
            
            out.flush();
            
            in.close();
            
            clientSocket.close();
            
        }
        
        
        // TODO code application logic here
    }
    
}

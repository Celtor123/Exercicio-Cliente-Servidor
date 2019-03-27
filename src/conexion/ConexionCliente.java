
package conexion;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ConexionCliente {

    public static void main(String[] args) {
      
		try{
                 
			System.out.println("Creando socket cliente");
			Socket clienteSocket=new Socket();
			System.out.println("Estableciendo la conexion");
			
			InetSocketAddress addr=new InetSocketAddress("localhost",6666);
			clienteSocket.connect(addr);

			InputStream is = clienteSocket.getInputStream();
			OutputStream os= clienteSocket.getOutputStream();
			System.out.println("Enviando mensajes");
                        
                            byte[]a= new byte[23];                 
                           for(int i=0;i<5;i++){                          
                         String g=JOptionPane.showInputDialog("Ingrese un número");
                         
                         os.write(g.getBytes());                         
                        System.out.println(g);
                          System.out.println("Mensaje enviado");         
                        }                         
			
                          
                System.out.println("Los 5 numeros enviados");
                
                is.read(a);
                String h= new String(a);
                double tr=Double.parseDouble(h);
                    System.out.println("El resultado es "+tr);
			System.out.println("Cerrando el socket cliente");

			clienteSocket.close();

			System.out.println("Terminado");
                    
			}catch (IOException e) {
			}
      }
    
    
}

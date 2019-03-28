
package conexion;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
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
                        byte[] mensaje=new byte[25];
                           for(int i=0;i<3;i++){
			String mensajes=JOptionPane.showInputDialog("Ingrese mensaxe");
			os.write(mensajes.getBytes());
                         
			System.out.println("Mensaje enviado");
                        is.read(mensaje);
                               System.out.println("Mensaxe do servidor:"+new String(mensaje));
                           }
			System.out.println("Cerrando el socket cliente");

			clienteSocket.close();

			System.out.println("Terminado");
                    
			}catch (IOException e) {
				e.printStackTrace();
			}
    }
    
    
}

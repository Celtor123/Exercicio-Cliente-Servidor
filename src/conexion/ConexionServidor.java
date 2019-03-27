
package conexion;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ConexionServidor {
    ArrayList numser= new ArrayList();
    public static void main(String[] args){
		try{
                    
			System.out.println("Creando socket servidor");
	
			ServerSocket serverSocket=new ServerSocket();

			System.out.println("Realizando el bind");

			InetSocketAddress addr=new InetSocketAddress("localhost",6666);
			serverSocket.bind(addr);

			System.out.println("Aceptando conexiones");

			Socket newSocket= serverSocket.accept();
                         
			System.out.println("Conexion recibida");

			InputStream is=newSocket.getInputStream();
			OutputStream os=newSocket.getOutputStream();
                        	byte[] a=new byte[23];
                                 double lista[]=new double[5];
                                String h = null;
                              double result;
                           for(int i=0;i<5;i++){   
                           is.read(a);
                              h= new String(a);
                             
                              try {
                              result= Double.parseDouble(h);
                              lista[i]=result;
                           System.out.println(result);
                        }catch (NumberFormatException e){
                                 System.out.println("no es un numero aceptado"); 
                              }                            
                           }
                           System.out.println("numeros recibidos");
                            System.out.println("Enviando resultados");
                          double resultado=lista[0]+lista[1]+lista[2]+lista[3]+lista[4];
                          String f=resultado+"";
                        os.write(f.getBytes());
                                   
                               
                        
			
                       
			

			newSocket.close();
                       
			System.out.println("Cerrando el socket servidor");

			serverSocket.close();

			System.out.println("Fin");

                     }catch (IOException e) {
                         System.out.println("Error "+e);
			}
		}

}


package conexion2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Conexion2 {
    public static void main(String[] args){
		try{
			System.out.println("Creando socket datagrama");

			InetSocketAddress addr=new InetSocketAddress("localhost",5556);
			DatagramSocket datagramSocket=new DatagramSocket(addr);                        
                        byte[] mensaje=new byte[25];
                        String g="Holaq soy Celso";
                      mensaje=g.getBytes();
			System.out.println("Enviando mensaje");

			InetAddress addr2=InetAddress.getByName("localhost");
			DatagramPacket datagrama2=
				new DatagramPacket(mensaje, mensaje.length,addr2,5555);
			datagramSocket.send(datagrama2);

			System.out.println("Mensaje enviado");
                        byte[] mensaje2=new byte[25];
                        DatagramPacket datagramarecibe=new DatagramPacket(mensaje2,25);
                        datagramSocket.receive(datagramarecibe);
                        System.out.println("Mensaje recibido"+new String(mensaje2));
			System.out.println("Cerrando el socket datagrama");

			datagramSocket.close();

			System.out.println("Terminado");

		}catch(IOException e){
			e.printStackTrace();
		}

    }}

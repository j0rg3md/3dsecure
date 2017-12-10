/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoservidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocketFactory;

/**
 *
 * @author jorge
 */
public class BancoServidor {
    private static int puerto = 8888;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Establece donde se encuentran el almacen de mi certificado y los de confianza
        System.setProperty("javax.net.ssl.keyStore", "src\\certificados\\serverKeyBanco.jks");
        System.setProperty("javax.net.ssl.keyStorePassword","hola007");
        System.setProperty("javax.net.ssl.trustStore", "src\\certificados\\serverTrustedKeyBanco.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "hola007");
        
        //Creo el SSL SOCKET
        SSLServerSocketFactory serverFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            ServerSocket serverSocket = serverFactory.createServerSocket(puerto);
            System.out.println("Servidor seguro iniciado en el puerto: "+puerto);
        } catch (IOException ex) {
            Logger.getLogger(BancoServidor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error: al crear el socket en el puerto: "+puerto);
        }
    }
    
}

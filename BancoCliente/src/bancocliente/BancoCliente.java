/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancocliente;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author jorgelinux
 */
public class BancoCliente {
private static String ip = "127.0.0.1";
private static int puerto = 8888;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Establece donde se encuentran el almacen de mi certificado y los de confianza
        System.setProperty("javax.net.ssl.keyStore", 
                "src/certificados/bancoCliente.jks");
        System.setProperty("javax.net.ssl.keyStorePassword","hola007");
        System.setProperty("javax.net.ssl.trustStore", 
                "src/certificados/clientTrusteKey.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "hola007");
    
        SSLSocketFactory clientFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    try {
        Socket client = clientFactory.createSocket(ip, puerto);
        System.out.println("Servidor Conectado");
    } catch (IOException ex) {
        Logger.getLogger(BancoCliente.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Saludo defectuoso");
    }
    }
    
}

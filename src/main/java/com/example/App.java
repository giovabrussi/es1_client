package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        try {

            System.out.println( "Client in esecuzione" );
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            out.writeBytes("ciao a tutti"+'\n');

            String stringaRicevuta = in.readLine();
            System.out.println("la stringa ricevuta: "+stringaRicevuta);

            s.close();

        } catch (Exception e) {
            System.out.println( e.getMessage() );
            System.out.println( "Errore di istanza nel server" );
        }

        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosockets01;

import java.net.*;
import java.io.*;

public class FicheroClienteTCP {

    public static void main (String[] args){
        DataInputStream input;
        BufferedInputStream bis;
        BufferedOutputStream bos;
        int in;
        byte[] byteArray;
        //Fichero a transferir
        final String filename = "D:\\hola.txt";

       try{
        final File localFile = new File( filename );
        Socket client = new Socket("localhost", 8000);
        bis = new BufferedInputStream(new FileInputStream(localFile));
        bos = new BufferedOutputStream(client.getOutputStream());
        //Enviamos el nombre del fichero
        DataOutputStream dos=new DataOutputStream(client.getOutputStream());
        dos.writeUTF(localFile.getName());
        //Enviamos el fichero
        byteArray = new byte[8192];
        while ((in = bis.read(byteArray)) != -1){
            bos.write(byteArray,0,in);
        }

       bis.close();
        bos.close();

       }catch ( Exception e ) {
        System.err.println(e);
        }
    }
    
}

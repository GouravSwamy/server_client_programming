/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_chat_socket_application;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author RITIK
 */
public class Client {
    public static void main(String[] args) {
        try{
        String ip="localhost";
        int port=9449;
        ServerSocket ss= new ServerSocket(port);
        Socket s=ss.accept();
        
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msgin="" , msgout="";
        
        while(!msgin.equals("ends")){
        msgin = din.readUTF();
            System.out.println("Server :" +msgin);
            msgout  = br.readLine();
            dout.writeUTF(msgout);
            dout.flush();
        }    
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
}

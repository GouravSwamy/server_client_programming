/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_chat_socket_application;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author RITIK
 */
public class Server {
    public static void main(String[] args){
        try
        {
        String ip ="localhost";
        int port=9449;
        Socket s = new Socket(ip,port);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String msgin="",msgout="";
      
        while(!msgin.equals("end")){
        msgout=br.readLine();
        dout.writeUTF(msgout);
        msgin=din.readUTF();
            System.out.println("Client : "+msgin);
        } 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
      
    }
   
    
}

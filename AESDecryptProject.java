/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projects;

import static Projects.AESEncryptProject.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author C-Dhant
 */
public class AESDecryptProject implements ActionListener {
    private static SecretKeySpec secretKey;
	private static byte[] key;
        JFrame f1;
        JLabel l1,l2,l3;
        JTextField t1,t2,t3;
        JButton b1;
        AESDecryptProject()
        {
            f1 = new JFrame();
            f1.setSize(400,400);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setLayout(new GridLayout(4,2));
            
            l1 = new JLabel("Message");
            l2 = new JLabel("Key");
            l3 = new JLabel("Decrypted Message");
            
            t1= new JTextField();
            t2= new JTextField();
            t3= new JTextField();
            
            b1=new JButton("Decrypt");
            
            f1.add(l1);f1.add(t1);
            f1.add(l2);f1.add(t2);
            f1.add(l3);f1.add(t3);
            f1.add(b1);
            
            b1.addActionListener(this);
            f1.setVisible(true);
        }

    public static void main(String[] args) {
        new AESDecryptProject();
    }
    public static void setKey(String myKey) 
	{
		
			key = myKey.getBytes();
			key = Arrays.copyOf(key, 16); 
			secretKey = new SecretKeySpec(key, "AES");
	}
 
    public static String decrypt(String strToDecrypt, String secret) 
	{
		try 
		{
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} 
		catch (Exception e) 
		{
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}
    
public void actionPerformed(ActionEvent e)
     {
         String myKey = t2.getText();
             String strToDecrypt = t1.getText();
         if(e.getSource()==b1)
         {
              String c = AESDecryptProject.decrypt(strToDecrypt, myKey); 
              t3.setText(c+"");
         }
         
     }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projects;

/**
 *
 * @author C-Dhant
 */

import java.util.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AESEncryptProject implements ActionListener{

	private static SecretKeySpec secretKey;
	private static byte[] key;
        JFrame f1;
        JLabel l1,l2,l3;
        JTextField t1,t2,t3;
        JButton b1;
        AESEncryptProject()
        {
            f1 = new JFrame();
            f1.setSize(400,400);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setLayout(new GridLayout(4,2));
            
            l1 = new JLabel("Message");
            l2 = new JLabel("Key");
            l3 = new JLabel("Encrypted Message");
            
            t1= new JTextField();
            t2= new JTextField();
            t3= new JTextField();
            
            b1=new JButton("Encrypt");
            
            f1.add(l1);f1.add(t1);
            f1.add(l2);f1.add(t2);
            f1.add(l3);f1.add(t3);
            f1.add(b1);
            
            b1.addActionListener(this);
            f1.setVisible(true);
        }

    public static void main(String[] args) {
        new AESEncryptProject();
    }
	public static void setKey(String myKey) //creating the secret key
	{
		
			key = myKey.getBytes();
			key = Arrays.copyOf(key, 16); 
			secretKey = new SecretKeySpec(key, "AES");
	}

	public static String encrypt(String strToEncrypt, String secret) //encryption method
	{
		try 
		{
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);//initate encryption mode
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));//base64.getencoder encodes using the Basic type base64 encoding scheme
		} 
		catch (Exception e) 
		{
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	/*public static String decrypt(String strToDecrypt, String secret) 
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
	}*/
        
     public void actionPerformed(ActionEvent e)
     {
         String myKey = t2.getText();
             String strToEncrypt = t1.getText();
         if(e.getSource()==b1)
         {
              String c = AESEncryptProject.encrypt(strToEncrypt, myKey); 
              t3.setText(c+"");
         }
         
     }
/*public static void main(String[] args) 
{
     System.out.println("Enter the secret key");
     Scanner s = new Scanner(System.in);
     String secretKey = s.next();
     
     
     Scanner sr = new Scanner(System.in);
     System.out.println("Enter the message");
     String originalString =sr.nextLine();
             
     
    String encryptedString = AESEncryptProject.encrypt(originalString, secretKey) ;
    String decryptedString = AESEncryptProject.decrypt(encryptedString, secretKey) ;
    //AESDecryptProject obj = new AESDecryptProject(encryptedString,secretKey);
     
    System.out.println(originalString);
    System.out.println(encryptedString);
    System.out.println(decryptedString);
}*/
}

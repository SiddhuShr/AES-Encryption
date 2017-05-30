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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EncryptDecrypt {
    JFrame f1;
    JButton b1,b2;
    EncryptDecrypt()
    {
        f1=new JFrame();
        f1.setSize(400,400);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GridBagLayout g1 = new GridBagLayout();
        f1.setLayout(g1);
        GridBagConstraints gbc= new GridBagConstraints();
        
         b1= new JButton("Encrypt");
        gbc.gridx=1;
        gbc.gridy=0;
        g1.setConstraints(b1,gbc);
        
        b2= new JButton("Decrypt");
        gbc.gridx=1;
        gbc.gridy=1;
        g1.setConstraints(b2,gbc);
        
        f1.add(b1);
        f1.add(b2);
        f1.setVisible(true);
        b1.addActionListener(new ActionListener()
       {
        public void actionPerformed(ActionEvent e)
        {   
                 new AESEncryptProject();
            
        }
       });
        
         b2.addActionListener(new ActionListener()
       {
        public void actionPerformed(ActionEvent e)
        {   
                 new AESDecryptProject();
            
        }
       });
         //f1.setVisible(false);
    }
    
    public static void main(String[] args) {
        new EncryptDecrypt();
    }
}

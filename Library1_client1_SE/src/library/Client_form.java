/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Zofia
 */
public class Client_form extends JPanel implements ActionListener{
    JTextField b1 = new JTextField("Clients");
   
    public Client_form() {
        add(b1);
       }

    @Override
    public void actionPerformed(ActionEvent e) {
        //tutaj mo na wywolac uslugi
    }
    
}

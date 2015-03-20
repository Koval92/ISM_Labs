/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import client_tier.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Zofia
 */
public class Client_form extends JPanel implements ActionListener{
    JLabel clientIdLabel = new JLabel("Client id");
    JTextField clientId = new JTextField(30);
    JLabel clientNameLabel = new JLabel("Client name");
    JTextField clientName = new JTextField(30);
    JButton add_client = new JButton("Add client");
   
    public Client_form() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(clientIdLabel);
        add(clientId);
        add(clientNameLabel);
        add(clientName);
        add(add_client);
        }

    public void init()
    {
          add_client.addActionListener(this); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] data = form_client();
        if(data == null){
            return;
        }
        Client.getFacade().add_client(data);
    }
    
    public String[] form_client() {
        if(content_validate(clientId) == null){
            return null;
        }
        String data[] = {clientId.getText(), clientName.getText()};
        return data;
    }
    
    public String content_validate(JTextField val) {
        String s = val.getText();
        if (s.equals("")) {
            JOptionPane.showMessageDialog(this, "required value");
            return null;
        } else {
            s = s.replaceAll(" ", "_");
            val.setText(s);
            return s;
        }
    }
}

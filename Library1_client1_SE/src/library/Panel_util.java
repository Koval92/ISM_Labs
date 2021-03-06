/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


/**
 *
 * @author Zofia
 */
public class Panel_util implements ActionListener {
      
    JPanel cards; //a panel that uses CardLayout
    final static String CLIENT = "Clients";
    final static String TITLE = "Title form";
    final static String BOOK = "Book form";
    final static String LOAN = "Loan book";
 
    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();

        menu = new JMenu("Library");
        menu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menu);

        menuItem = new JMenuItem(TITLE, KeyEvent.VK_T);
        menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(BOOK);
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem(CLIENT);
        menuItem.setMnemonic(KeyEvent.VK_C);
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(LOAN);
        menuItem.setMnemonic(KeyEvent.VK_L);
        menuItem.addActionListener(this);
        menu.add(menuItem);

//        menu.addSeparator();
//        JMenu submenu = new JMenu("A submenu");
//        submenu.setMnemonic(KeyEvent.VK_S);
//
//        menuItem = new JMenuItem(CLIENT);
//        menuItem.setAccelerator(KeyStroke.getKeyStroke(
//                KeyEvent.VK_2, ActionEvent.ALT_MASK));
//        menuItem.addActionListener(this);
//        submenu.add(menuItem);
//
//        menuItem = new JMenuItem(CLIENT);
//        menuItem.addActionListener(this);
//        submenu.add(menuItem);
//        
//        menu.add(submenu);

//        //Build second menu in the menu bar.
//        menu = new JMenu("Another Menu");
//        menu.setMnemonic(KeyEvent.VK_N);
//        menuBar.add(menu);

        return menuBar;
    }

       

    public Container createContentPane() {
        //Create the content-pane-to-be.
        Client_form card2 = new Client_form();
        card2.init();
        Title_form card0 = new Title_form();
        card0.init();
        Book_form card1 = new Book_form();
        card1.init();
        Loan_form card3 = new Loan_form();
        card3.init();

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card0, TITLE);
        cards.add(card1, BOOK);
        cards.add(card2, CLIENT);
        cards.add(card3, LOAN);

        JPanel p1 = new JPanel();

        p1.add(cards, BorderLayout.CENTER);
        return p1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JMenuItem source = (JMenuItem) (e.getSource());
        CardLayout cl = (CardLayout) (cards.getLayout());
        if (source.getText().equals(TITLE)) {
            cl.show(cards, TITLE);
        } else if (source.getText().equals(BOOK)) {
            cl.show(cards, BOOK);
        } else if (source.getText().equals(CLIENT)) {
            cl.show(cards, CLIENT);
        } else if (source.getText().equals(LOAN)) {
            cl.show(cards, LOAN);
        }
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("MenuDemo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 460);
        //Create and set up the content pane.
        Panel_util demo = new Panel_util();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());

        //Display the window.
        frame.setVisible(true);
    }
}
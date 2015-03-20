package library;

import client_tier.Client;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

public class Loan_form extends JPanel implements ActionListener {

    private JTable table;
    private JTextField isbn;
    private JTextField actor;
    private JButton loan_book;
    int row;
    MyTableModel model;
    JComboBox loans;

    public Loan_form() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        model = new MyTableModel();
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);
        table.getSelectionModel().addListSelectionListener(new RowListener());

        add(new JScrollPane(table));

        JLabel lisbn = new JLabel("Book's ISBN");
        add(lisbn);
        isbn = new JTextField();
        add(isbn);
        JLabel lactor = new JLabel("Book's actor");
        add(lactor);
        actor = new JTextField();
        add(actor);
        loan_book = new JButton("Loan book");
        add(loan_book);
      //  add_book.addActionListener(this);
        JLabel lloans = new JLabel("Client's loans");
        add(lloans);
        loans = new JComboBox();
        add(loans);
    }

    public void init()
    {
        table_content();
        loan_book.addActionListener(this);
    }
    
    String[] client() {
        String who;
        who = (String) model.getValueAt(row, 0);
        String data[] = {who};
        return data;
    }

    private void list_content(ArrayList<String> col, JComboBox list) {
        String s;
        list.removeAllItems();
        Iterator<String> iterator = col.iterator();
        while (iterator.hasNext()) {
            s = iterator.next();
            list.addItem(s);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        table_content();
    }

    void table_content() {
        Object[][] clients = Client.getFacade().getClientsTable();
        model.setData(clients);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (!table.getSelectionModel().isSelectionEmpty()) {
            String what_title_type;
            if (isbn.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "required value");
                return;
            }
            if (actor.getText().equals("")) {
                what_title_type = "0";
            } else {
                what_title_type = "2";
            }
            String data2[] = {what_title_type, (String) isbn.getText(),
                (String) actor.getText()};
            ArrayList<String> help3 = Client.getFacade().add_loan(client(), data2);
            if (help3 != null) {
                list_content(help3, loans);
            }
        }
    }

    void print_loans() {
        ArrayList<String> help3 = Client.getFacade().searchClientsLoans(client());
        if (help3 != null) {
            list_content(help3, loans);
        }
    }

    private class RowListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
                return;
            }
            row = table.getSelectionModel().getLeadSelectionIndex();
            print_loans();
        }
    }

    class MyTableModel extends AbstractTableModel {

        private final String[] columnNames = {  "Client ID", 
                                                "Number of loans",
                                                "Client Name"};
        private Object[][] data;

        public void setData(Object[][] val) {
            data = val;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return col < 0;
        }
        
        @Override
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }
}

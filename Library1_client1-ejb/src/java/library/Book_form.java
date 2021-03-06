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

/**
 *
 * @author Zofia
 */
public class Book_form extends JPanel implements ActionListener {

    private JTable table;
    private JTextField number;
    private JTextField period;
    private JButton add_book;
    int row;
    MyTableModel model;
    JComboBox books;

    public Book_form() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        model = new MyTableModel();
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);
        table.getSelectionModel().addListSelectionListener(new RowListener());

        add(new JScrollPane(table));

        JLabel lnumber = new JLabel("Number of a book");
        add(lnumber);
        number = new JTextField();
        add(number);
        JLabel lperiod = new JLabel("Period of a book");
        add(lperiod);
        period = new JTextField();
        add(period);
        add_book = new JButton("Add book");
        add(add_book);
      //  add_book.addActionListener(this);
        JLabel lbooks = new JLabel("Books");
        add(lbooks);
        books = new JComboBox();
        add(books);
    }

    public void init()
    {
        table_content();
        add_book.addActionListener(this);
    }
    String[] title() {
        String what, actor;
        actor = (String) model.getValueAt(row, 4);
        if (actor.isEmpty())//what type of title of book
        {
            what = "0";
        } else {
            what = "2";
        }
        String data[] = {what, (String) model.getValueAt(row, 1), actor};
        return data;
    }

    private void list_content(ArrayList<String> col,JComboBox list) {
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
        Object[][] titles = Client.getFacade().gettitle_books();
        model.setData(titles);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (!table.getSelectionModel().isSelectionEmpty()) {
            String what_book_type;
            if (number.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "required value");
                return;
            }
            if (period.getText().equals("")) {
                what_book_type = "0";
            } else {
                what_book_type = "1";
            }
            String data2[] = {what_book_type, (String) number.getText(),
                (String) period.getText()};
            ArrayList<String> help3 = Client.getFacade().add_book(title(), data2);
            if (help3 != null) {
                list_content(help3, books);
            }
        }
    }

    void print_books() {

        ArrayList<String> help3 = Client.getFacade().Search_title_book(title());
        if (help3 != null) {
            list_content(help3, books);
        }
    }

    private class RowListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
                return;
            }
            row = table.getSelectionModel().getLeadSelectionIndex();
            print_books();
        }
    }

    class MyTableModel extends AbstractTableModel {

        private final String[] columnNames = {"Publisher",
            "ISBN",
            "Title",
            "Author",
            "Actor"};
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

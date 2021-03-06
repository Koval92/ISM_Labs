package sub_business_tier;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sub_business_tier.entities.TBook;
import sub_business_tier.entities.TClient;
import sub_business_tier.entities.TTitle_book;

public class TFacade {

    List<TTitle_book> mTitle_books;
    List<TClient> mClients;

    public TFacade() {
        mTitle_books = new ArrayList<>();
        mClients = new ArrayList<>();
    }

    public List<TTitle_book> getmTitle_books() {
        return mTitle_books;
    }

    public void setmTitle_books(List<TTitle_book> mTitle_books) {
        this.mTitle_books = mTitle_books;
    }

    public static void main(String[] t) {
        System.out.println("1st iteration");
        TFacade ap = new TFacade();
        String t1[] = {"1", "Author1","Title1", "ISBN1", "Publisher1"};
        String t2[] = {"1", "Author2","Title2", "ISBN2", "Publisher2"};
        String t3[] = {"1", "Author3","Title3", "ISBN3", "Publisher3"};
        String t4[] = {"3", "Author1","Title1", "ISBN1", "Publisher1", "Actor1"};
        String t5[] = {"3", "Author2","Title2", "ISBN2", "Publisher2", "Actor2"};
        String t6[] = {"3", "Author4","Title4", "ISBN4", "Publisher4", "Actor4"};
        ap.add_title_book(t1);
        ap.add_title_book(t2);
        ap.add_title_book(t2);
        ap.add_title_book(t3);
        ap.add_title_book(t4);
        ap.add_title_book(t5);
        ap.add_title_book(t5);
        ap.add_title_book(t6);
        String lan = ap.getmTitle_books().toString();
        System.out.println(lan);

        System.out.println("2nd iteration");
        String d1[] = {"0", "ISBN1"};
        String d2[] = {"0", "ISBN2"};
        String d3[] = {"0", "ISBN5"};
        String d4[] = {"2", "ISBN1", "Actor1"};
        String d5[] = {"2", "ISBN4", "Actor4"};
        String tr1[] = {"0", "1"};
        String tr2[] = {"0", "2"};
        String tr3[] = {"1", "3", "3"};
        String tr4[] = {"1", "2", "-1"};
        ArrayList<String> pom = ap.add_book(d1, tr1);
        if (pom != null) { System.out.print(pom); }
        pom = ap.add_book(d2, tr1);
        if (pom != null) { System.out.print(pom); }
        pom = ap.add_book(d2, tr1);
        if (pom != null) { System.out.print(pom); }
        pom = ap.add_book(d2, tr2);
        if (pom != null) { System.out.print(pom); }
        pom = ap.add_book(d3, tr2);
        if (pom != null) { System.out.print(pom); }
        pom = ap.add_book(d4, tr3);
        if (pom != null) { System.out.print(pom); }
        pom = ap.add_book(d4, tr3);
        if (pom != null) { System.out.print(pom); }
        pom = ap.add_book(d4, tr4);
        if (pom != null) { System.out.print(pom); }
        pom = ap.add_book(d5, tr2);
        if (pom != null) { System.out.print(pom); }
        System.out.println();

        System.out.println("4th iteration");
        ap.Print_title_books();
        ap.Print_books();
        System.out.println();

        System.out.println("3rd iteration");
        System.out.println("Searching of a title");
        System.out.println(ap.Search_title_book(t6));
        System.out.println("Searching of an accessible book of a select title");
        System.out.println(ap.Search_accessible_book(d4, "2"));
        System.out.println();
       
        // 2nd assessment
        String[] client1 = {"1", "Adam Nowak"};
        String[] client2 = {"2", ""};
        String[] client3 = {"2", "Jan Kwiatkowski"};
        String[] client4 = {"1", ""};
        ap.add_client(client1);
        ap.add_client(client2);
        ap.add_client(client1);
        ap.add_client(client2);
        ap.add_client(client3);
        ap.add_client(client4);
        ap.printClients();
        
        String titleBookToLoan1[] = {"0", "ISBN1", ""};
        String titleBookToLoan2[] = {"0", "ISBN2", ""};
        String titleBookToLoan3[] = {"2", "ISBN1", "Actor1"};
        String titleBookToLoan4[] = {"2", "ISBN4", "Actor4"};
        
        ap.add_loan(client1, titleBookToLoan1);
        ap.add_loan(client1, titleBookToLoan2);
        ap.add_loan(client2, titleBookToLoan3);
        ap.add_loan(client2, titleBookToLoan1);
        ap.printClients();
        ap.Print_books();
    }

    public Object[][] gettitle_books() {
        Object[][] title_books = new String[mTitle_books.size()][5]; // dziwne cos w UMLu
        Iterator help = mTitle_books.iterator();
        TTitle_book next;

        for (int i=0; help.hasNext(); i++)
        {
            next=(TTitle_book) help.next();
            title_books[i]=next.toString_();
        }
        return title_books;
    }
    
    public Object[][] getClientsTable(){
        Object[][] clientsTable = new String[mClients.size()][3];
        int i = 0;
        
        for(TClient client : mClients)
        {
            clientsTable[i++] = client.toStringArray();
        }
        
        return clientsTable;
    }

    public TTitle_book search_title_book(TTitle_book title_book) {
        int idx = mTitle_books.indexOf(title_book);
        if(idx != -1)
            return mTitle_books.get(idx);
        return null;
    }

    public String add_title_book(String[] data) {
        TFactory factory = new TFactory();
        TTitle_book titleBook = factory.create_title_book(data);
        if (search_title_book(titleBook) == null)
        {
            mTitle_books.add(titleBook);
            return titleBook.toString();
        }
        return null;
    }

    public ArrayList<String> add_book(String[] titleBookData, String[] bookData) {
        TTitle_book help1, title_exist;
        TFactory factory = new TFactory();

        help1 = factory.create_title_book(titleBookData);
        title_exist = search_title_book(help1);
        if(title_exist != null)
            return title_exist.add_book(bookData);
        else
            return null;
    }

    public ArrayList<String> Search_title_book(String[] data) {
        TTitle_book title_book_help, title_exist;
        TFactory factory = new TFactory();

        title_book_help = factory.create_title_book(data);
        title_exist=search_title_book(title_book_help);
        if(title_exist != null)
            return title_exist.getbooks();
        return null;
    }

    public String Search_accessible_book(String[] data1, Object data2) {
        TTitle_book title_book_help, title_exist;
        TFactory factory = new TFactory();

        title_book_help = factory.create_title_book(data1);
        title_exist = search_title_book(title_book_help);

        if(title_exist != null)
            return title_exist.search_accessible_book(data2);
        return null;
    }

    public void Print_books() {
        PrintStream out = System.out;
        List<String> help_list;
        out.println("Books:");
        TTitle_book obj1;

        for(int i = 0; i < mTitle_books.size(); i++)
        {
            obj1 = mTitle_books.get(i);
            help_list = obj1.getbooks();
            for(int j=0; j<help_list.size(); j++)
            {
                out.print(help_list.get(j));
                out.println();
            }
        }
    }

    public void Print_title_books() {
        PrintStream out = System.out;
        Object[][] help_list;

        out.println("Title books:");
        help_list = gettitle_books();
        for (Object[] next : help_list)
        {
            for (Object property : next)
                out.print(property.toString() + " ");
            out.println();
        }
    }
    
    public void printClients()
    {
        System.out.println("Clients:");
        for(TClient client : mClients)
            System.out.println(client);
    }

    public ArrayList<String> add_loan(String[] clientData, String[] titleBookData)
    {
        TFactory factory = new TFactory();
        TClient client = search_client(new TClient(clientData));
        if(client == null)
            return null;
        
        TTitle_book titleBook = factory.create_title_book(titleBookData);
        titleBook = search_title_book(titleBook);
        if(titleBook == null)
            return null;
        TBook availableBook = titleBook.getAvailableBook();
        if(availableBook == null)
        {
            return null;
        }
        return client.add_loan(availableBook, new String[0]);
    }

    public ArrayList<String> add_client(String[] data)
    {
        TClient newClient = new TClient(data);
        if(search_client(newClient) == null)
        {
            mClients.add(newClient);
            return getListOfClientsAsStrings();
        }
        return null;
    }

    public ArrayList<String> getListOfClientsAsStrings()
    {
        ArrayList<String> listOfClients = new ArrayList<>();
        for(TClient client : mClients)
            listOfClients.add(client.toString());
        return listOfClients;
    }

    public TClient search_client(TClient client)
    {
        int idx = mClients.indexOf(client);
        if(idx != -1)
            return mClients.get(idx);
        return null;
    }
    
    public ArrayList<String> searchClientsLoans(String[] data){
        TClient client = search_client(new TClient(data));
        
        return client.getLoansAsStrings();
    }
}
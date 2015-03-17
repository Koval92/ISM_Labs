package library1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class TTitle_book {

    private String publisher;

    private String ISBN;

    private String title;

    private String author;

    List<TBook> mBooks;

    public TTitle_book() {
        mBooks = new ArrayList<>();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<TBook> getmBooks() {
        return mBooks;
    }

    public void setmBooks(List<TBook> mBooks) {
        this.mBooks = mBooks;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.ISBN);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        TTitle_book otherBook = (TTitle_book) obj;
        String thisISBN, otherISBN, thisActor, otherActor;
        thisISBN = this.getISBN();
        thisActor = this.getActor();
        otherISBN = otherBook.getISBN();
        otherActor = otherBook.getActor();

        return thisISBN.equals(otherISBN) && thisActor.equals(otherActor);
    }

    public String getActor() {
        return "";
    }

    public void setActor(String val) {
        System.out.println("This is NOT a book on tape...");
    }

    @Override
    public String toString () {
        return "Title: " + title
                + " Author: " + author
                + " ISBN: " + ISBN
                + " Publisher: " + publisher;
    }

    public String[] toString_() {
        String[] title1 = new String[5];
        title1[0] = getPublisher();
        title1[1] = getISBN();
        title1[2] = getTitle();
        title1[3] = getAuthor();
        title1[4] = getActor();
        return title1;
    }

    public ArrayList<String> add_book(String[] data) {
        TFactory factory = new TFactory();
        TBook newbook = factory.create_book(data);

        if(search_book(newbook) == null)
        {
            mBooks.add(newbook);
            newbook.setmTitle_book(this);
            return getbooks();
        }
        return null;
    }

    public TBook search_book(TBook book) {
        int idx = mBooks.indexOf(book);
        if(idx != -1)
            return mBooks.get(idx);
        else
            return null;
    }

    public String search_accessible_book(Object data) {
        TBook help_book;
        Iterator help = mBooks.iterator();

        while(help.hasNext())
        {
            help_book = (TBook) help.next();
            if(help_book.period_pass(data))
                return help_book.toString();
        }

        return null;
    }

    public ArrayList<String> getbooks() {
        TBook next;
        Iterator help = mBooks.iterator();
        ArrayList<String> title_books = new ArrayList<>();

        while (help.hasNext())
        {
            next=(TBook) help.next();
            title_books.add(next.toString());
        }
        return title_books;
    }

    public TBook getAvailableBook() {
        for(TBook book : mBooks)
        {
            if (book.getLoan() == null)
                return book;
        }
        return null;
    }
}
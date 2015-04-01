package sub_business_tier;

import java.util.Date;
import sub_business_tier.entities.TBook;
import sub_business_tier.entities.TBook_period;
import sub_business_tier.entities.TTitle_book;
import sub_business_tier.entities.TTitle_book_on_tape;

public class TFactory {

    static final long day = 24*60*60*1000; // day length in miliseconds

    public static Date mdays(String data) {
        Date today = new Date();

        return new Date(today.getTime() + day * Integer.parseInt(data));
    }

    public TTitle_book create_title_book(String[] data) {
        TTitle_book titleBook;
        switch (Integer.parseInt(data[0])) //what_title_book_type
        {
            case 0: //TTitle_book object for searching
                titleBook = new TTitle_book();
                titleBook.setISBN(data[1]);
                break;
            case 1: //TTitle_book object for persisting
                titleBook = new TTitle_book();
                titleBook.setAuthor(data[1]);
                titleBook.setTitle(data[2]);
                titleBook.setISBN(data[3]);
                titleBook.setPublisher(data[4]);
                break;
            case 2: //TTitle_book_on_tape object for searching
                titleBook = new TTitle_book_on_tape();
                titleBook.setISBN(data[1]);
                titleBook.setActor(data[2]);
                break;
            case 3: //TTitle_book_on_tape object for persisting
                titleBook = new TTitle_book_on_tape();
                titleBook.setAuthor(data[1]);
                titleBook.setTitle(data[2]);
                titleBook.setISBN(data[3]);
                titleBook.setPublisher(data[4]);
                titleBook.setActor(data[5]);
                break;
            default:
                titleBook = null;
                break;
        }
        return titleBook;
    }

    public TBook create_book(String[] data) {
        TBook book;
        int number;
        switch (Integer.parseInt(data[0]))
        {
            case 0:
                book = new TBook();
                number = Integer.parseInt(data[1]);
                book.setNumber(number);
                break;
            case 1:
                book = new TBook_period();
                number = Integer.parseInt(data[1]);
                book.setNumber(number);
                book.startPeriod(data[2]);
                break;
            default:
                book = null;
        }
        return book;
    }
}
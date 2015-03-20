package library1;

import java.util.ArrayList;
import java.util.List;

public class TClient {
    private static final int maxNumberOfLoans = 5;
    private List<TLoan> loans = new ArrayList<>(maxNumberOfLoans);
    private final int clientId;
    private final String clientName;

    public int getClientId() {
        return clientId;
    }

    public TClient(String[] data) {
        clientId = Integer.parseInt(data[0]);
        clientName = (data.length > 1) ? data[1] : "";
    }

    public ArrayList<String> getLoansAsStrings()
    {
        ArrayList<String> loansAsStrings = new ArrayList<>();
        for(TLoan loan : loans)
            loansAsStrings.add(loan.getBookAsString());
        return loansAsStrings;
    }

    public ArrayList<String> add_loan(TBook book, String[] data)
    {
        if(loans.size() >= maxNumberOfLoans)
            System.out.println("Client currently have max number of loans");
        else if( book.getLoan() != null)
            System.out.println("Book is currently in loan");
        else
        {
            TLoan newLoan = new TLoan(this, book);
            loans.add(newLoan);
            book.setLoan(newLoan);
        }

        return getLoansAsStrings();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TClient tClient = (TClient) o;

        return clientId == tClient.clientId;
    }

    @Override
    public int hashCode() {
        int result = loans != null ? loans.hashCode() : 0;
        result = 31 * result + clientId;
        return result;
    }

    @Override
    public String toString() {
        String base = "Id: " + clientId + ", Number of loans: " + loans.size();
        if(clientName == "")
            return base;
        else
            return base + ", Name: " + clientName;
    }
    
    public String[] toStringArray(){
        String[] clientAsArray = {  Integer.toString(clientId), 
                                    Integer.toString(loans.size()), 
                                    clientName};
        return clientAsArray;
    }
}

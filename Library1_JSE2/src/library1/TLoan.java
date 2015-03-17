package library1;

public class TLoan {
    private TClient client;
    private TBook book;

    public TLoan(TClient client, TBook book) {
        this.client = client;
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TLoan tLoan = (TLoan) o;

        return book.equals(tLoan.book) && client.equals(tLoan.client);
    }

    @Override
    public int hashCode() {
        int result = book.hashCode();
        result = 31 * result + client.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return book.toString() + " " + getClientAsString();
    }

    String getClientAsString() {
        return " Client: " + client.getClientId();
    }
}

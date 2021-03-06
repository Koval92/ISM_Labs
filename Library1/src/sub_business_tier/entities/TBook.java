package sub_business_tier.entities;

import java.util.Date;
import java.util.Objects;

public class TBook {
    private int number;
    private TLoan loan = null;
    TTitle_book mTitle_book;

    public TLoan getLoan() {
        return loan;
    }

    public void setLoan(TLoan loan) {
        this.loan = loan;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public TTitle_book getmTitle_book() {
        return mTitle_book;
    }

    public void setmTitle_book(TTitle_book mTitle_book) {
        this.mTitle_book = mTitle_book;
    }

    public boolean period_pass(Object data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void startPeriod(Object data) {
    }

    public Date getPeriod() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setPeriod(Date period) {
    }

    @Override
    public String toString() {
        return mTitle_book.toString() + " Number: " + number + loanToString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TBook other = (TBook) obj;
        if (this.number != other.number) {
            return false;
        }
        if (!Objects.equals(this.mTitle_book, other.mTitle_book)) {
            return false;
        }
        return true;
    }

    private String loanToString() {
            return loan == null ? "" : loan.getClientAsString();
    }
}

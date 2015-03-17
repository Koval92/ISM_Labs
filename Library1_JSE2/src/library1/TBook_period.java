package library1;

import java.util.Date;

public class TBook_period extends TBook {

    private Date period;

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }    

    public boolean period_pass(Object data) {
        Date date = TFactory.mdays((String) data);

        return period.compareTo(date) < 0;
    }

    public void startPeriod(Object data) {
        Date date = TFactory.mdays((String) data);
        setPeriod(date);
    }

    @Override
    public String toString() {
        return super.toString() + " Period: " + period;
    }
}

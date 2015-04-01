package sub_business_tier.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import sub_business_tier.TFactory;

@Entity
public class TBook_period extends TBook {
    private static final long serialVersionUID = 1L;
    
    @Temporal(TemporalType.DATE)
    private Date period;

    @Override
    public Date getPeriod() {
        return period;
    }

    @Override
    public void setPeriod(Date period) {
        this.period = period;
    }    

    @Override
    public boolean period_pass(Object data) {
        Date date = TFactory.mdays((String) data);

        return period.compareTo(date) < 0;
    }

    @Override
    public void startPeriod(Object data) {
        Date date = TFactory.mdays((String) data);
        setPeriod(date);
    }

    @Override
    public String toString() {
        return super.toString() + " Period: " + period;
    }
}

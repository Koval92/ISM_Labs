package library1;

public class TTitle_book_on_tape extends TTitle_book {

    private String actor;

    @Override
    public String toString() {
        return super.toString() + " Actor: " + actor;
    }

    @Override
    public String getActor() {
        return actor;
    }

    @Override
    public void setActor(String actor) {
        this.actor = actor;
    }
}
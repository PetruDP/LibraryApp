import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public abstract class Client{
    private String name;
    private String uniqueId;
    private int booksBorrowed;
    private Date dateReturn;
    private boolean haveABook;

    public Client(String name) {
        this.name = name;
        this.uniqueId = UUID.randomUUID().toString();
        this.booksBorrowed = 0;
        this.dateReturn = null;
        this.haveABook = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed() {
        this.booksBorrowed++;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(boolean myBoolean) {
        if(myBoolean){
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.MONTH, 1);
        this.dateReturn = c.getTime();
        } else{
            this.dateReturn = null;
        }
    }

    public boolean getHaveABook() {
        return haveABook;
    }

    public void setHaveABook(boolean haveABook) {
        this.haveABook = haveABook;
    }

    public abstract Colleges getCollege();
    public abstract int getCurrentYear();
}

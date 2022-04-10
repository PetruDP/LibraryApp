import java.time.LocalDate;

public class Client {
    private String name;
    private String uniqueId;
    private String type;
    private int booksBorrowed;
    private LocalDate dateReturn;
    private boolean haveABook;



    public void setBooksBorrowed() {
        this.booksBorrowed++;
    }

    public void setDateReturn(LocalDate dateReturn) {
        this.dateReturn = dateReturn;
    }

    public void setHaveABook(boolean haveABook) {
        this.haveABook = haveABook;
    }

    public LocalDate getDateReturn() {
        return dateReturn;
    }

    public boolean isHavingABook() {
        return haveABook;
    }

    public Client(String name, String uniqueId, String type) {
        this.name = name;
        this.uniqueId = uniqueId;
        this.type = type;
        this.booksBorrowed = 0;
        this.dateReturn = null;
        this.haveABook = false;

    }

    public String getName() {
        return name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getType() {
        return type;
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }
}

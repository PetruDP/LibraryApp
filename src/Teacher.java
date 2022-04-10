import java.util.Date;
import java.util.UUID;

public class Teacher {
    private String name;
    private int booksBorrowed;
    private Date dateReturn;
    private String subject;
    private String uniqueId;

    public Teacher(String name, int booksBorrowed, Date dateReturn, String subject) {
        this.name = name;
        this.booksBorrowed = booksBorrowed;
        this.dateReturn = dateReturn;
        this.subject = subject;
    }

    public Teacher(String name, String subject) {
        this.booksBorrowed = 0;
        this.dateReturn = null;
        this.name = name;
        this.subject = subject;
        this.uniqueId = UUID.randomUUID().toString();
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(int booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

import java.util.Date;
import java.util.UUID;

public class Student {
    private String name;
    private int booksBorrowed;
    private Date dateReturn;
    private String college;
    private int currentYear;
    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    public Student(String name, int booksBorrowed, Date dateReturn, String college, int currentYear) {
        this.name = name;
        this.booksBorrowed = booksBorrowed;
        this.dateReturn = dateReturn;
        this.college = college;
        this.currentYear = currentYear;
    }

    public Student(String name, String college, int currentYear) {
        this.booksBorrowed = 0;
        this.dateReturn = null;
        this.name = name;
        this.college = college;
        this.currentYear = currentYear;
        this.uniqueId = UUID.randomUUID().toString();
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getCurrentYear() {
        return currentYear;
    }

}





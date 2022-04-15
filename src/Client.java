import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Client extends StudentTeacher{
    private String name;
    private String uniqueId;
    private int booksBorrowed;
    private Date dateReturn;
    private boolean haveABook;


    public Client(String name, String  subject) {
        super(subject);
        this.name = name;
        this.uniqueId = UUID.randomUUID().toString();
        this.booksBorrowed = 0;
        this.dateReturn = null;
        this.haveABook = false;
    }

    public Client(String name, Colleges college, int currentYear) {
        super(college, currentYear);
        this.name = name;
        this.uniqueId = UUID.randomUUID().toString();
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

    public boolean getHaveABook() {
        return haveABook;
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
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

    public void setBooksBorrowed() {
        this.booksBorrowed++;
    }

    public void setHaveABook(boolean haveABook) {
        this.haveABook = haveABook;
    }

    @Override
    public String getSubject() {
        return super.getSubject();
    }

    @Override
    public void setSubject(String subject) {
        super.setSubject(subject);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public Colleges getCollege() {
        return super.getCollege();
    }

    @Override
    public void setCollege(Colleges college) {
        super.setCollege(college);
    }

    @Override
    public int getCurrentYear() {
        return super.getCurrentYear();
    }

    @Override
    public void setCurrentYear(int currentYear) {
        super.setCurrentYear(currentYear);
    }
}

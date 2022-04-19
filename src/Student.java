

public class Student extends Client{

    private Colleges college;
    private int currentYear;

    public Student(String name, Colleges college, int currentYear) {
        super(name);
        this.college = college;
        this.currentYear = currentYear;
    }

    public Colleges getCollege() {
        return college;
    }

    public void setCollege(Colleges college) {
        this.college = college;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public void getType(){
        System.out.println("Student");
    }
}





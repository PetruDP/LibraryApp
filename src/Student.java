

public class Student extends Client{

    private Colleges college;
    private int currentYear;

    public Student(String name, Colleges college, int currentYear) {
        super(name);
        // la setare de college ar trebui folosit un try-catch care sa verifice daca userul introduce o valoare din
        // Colleges (enum) si sa genereze o eroare (ex: "Nu exita aceasta facultate." )
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





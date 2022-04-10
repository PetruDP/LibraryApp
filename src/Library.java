import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Library {

    private Scanner sc = new Scanner(System.in);
    private String libraryName;

    ArrayList<Student> studentsList = new ArrayList<>();
    ArrayList<Teacher> teachersList = new ArrayList<>();
    ArrayList<Client> clientsList = new ArrayList<>();
    ArrayList<Book> booksList = new ArrayList<>();
    ArrayList<Client> bookHolders = new ArrayList<>();


    public Library(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void addStudent() {
        System.out.println("Name: ");
        String name = sc.nextLine();
        if (studentNameAlreadyExists(name)) {
            System.out.println("Name already in use.");
            addStudent();
        }
        System.out.println("College:");
        String college = sc.nextLine();

        System.out.println("Current year of study: ");
        int currentYear = sc.nextInt();
        sc.nextLine();
        studentsList.add(new Student(name, college, currentYear));
        clientsList.add(new Client(name, studentsList.get(findStudent(name)).getUniqueId(), "Student"));
        System.out.println(name + " succesfully added!");
    }

    public void addTeacher() {
        System.out.println("Name: ");
        sc.nextLine();
        String name = sc.nextLine();
        if (teacherNameAlreadyExists(name)) {
            System.out.println("Name already in use.");
            return;
        }
        System.out.println("Subject: ");
        String subject = sc.next();
        teachersList.add(new Teacher(name, subject));
        clientsList.add(new Client(name, teachersList.get(findTeacher(name)).getUniqueId(), "Teacher"));
        System.out.println(name + " succesfully added!\n");
    }

    public void addBook() {
        System.out.println("Title: ");
        String title = sc.nextLine();
        System.out.println("Author: ");
        String author = sc.nextLine();
        System.out.println("Genre: ");
        String genre = sc.nextLine();
        System.out.println("Number of pages: ");
        int pages = sc.nextInt();
        sc.nextLine();
        booksList.add(new Book(title, author, genre, pages, true));
        System.out.println(title + " succesfully added!\n");
    }

    public int findStudent(String name) {
        for (int i = 0; i < studentsList.size(); i++) {
            if (name.equals(studentsList.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public int findTeacher(String name) {
        for (int i = 0; i < teachersList.size(); i++) {
            if (name.equals(teachersList.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public int findBook(String title){
        for (int i = 0; i < booksList.size(); i++){
            if (title.equals(booksList.get(i).getTitle())){
                return i;
            }
        }
        return -1;
    }

    public int findClient(String name){
        for (int i = 0; i < clientsList.size(); i++){
            if (name.equals(clientsList.get(i).getName())){
                return i;
            }
        }
        return -1;
    }

    public boolean teacherNameAlreadyExists(String name) {
        for (int i = 0; i < teachersList.size(); i++) {
            if (name.equals(teachersList.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean studentNameAlreadyExists(String name) {
        for (int i = 0; i < studentsList.size(); i++) {
            if (name.equals(studentsList.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean bookTitleExists(String title){
        for (int i = 0; i < booksList.size(); i++){
            if (title.equals(booksList.get(i).getTitle())){
                return true;
            }
        }
        return false;
    }

    public void showClients() {
        if (clientsList.size() == 0){
            System.out.println("No clients to show");
        }
        for (int i = 0; i < clientsList.size(); i++) {
            System.out.println("Name: " + clientsList.get(i).getName() + " || Type: " + clientsList.get(i).getType() +
                    " || ID code: " + clientsList.get(i).getUniqueId());
        }
    }

    public void showStudents() {
        if (studentsList.size() == 0){
            System.out.println("No students to show");
        }
        for (int i = 0; i < studentsList.size(); i++) {
            System.out.println("Name: " + studentsList.get(i).getName() + " || College: " + studentsList.get(i).getCollege() +
                    " || Current year of study: " + studentsList.get(i).getCurrentYear() +
                    " || ID code: " + studentsList.get(i).getUniqueId());
        }
    }

    public void showTeachers() {
        for (int i = 0; i < teachersList.size(); i++) {
            System.out.println("Name: " + teachersList.get(i).getName() + " || Subject: "
                    + teachersList.get(i).getSubject() + " || ID code: " + teachersList.get(i).getUniqueId());
        }
    }

    public void showBooks() {
        for (int i = 0; i < booksList.size(); i++) {
            System.out.println("Title: " + booksList.get(i).getTitle() + " || Author: " + booksList.get(i).getAuthor() +
                    " || Genre: " + booksList.get(i).getGenre() + " || Number of pages: " + booksList.get(i).getPages() +
                    " || ID code: " + booksList.get(i).getUniqueId());
        }
    }

    public void showAvailableBooks() {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).isAvailable()) {
                System.out.println("Title: " + booksList.get(i).getTitle() + " || Author: " + booksList.get(i).getAuthor() +
                        " || Genre: " + booksList.get(i).getGenre() + " || Number of pages: " + booksList.get(i).getPages() +
                        " || ID code: " + booksList.get(i).getUniqueId());
            }
        }
    }

    public void booksInLibrary(){
        System.out.println("\n" + booksList.size() + " books available in library" + "\n");
    }

    public void searchBook() {
        System.out.println("Enter the title: ");
        String title = sc.nextLine();

        for (int i = 0; i < booksList.size(); i++) {
            if (title.equals(booksList.get(i).getTitle())) {
                System.out.println("Title: " + booksList.get(i).getTitle() + " || Author: " + booksList.get(i).getAuthor() +
                        " || Genre: " + booksList.get(i).getGenre() + " || Number of pages: " + booksList.get(i).getPages() +
                        " || ID code: " + booksList.get(i).getUniqueId());
                return;
            }
        }
            System.out.println("Book " + title + " not found.");
    }

    public void sortByGenre() {
        System.out.println("Enter the genre: ");
        String genre = sc.nextLine();
        for (int i = 0; i < booksList.size(); i++) {
            if (genre.equals(booksList.get(i).getGenre())) {
                System.out.println("Title: " + booksList.get(i).getTitle() + " || Author: " + booksList.get(i).getAuthor() +
                        " || Genre: " + booksList.get(i).getGenre() + " || Number of pages: " + booksList.get(i).getPages() +
                        " || ID code: " + booksList.get(i).getUniqueId());
            }
        }
    }

    public void sortByPages() {
        int[] pagesArray = new int[booksList.size()];
        ArrayList<Book> bookListByPages = new ArrayList<>();

        for (int i = 0; i < booksList.size(); i++) {
            pagesArray[i] = booksList.get(i).getPages();
        }

        Arrays.sort(pagesArray);

        for (int i = 0; i < booksList.size(); i++) {
            for (int j = 0; j < booksList.size(); j++) {
                if (booksList.get(j).getPages() == pagesArray[i]) {
                    bookListByPages.add(booksList.get(j));
                }
            }
        }

        for (int i = 0; i < bookListByPages.size(); i++) {
            System.out.println("Title: " + bookListByPages.get(i).getTitle() + " || Author: "
                    + bookListByPages.get(i).getAuthor() + " || Genre: " + bookListByPages.get(i).getGenre() +
                    " || Number of pages: " + bookListByPages.get(i).getPages() +
                    " || ID code: " + bookListByPages.get(i).getUniqueId());
        }
    }

    public void sortClientsAlph() {

        List<String> clientsNameAlph = new ArrayList<>();
        ArrayList<Client> clientsListAlph = new ArrayList<>();

        for (int i = 0; i < clientsList.size(); i++) {
            clientsNameAlph.add(clientsList.get(i).getName());
        }

        Collections.sort(clientsNameAlph);

        for (int i = 0; i < clientsList.size(); i++) {
            for (int j = 0; j < clientsList.size(); j++) {
                if (clientsNameAlph.get(i).equals(clientsList.get(j).getName())) {
                    clientsListAlph.add(clientsList.get(j));
                }
            }
        }

        for (int i = 0; i < clientsList.size(); i++) {
            System.out.println("Name: " + clientsListAlph.get(i).getName() + " || Type: " + clientsListAlph.get(i).getType() +
                    " || ID code: " + clientsListAlph.get(i).getUniqueId());
        }
    }

    public void greatestReader(){

        int[] booksBorrowedList = new int[clientsList.size()];
        ArrayList<Client> clientsSortByBooksReaded = new ArrayList<>();

        for (int i = 0; i < clientsList.size(); i++){
          booksBorrowedList[i] = clientsList.get(i).getBooksBorrowed();
        }

        Arrays.sort(booksBorrowedList);

        for (int i = 0; i < clientsList.size(); i++){
            for (int j = 0; j < clientsList.size(); j++){
                if (booksBorrowedList[i] == clientsList.get(j).getBooksBorrowed()){
                    clientsSortByBooksReaded.add(clientsList.get(j));
                }
            }
        }

        System.out.println("The greatest reader is --> Name: " +
                clientsSortByBooksReaded.get(clientsList.size() - 1).getName() + " || ID code: " +
                clientsSortByBooksReaded.get(clientsList.size() - 1).getUniqueId() + " || Type: " +
                clientsSortByBooksReaded.get(clientsList.size() - 1).getType() + " || Books borrowed: " +
                clientsSortByBooksReaded.get(clientsList.size() - 1).getBooksBorrowed());
    }

    public void borrowBook(){
        System.out.println("Client name: ");
        String name = sc.nextLine();
        System.out.println("Book title: ");
        String title = sc.nextLine();
        if (!clientsList.get(findClient(name)).isHavingABook()){
            if (findBook(title) >= 0 && booksList.get(findBook(title)).isAvailable()){
                clientsList.get(findClient(name)).setHaveABook(true);
                clientsList.get(findClient(name)).setBooksBorrowed();
                booksList.get(findBook(title)).setAvailable(false);
                System.out.println("Date to return (dd/MM/yyyy): ");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dateToReturn = sc.next();
                LocalDate localDate = LocalDate.parse(dateToReturn, formatter);
                clientsList.get(findClient(name)).setDateReturn(localDate);

                System.out.println("Process succesed!\n");

            }else{
                System.out.println("Book not found.");
            }
        }else{
            System.out.println(clientsList.get(findClient(name)).getName() + " have already borrowed a book");
            //optional
            // details about the book
        }
    }

    public void returnBook(){
        System.out.println("Client name: ");
        String name = sc.nextLine();
        if (studentNameAlreadyExists(name)) {
            System.out.println("Book title: ");
            String title = sc.nextLine();
            if (bookTitleExists(title)) {
                booksList.get(findBook(title)).setAvailable(true);
                clientsList.get(findClient(name)).setHaveABook(false);
                if (havePenalties(name)) {
                    System.out.println("10$ from penalties.");
                }
                clientsList.get(findClient(name)).setDateReturn(null);
                booksList.get(findBook(title)).incrementHolders();
                bookHolders.add(clientsList.get(findClient(name)));
                System.out.println("Succes!");
                return;
            }
        }
        System.out.println("Not processed!");
    }

    public boolean havePenalties(String name){
        LocalDate date = LocalDate.now();
        return date.isAfter(clientsList.get(findClient(name)).getDateReturn());
    }

    public void bookHistory(){
        System.out.println("Book's title: ");
        String title = sc.nextLine();
        if (bookHolders.size() == 0){
            System.out.println("No holders to show");
            return;
        }
        System.out.println("Book holders: " + booksList.get(findBook(title)).getBookHolders());
        for (int i = 0; i < bookHolders.size(); i++){
            System.out.println((i+1) + ". " + bookHolders.get(i).getName() + " || ID code: " + bookHolders.get(i).getUniqueId());
        }
    }

    public void checkPenalties(){

        LocalDate date = LocalDate.now();

        System.out.println("Client's name:");
        String name = sc.nextLine();
        if (!clientsList.get(findClient(name)).isHavingABook()){
            System.out.println("No book in " + name + "'s possesion.");
        }else if(date.isAfter(clientsList.get(findClient(name)).getDateReturn())){
            System.out.println("Penalties applied: 10$ \n" + "Date to return was " + clientsList.get(findClient(name)).getDateReturn() );
        }else{
            System.out.println("No penalties!\n" + "Date to return is " + clientsList.get(findClient(name)).getDateReturn() );
        }

    }

    public void removeBook(){
        System.out.println("Book's title: ");
        String title = sc.nextLine();
        if (bookTitleExists(title)) {
            booksList.get(findBook(title)).setBookHolders(0);
            booksList.get(findBook(title)).setAvailable(false);
            booksList.remove(findBook(title));
            System.out.println("Book removed from Library");
        }
    }

    public void removeClient(){
        System.out.println("Client's name: ");
        String name = sc.nextLine();
        if (clientsList.get(findClient(name)).getType().equals("Student")){
            studentsList.remove(findStudent(name));
        }else{
            teachersList.remove(findTeacher(name));
        }
        clientsList.remove(findClient(name));
        System.out.println(name + " is no longer a client.");
    }

    public void exit(){
        System.out.println("Have a nice day!");
    }


}

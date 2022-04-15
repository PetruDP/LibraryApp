import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Library {

    private Scanner sc = new Scanner(System.in);
    private String libraryName;

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
        String name = getNameException();
        System.out.println("College:");
        String inputCollege = sc.nextLine();
        Colleges college = Colleges.valueOf(inputCollege);
        System.out.println("Current year of study: ");
        int currentYear = getIntException();
        sc.nextLine();
        clientsList.add(new Client(name, college, currentYear));
        System.out.println(name + " succesfully added!");
    }

    public void addTeacher() {
        System.out.println("Name: ");
        sc.nextLine();
        String name = getNameException();
        System.out.println("Subject: ");
        // here is name exception
        String subject = getNameException();
        clientsList.add(new Client(name, subject));
        System.out.println(name + " succesfully added!\n");
    }

    public void addBook() {
        System.out.println("Title: ");
        String title = sc.nextLine();
        //exception
        System.out.println("Author: ");
        String author = sc.nextLine();
        //exception
        System.out.println("Genre: ");
        String strGenre = sc.nextLine();
        //exception
        Genre genre = Genre.valueOf(strGenre);
        System.out.println("Number of pages: ");
        int pages = getIntException();
        sc.nextLine();
        //exception
        booksList.add(new Book(title, author, genre, pages, true));
        System.out.println(title + " succesfully added!\n");
    }

    public int findStudent(String name) {
        for (int i = 0; i < clientsList.size(); i++) {
            if (name.equals(clientsList.get(i).getName()) && clientsList.get(i).getType().equals("Student")) {
                return i;
            }
        }
        return -1;
    }

    public int findTeacher(String name) {
        for (int i = 0; i < clientsList.size(); i++) {
            if (name.equals(clientsList.get(i).getName()) && clientsList.get(i).getType().equals("Teacher")) {
                return i;
            }
        }
        return -1;
    }

    public int findBook(String title) {
        for (int i = 0; i < booksList.size(); i++) {
            if (title.equals(booksList.get(i).getTitle())) {
                return i;
            }
        }
        return -1;
    }

    // ???????????
    public int findClient(String name) {
        for (int i = 0; i < clientsList.size(); i++) {
            if (name.equals(clientsList.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean teacherNameAlreadyExists(String name) {
        for (int i = 0; i < clientsList.size(); i++) {
            if (name.equals(clientsList.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean studentNameAlreadyExists(String name) {
        for (int i = 0; i < clientsList.size(); i++) {
            if (name.equals(clientsList.get(i).getName())) {
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
        if (clientsList.size() == 0) {
            System.out.println("No clients to show");
        }
        for (int i = 0; i < clientsList.size(); i++) {
            System.out.println("Name: " + clientsList.get(i).getName() + " || Type: " + clientsList.get(i).getType() +
                    " || ID code: " + clientsList.get(i).getUniqueId());
        }
    }

    public void showStudents() {
        if (clientsList.size() == 0) {
            System.out.println("No students to show");
        }
        for (int i = 0; i < clientsList.size(); i++) {
            if (clientsList.get(i).getType().equals("Student")) {
                System.out.println("Name: " + clientsList.get(i).getName() + " || College: " + clientsList.get(i).getCollege() +
                        " || Current year of study: " + clientsList.get(i).getCurrentYear() +
                        " || ID code: " + clientsList.get(i).getUniqueId());
            }
        }
    }

    // never used
//    public void showTeachers() {
//        for (int i = 0; i < clientsList.size(); i++) {
//            if (clientsList.get(i).getType().equals("Teacher")) {
//                System.out.println("Name: " + clientsList.get(i).getName() + " || Subject: "
//                        + clientsList.get(i).getSubject() + " || ID code: " + clientsList.get(i).getUniqueId());
//            }
//        }
//    }

    public void showBooks() {
        for (int i = 0; i < booksList.size(); i++) {
            System.out.println("Title: " + booksList.get(i).getTitle() + " || Author: " + booksList.get(i).getAuthor() +
                    " || Genre: " + booksList.get(i).getGenre() + " || Number of pages: " + booksList.get(i).getPages() +
                    " || ID code: " + booksList.get(i).getUniqueId());
        }
    }

    public void showAvailableBooks() {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getAvailable()) {
                System.out.println("Title: " + booksList.get(i).getTitle() + " || Author: " + booksList.get(i).getAuthor() +
                        " || Genre: " + booksList.get(i).getGenre() + " || Number of pages: " + booksList.get(i).getPages() +
                        " || ID code: " + booksList.get(i).getUniqueId());
            }
        }
    }

    public void booksInLibrary() {
        System.out.println("\n" + booksList.size() + " books available in library" + "\n");
    }

    public void searchBook() {
        System.out.println("Enter the title: ");
        String title = sc.nextLine();
        //exception

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
        String strGenre = sc.nextLine();
        //exception
        Genre genre = Genre.valueOf(strGenre);
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

    public void greatestReader() {

        int[] booksBorrowedList = new int[clientsList.size()];
        ArrayList<Client> clientsSortByBooksReaded = new ArrayList<>();

        for (int i = 0; i < clientsList.size(); i++) {
            booksBorrowedList[i] = clientsList.get(i).getBooksBorrowed();
        }

        Arrays.sort(booksBorrowedList);

        for (int i = 0; i < clientsList.size(); i++) {
            for (int j = 0; j < clientsList.size(); j++) {
                if (booksBorrowedList[i] == clientsList.get(j).getBooksBorrowed()) {
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

    public void borrowBook() {
        System.out.println("Client name: ");
        String name = sc.nextLine();
        //exception
        System.out.println("Book title: ");
        String title = sc.nextLine();
        //excerption
        if (!clientsList.get(findClient(name)).getHaveABook()) {
            if (findBook(title) >= 0 && booksList.get(findBook(title)).getAvailable()) {
                clientsList.get(findClient(name)).setHaveABook(true);
                clientsList.get(findClient(name)).setBooksBorrowed();
                booksList.get(findBook(title)).setAvailable(false);
                clientsList.get(findClient(name)).setDateReturn(true);

                System.out.println("Process succesed!\n");

            } else {
                System.out.println("Book not found.");
            }
        } else {
            System.out.println(clientsList.get(findClient(name)).getName() + " have already borrowed a book");
        }
    }

    public void returnBook() {
        System.out.println("Client name: ");
        String name = sc.nextLine();
        //exception
        if (studentNameAlreadyExists(name)) {
            System.out.println("Book title: ");
            String title = sc.nextLine();
            //exception
            if (bookTitleExists(title)) {
                booksList.get(findBook(title)).setAvailable(true);
                clientsList.get(findClient(name)).setHaveABook(false);
                if (havePenalties(name)) {
                    System.out.println("10$ from penalties.");
                }
                clientsList.get(findClient(name)).setDateReturn(false);
                booksList.get(findBook(title)).incrementHolders();
                bookHolders.add(clientsList.get(findClient(name)));
                System.out.println("Succes!");
                return;
            }
        }
        System.out.println("Not processed!");
    }

    public boolean havePenalties(String name) {
        Date currentDate = new Date();
        return currentDate.after(clientsList.get(findClient(name)).getDateReturn());
    }

    public void bookHistory() {
        System.out.println("Book's title: ");
        String title = sc.nextLine();
        if (bookHolders.size() == 0) {
            System.out.println("No holders to show");
            return;
        }
        System.out.println("Book holders: " + booksList.get(findBook(title)).getBookHolders());
        for (int i = 0; i < bookHolders.size(); i++) {
            System.out.println((i + 1) + ". " + bookHolders.get(i).getName() + " || ID code: " + bookHolders.get(i).getUniqueId());
        }
    }

    public void checkPenalties() {

        Date currentDate = new Date();

        System.out.println("Client's name:");
        String name = sc.nextLine();
        //exception
        if (!clientsList.get(findClient(name)).getHaveABook()) {
            System.out.println("No book in " + name + "'s possesion.");
        } else if (currentDate.after(clientsList.get(findClient(name)).getDateReturn())) {
            System.out.println("Penalties applied: 10$ \n" + "Date to return was " + clientsList.get(findClient(name)).getDateReturn());
        } else {
            System.out.println("No penalties!\n" + "Date to return is " + clientsList.get(findClient(name)).getDateReturn());
        }

    }

    public void removeBook() {
        System.out.println("Book's title: ");
        String title = sc.nextLine();
        //exception
        if (bookTitleExists(title)) {
            booksList.get(findBook(title)).setBookHolders(0);
            booksList.get(findBook(title)).setAvailable(false);
            booksList.remove(findBook(title));
            System.out.println("Book removed from Library");
        }
    }

    public void removeClient() {
        System.out.println("Client's name: ");
        String name = sc.nextLine();
        //exception
        if (clientsList.get(findClient(name)).getType().equals("Student")) {
            clientsList.remove(findStudent(name));
        } else {
            clientsList.remove(findTeacher(name));
        }
        clientsList.remove(findClient(name));
        System.out.println(name + " is no longer a client.");
    }

    public void exit() {
        System.out.println("Have a nice day!");
    }

    public int getIntException() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Try to use only digits from 0 to 9.");
            } catch (NoSuchElementException e) {
                sc.nextLine();
                System.out.println("Try to use only digits from 0 to 9.");
            }
        }
    }

    public String getNameException(){
        while (true) {
            try {
                return sc.nextLine();
            } catch (NoSuchElementException e) {
                sc.nextLine();
                System.out.println("Invalid name");
            }
        }
    }
}

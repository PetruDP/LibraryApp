import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Main {

    public static Library library = new Library("Central Library");

    public static void main(String[] args) {

        System.out.println("Welcome to " + library.getLibraryName() + " application");

        Scanner sc = new Scanner(System.in);
        boolean quit = false;

        while(!quit) {
            showAvailableBooksAt50();
            mainMenu();
            System.out.println("Choose option: ");
            int option = library.getIntException();
            sc.nextLine();
           if (option < 1 || option > 18){
               System.out.println("Invalid option!");
           }else{
               switch (option) {
                   case 1 -> {
                       boolean quitClientM = false;
                       while (!quitClientM) {
                           clientsMenu();
                           System.out.println("Choose option: ");
                           int optionClientM = library.getIntException();
                           sc.nextLine();


                           switch (optionClientM) {
                               case 1 -> library.addStudent();
                               case 2 -> library.addTeacher();
                               case 3 -> library.showClients();
                               case 4 -> library.showStudents();
                               case 5 -> library.sortClientsAlph();
                               case 6 -> library.greatestReader();
                               case 7 -> library.removeClient();
                               case 8 -> library.checkPenalties();
                               case 9 -> quitClientM = true;
                           }
                       }
                   }
                   case 2 -> {
                       boolean quitBooksM = false;
                       while (!quitBooksM) {
                           booksMenu();
                           System.out.println("Choose option: ");
                           int optionBooksM = library.getIntException();
                           sc.nextLine();

                           switch (optionBooksM) {
                               case 1 -> library.addBook();
                               case 2 -> library.showBooks();
                               case 3 -> library.showAvailableBooks();
                               case 4 -> library.searchBook();
                               case 5 -> library.sortByGenre();
                               case 6 -> library.sortByPages();
                               case 7 -> library.borrowBook();
                               case 8 -> library.returnBook();
                               case 9 -> library.removeBook();
                               case 10 -> library.bookHistory();
                               case 11 -> quitBooksM = true;
                           }
                       }
                   }
                   case 3 -> {
                       library.exit();
                       quit = true;
                   }
               }
           }
        }
    }

    public static void mainMenu(){
        System.out.println();
        System.out.println("""
                1. Clients menu.
                2. Books menu.
                3. Exit.""");
        System.out.println();
    }

    public static void clientsMenu(){
        System.out.println();
        System.out.println("""
                1. Add student.
                2. Add teacher.
                3. Show clients.
                4. Show students.
                5. Sort clients alphabetically.
                6. The greatest reader!
                7. Remove client from library.
                8. Check penalties.
                9. Back to Main Menu.""");
        System.out.println();
    }

    public static void booksMenu(){
        System.out.println();
        System.out.println("""
                1. Add book.
                2. Show books.
                3. Available books.
                4. Search book.
                5. Sort books by genre.
                6. Sort books by number of pages.
                7. Borrow a book.
                8. Return a book.
                9. Remove book from library.
                10. Book history.
                11. Back to Main Menu.""");
        System.out.println();
    }


        public static void showAvailableBooksAt50() {

             ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

             Runnable runnable = new Runnable() {
                int countdownStarter = 50;

                public void run() {
                    countdownStarter--;
                    if (countdownStarter == 0) {
                        library.booksInLibrary();
                        countdownStarter = 50;
                    }
                }
            };
            scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
        }
    }


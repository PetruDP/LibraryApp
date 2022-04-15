import java.util.UUID;

public class Book {

    private String title;
    private String author;
    private Genre genre;
    private int pages;
    private boolean available;
    private String uniqueId ;
    private int bookHolders;

    public Book(String title, String author, Genre genre, int pages, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.available = true;
        this.uniqueId = UUID.randomUUID().toString();
        this.bookHolders = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }

    public boolean getAvailable() {
        return available;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public int getBookHolders() {
        return bookHolders;
    }
// never used
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setGenre(Genre genre) {
//        this.genre = genre;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public void setPages(int pages) {
//        this.pages = pages;
//    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setBookHolders(int bookHolders) {
        this.bookHolders = bookHolders;
    }


    public void incrementHolders(){
        this.bookHolders++;

    }
}



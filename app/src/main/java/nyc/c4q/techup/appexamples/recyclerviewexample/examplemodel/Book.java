package nyc.c4q.techup.appexamples.recyclerviewexample.examplemodel;

/**
 * Created by amirahoxendine on 12/6/17.
 */

public class Book {
    private String bookTitle;
    private String bookAuthor;
    private String publishingYear;
    private int bookCover;
    private String description;



    public Book(int bookCover, String title, String author, String publishingYear) {
        this.bookCover = bookCover;
        this.bookTitle = title;
        this.bookAuthor = author;
        this.publishingYear = publishingYear;
        this.description = description;

    }

    public int getBookCover() {
        return bookCover;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getPublishingYear() {
        return publishingYear;
    }
    public String getDescription() {
        return description;
    }
}
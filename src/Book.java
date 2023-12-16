

public class Book {
    int BookId;
    String Title;
    String Author;
    String Genre;
    public int getBookId() {
        return BookId;
    }
    public void setBookId(int bookId) {
        BookId = bookId;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }
    public String getGenre() {
        return Genre;
    }
    public void setGenre(String genre) {
        Genre = genre;
    }

    public Book(String B){
        String values[] = B.split(",");
        this.BookId = Integer.parseInt(values[0]);
        this.Title = values[1];
        this.Author = values[2];
        this.Genre = values[3];
    }
    public Book(int bookId, String title, String author, String genre) {
        BookId = bookId;
        Title = title;
        Author = author;
        Genre = genre;
    }
    @Override
    public String toString() {
        
        return "[" +"BookId:"+BookId+" Title:"+Title+" Author:"+Author+ " Genre:"+Genre+"]"; 
    }
    
}


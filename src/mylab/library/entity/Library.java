package mylab.library.entity;


import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    List<Book> books;

    public Library(String name){
        this.name=name;
        this.books=new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void addBook(Book book){
        books.add(book);
    }
    public Book findBookByTitle(String title){
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)){
                return book;
            }

        }return null;
    }
    public List<Book> findBooksByAuthor(String author){
        List<Book> res= new ArrayList<>();
        for (Book book : books) {
            if(book.getAuthor().equalsIgnoreCase(author)){
                res.add(book);
            }

        }
        return res;


    }
    public Book findBookByISBN(String isbn){
        for (Book book : books) {
            if(book.getIsbn().equalsIgnoreCase(isbn)){
                return book;
            }

        }
        return null;
    }

    public boolean checkOutBook(String isbn){
        Book book=findBookByISBN(isbn);
        if (book==null || !book.isAvailable()){
            return false;
        }
        book.checkOut();
        return true;
    }
    public boolean returnBook(String isbn){
        Book book=findBookByISBN(isbn);
        if (book==null || book.isAvailable()){
            return false;
        }
        book.returnBook();
        return true;
    }


    public List<Book> getAvailableBooks(){
        List<Book> res=new ArrayList<>();
        for (Book book : books) {
            if(book.isAvailable()){
                res.add(book);
            }

        }return res;
    }
    public List<Book> getAllBooks(){
        return new ArrayList<>(books);
    }
    public int getTotalBooks(){
        return getAllBooks().size();
    }
    public int getAvailableBooksCount(){
        return getAvailableBooks().size();
    }
    public int getBorrowedBooksCount(){
        return getTotalBooks()-getAvailableBooksCount();
    }



}
public class RentedBook extends Book {
    String DateOfReturn;
    int Rent;
    public RentedBook(String B) {
        super(B);
        String values[]=B.split(",");
        this.DateOfReturn = values[4];
        this.Rent = Integer.parseInt(values[5]);
    }
    public String getDateOfReturn() {
        return DateOfReturn;
    }
    public void setDateOfReturn(String dateOfReturn) {
        DateOfReturn = dateOfReturn;
    }
    public int getRent() {
        return Rent;
    }
    public void setRent(int rent) {
        Rent = rent;
    }
    public RentedBook(int bookId, String title, String author, String genre, String dateOfReturn, int rent) {
        super(bookId, title, author, genre);
        DateOfReturn = dateOfReturn;
        Rent = rent;
    }
    @Override
    public String toString() {
        
        return "[" +"BookId:"+BookId+" Title:"+Title+" Author:"+Author+ " Genre:"+Genre+" DateOfReturn:"+DateOfReturn+" Rent:"+Rent+"]";
    }
    

    
    
}

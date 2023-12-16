public class App {
    public static void CreateBooks(String[] InputLine){
        Reader.ReadBookFile(InputLine[1]);
    }
    public static void AllBooks(String[] InputLine){
        BookDAO.readBooks();
    }
    public static void UpdateBooks(String[] InputLine){
        Reader.ReadBookFileUpdate(InputLine[1]);
    }
    public static void DeleteBook(String[] InputLine){
       BookDAO.deleteBook(Integer.parseInt(InputLine[1])); 
    }
    public static void SearchBooksByBookId(String[] InputLine){
        
        for(int i=1;i<InputLine.length;i++){
            BookDAO.readBooks(Integer.parseInt(InputLine[i]));
        }
    }
    public static void SearchBooksByGenre(String[] InputLine){
       
        BookDAO.readBooksG(InputLine[1]);
    }
    public static void SearchBooksByTitle(String[] InputLine){
       
        BookDAO.readBooksT(InputLine[1]);
    }
    public static void SearchBooksByAuthor(String[] InputLine){
        BookDAO.readBooksA(InputLine[1]);
    }
    public static void CreateRentedBooks(String[] InputLine){
        Reader.ReadRentedBookFile(InputLine[1]);
    }
    public static void AllRentedBooks(String[] Inputline){
        RentedBookDAO.readRentedBooks();
    }
    public static void DeleteRentedBook(String[] InputLine){
        RentedBookDAO.deleteRentedBook(Integer.parseInt(InputLine[1]));
    }
    public static void SearchRentedBooksByBookId(String[] InputLine){
        RentedBookDAO.readRentedBooks(Integer.parseInt(InputLine[1]));
    }
    public static void SearchRentedBooksByTitle(String[] InputLine){
        
        RentedBookDAO.readRentedBooksT(InputLine[1]);
    }
    public static void printHelp(){
        System.out.println("Help for commands:");
        System.out.println("-a <filepath> //for CreatingBooks ");
        System.out.println("-b  //for Reading All Books");
        System.out.println("-c <filepath> //for UpdatingBooks");
        System.out.println("-d BookId  //for DeletingBook(one at a Time)");
        System.out.println("-e BookId/BookIds   //for SearchingBooks with BookId , can enter multiple BookIds with spaces");
        System.out.println("-f genre  //for searching on the basis of Genre ");
        System.out.println("-g Title //for searching by Title");
        System.out.println("-au Author //for searching by Author");
        System.out.println("-i <filepath> //for CreatingRentedBooks ");
        System.out.println("-j //for reading All RentedBooks");
        System.out.println("-k BookId(For RentedBooks) //For Deleting RentedBook (one at a time)");
        System.out.println("-l BookId(For RentedBooks) //For searching by BookId");
        System.out.println("-m Title(for RentedBooks) //For Searching by Title");
        System.out.println("-h (or any) for help menu");
    }
    public static void main(String[] args) throws Exception {
        switch (args[0]) {
            case "-a":
                CreateBooks(args);
                break;
            case "-b":
                AllBooks(args);
                break;
            case"-c":
                UpdateBooks(args);
                break;
            case"-d":
                DeleteBook(args);
                break;
            case"-e":
                SearchBooksByBookId(args);
                break;
            case"-f":
                SearchBooksByGenre(args);
                break;
            case"-g":
                SearchBooksByTitle(args);
                break;
            case"-i":
                CreateRentedBooks(args);
                break;
            case"-j":
                AllRentedBooks(args);
                break;
            case"-k":
                DeleteRentedBook(args);
                break;
            case"-l":
                SearchRentedBooksByBookId(args);
                break;
            case"-m":
                SearchRentedBooksByTitle(args);
                break;
            case"-au":
                SearchBooksByAuthor(args);
                break; 
            default:

                printHelp();
                break;
        }
    }
}

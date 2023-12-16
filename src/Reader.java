import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static void ReadBookFile(String filename){
        try {
            FileReader file = new FileReader(filename);
            BufferedReader Read = new BufferedReader(file);
            String BookLine;
            try {
                
                while((BookLine = Read.readLine())!=null){
                    BookDAO.createBook(new Book(BookLine));
                }
            
            } catch (IOException e) {
                
                e.printStackTrace();
            }
            Read.close();

        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
    }
    public static void ReadBookFileUpdate(String filename){
        try {
            FileReader file = new FileReader(filename);
            BufferedReader Read = new BufferedReader(file);
            String BookLine;
            try {
                
                while((BookLine = Read.readLine())!=null){
                    BookDAO.UpdateBook(new Book(BookLine));
                }
            
            } catch (IOException e) {
                
                e.printStackTrace();
            }
            Read.close();

        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
    }
    public static void ReadRentedBookFile(String filename){
        try {
            FileReader file = new FileReader(filename);
            BufferedReader Read = new BufferedReader(file);
            String RentedBookLine;
            try {
                
                while((RentedBookLine = Read.readLine())!=null){
                    RentedBookDAO.createRentedBook(new RentedBook(RentedBookLine));
                }
            
            } catch (IOException e) {
                
                e.printStackTrace();
            }
            Read.close();

        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }    
}

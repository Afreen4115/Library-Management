
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RentedBookDAO {
    public static void createRentedBook(RentedBook Rbook){
        Connection connection = ConnectionJDBC.getConnection();
        final String query = "insert into Rentedbooks(BookId,Title,Author,Genre,DateOfReturn,Rent) values(?,?,?,?,?,?)";
        try(PreparedStatement st = connection.prepareStatement(query)){
           st.setInt(1, Rbook.getBookId());
           st.setString(2, Rbook.getTitle());
           st.setString(3, Rbook.getAuthor());
           st.setString(4, Rbook.getGenre());
           st.setString(5, Rbook.getDateOfReturn());
           st.setInt(6,Rbook.getRent());

            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected+" RentedBooks rows created.");
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void readRentedBooks(){
        Connection connection = ConnectionJDBC.getConnection();
        final String query = "select* from rentedbooks";
        try(java.sql.Statement st = connection.createStatement()){
            
            ResultSet rs = ( (java.sql.Statement) st).executeQuery(query);
        while(rs.next()){
           
           
            int BookId = rs.getInt("BookId");
            String Title = rs.getString("Title");
            String Author = rs.getString("Author");
            String Genre = rs.getString("Genre");
            String DateOfReturn = rs.getString("DateOfReturn");
            int Rent = rs.getInt("Rent");
            System.out.println("[" +"BookId:"+BookId+" Title:"+Title+" Author:"+Author+ " Genre:"+Genre+" DateOfReturn:"+DateOfReturn+" Rent:"+Rent+"]"); 
           
        }
        connection.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

    }
    public static void deleteRentedBook(int id){
        Connection connection = ConnectionJDBC.getConnection();
        final String query = "DELETE FROM RentedBooks WHERE BookId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected+" RentedBooks rows deleted.");
            connection.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
    }
    public static void readRentedBooks(int id){
        Connection connection = ConnectionJDBC.getConnection();
        final String query = "select* from RentedBooks where BookId=?";
        try(PreparedStatement st = connection.prepareStatement(query);){
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
        while(rs.next()){
           
            int BookId = rs.getInt("BookId");
            String Title = rs.getString("Title");
            String Author = rs.getString("Author");
            String Genre = rs.getString("Genre");
            String DateOfReturn = rs.getString("DateOfReturn");
            int Rent = rs.getInt("Rent");
            System.out.println("[" +"BookId:"+BookId+" Title:"+Title+" Author:"+Author+ " Genre:"+Genre+" DateOfReturn:"+DateOfReturn+" Rent:"+Rent+"]"); 
           
             
           
        }
        connection.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

    }
    public static void readRentedBooksT(String title){
        Connection connection = ConnectionJDBC.getConnection();
        ;
        final String query = "select* from RentedBooks where Title=?";
        try(PreparedStatement st = connection.prepareStatement(query);){
            st.setString(1,title);
            ResultSet rs = st.executeQuery();
            
        while(rs.next()){
           
            int BookId = rs.getInt("BookId");
            String Title = rs.getString("Title");
            String Author = rs.getString("Author");
            String Genre = rs.getString("Genre");
            String DateOfReturn = rs.getString("DateOfReturn");
            int Rent = rs.getInt("Rent");
            System.out.println("[" +"BookId:"+BookId+" Title:"+Title+" Author:"+Author+ " Genre:"+Genre+" DateOfReturn:"+DateOfReturn+" Rent:"+Rent+"]"); 
           
            
           
        }
        connection.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
    }
}
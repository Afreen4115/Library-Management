import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class BookDAO {
    public static void createBook(Book book){
        Connection connection = ConnectionJDBC.getConnection();
        final String query = "insert into books(BookId,Title,Author,Genre) values(?,?,?,?)";
        try(PreparedStatement st = connection.prepareStatement(query)){
           st.setInt(1, book.getBookId());
           st.setString(2, book.getTitle());
           st.setString(3, book.getAuthor());
           st.setString(4, book.getGenre());
            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected+" Books rows created.");
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void readBooks(){
        Connection connection = ConnectionJDBC.getConnection();
        final String query = "select* from books";
        try(java.sql.Statement st = connection.createStatement()){
            
            ResultSet rs = ( (java.sql.Statement) st).executeQuery(query);
        while(rs.next()){
           
           
            int BookId = rs.getInt("BookId");
            String Title = rs.getString("Title");
            String Author = rs.getString("Author");
            String Genre = rs.getString("Genre");
            System.out.println("[" +"BookId:"+BookId+" Title:"+Title+" Author:"+Author+ " Genre:"+Genre+"]"); 
           
        }
        connection.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

    }
    public static void UpdateBook(Book book){
        Connection connection = ConnectionJDBC.getConnection();
        final String query = "UPDATE Books SET Title = ?, Author= ? ,Genre= ? WHERE BookId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(4, book.getBookId());
           st.setString(1, book.getTitle());
           st.setString(2, book.getAuthor());
           st.setString(3, book.getGenre());
           int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected+" Books rows updated.");
            connection.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    public static void deleteBook(int id){
        Connection connection = ConnectionJDBC.getConnection();
        final String query = "DELETE FROM Books WHERE BookId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected+" Books rows deleted.");
            connection.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
    }
    public static void readBooks(int id){
        Connection connection = ConnectionJDBC.getConnection();
        final String query = "select* from Books where BookId=?";
        try(PreparedStatement st = connection.prepareStatement(query);){
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
        while(rs.next()){
           
           
            int BookId = rs.getInt("BookId");
            String Title = rs.getString("Title");
            String Author = rs.getString("Author");
            String Genre = rs.getString("Genre");
            System.out.println("[" +"BookId:"+BookId+" Title:"+Title+" Author:"+Author+ " Genre:"+Genre+"]"); 
           
        }
        connection.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

    }
    public static void readBooksG(String genre){
        Connection connection = ConnectionJDBC.getConnection();
        final String query = "select* from Books where Genre=?";
        try(PreparedStatement st = connection.prepareStatement(query);){
            st.setString(1, genre);
            ResultSet rs = st.executeQuery();
            
        while(rs.next()){
           
           
            int BookId = rs.getInt("BookId");
            String Title = rs.getString("Title");
            String Author = rs.getString("Author");
            String Genre = rs.getString("Genre");
            System.out.println("[" +"BookId:"+BookId+" Title:"+Title+" Author:"+Author+ " Genre:"+Genre+"]"); 
           
        }
        connection.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
    }
    public static void readBooksT(String title){
        Connection connection = ConnectionJDBC.getConnection();
        final String query = "select* from Books where Title=?";
        try(PreparedStatement st = connection.prepareStatement(query);){
            st.setString(1,title);
            ResultSet rs = st.executeQuery();
            
        while(rs.next()){
           
           
            int BookId = rs.getInt("BookId");
            String Title = rs.getString("Title");
            String Author = rs.getString("Author");
            String Genre = rs.getString("Genre");
            System.out.println("[" +"BookId:"+BookId+" Title:"+Title+" Author:"+Author+ " Genre:"+Genre+"]"); 
           
        }
        connection.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
    }
    public static void readBooksA(String author){
        Connection connection = ConnectionJDBC.getConnection();
        final String query = "select* from Books where Author=?";
        try(PreparedStatement st = connection.prepareStatement(query);){
            st.setString(1,author);
            ResultSet rs = st.executeQuery();
            
        while(rs.next()){
           
           
            int BookId = rs.getInt("BookId");
            String Title = rs.getString("Title");
            String Author = rs.getString("Author");
            String Genre = rs.getString("Genre");
            System.out.println("[" +"BookId:"+BookId+" Title:"+Title+" Author:"+Author+ " Genre:"+Genre+"]"); 
           
        }
        connection.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
    }    
        
    
}

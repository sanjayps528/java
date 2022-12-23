import java,io.*;
import java servlet.*;
import java.servlet.http.*;
import java.sql.*;
public class Member extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        response.setContentType("text/html");  //// Setting up the content type of web page
        PrintWriter out =response.getWriter();  // Writing the message on the web page
        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con =DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/lms","root","9986204054");
        Statement stmt=con.createStatement();    // create the statement object 
        ResultSet rs=stmt.executeQuery("select name,house_number,address_type,street,area,pincode from address,
        membership where address.membership_id= membership.membership_id;");  // execute query
        con.close()  
    }
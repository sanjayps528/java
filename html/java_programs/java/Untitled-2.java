import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Registration extends HttpServlet
{
    public void doGet (HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
        // Setting up the content type of web page
        response.setContentType ("text/html");
        
        // Writing the message on the web page
        PrintWriter out = response.getWriter ();

        String number= request.getParameter("num");
        String name= request.getParameter("name");
        int c_house_number = Integer.valueOf(request.getParameter("c_house_number")).intValue();
        String c_street = request.getParameter("c_street");
        String c_pincode = request.getParameter("c_pincode");
        String c_area = request.getParameter("c_area");
        int p_house_number = Integer.valueOf(request.getParameter("p_house_number")).intValue();
        String p_street = request.getParameter("p_street");
        String p_pincode = request.getParameter("p_pincode");
        String p_area = request.getParameter("p_area");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/lms","root","9986204054");

            ResultSet memRs = con.createStatement().executeQuery("select max(membership_id) as maxId from membership");
            int membership_id = 0;
            while(memRs.next()){
                membership_id = memRs.getInt("maxId");
            }
            membership_id++;
            memRs.close();

            PreparedStatement insMemStmt = con.prepareStatement("insert into membership values(?,?,?)");
            insMemStmt.setInt(1,membership_id);
            insMemStmt.setString(3,number);
            insMemStmt.setString(2,name);
            insMemStmt.execute();
            insMemStmt.close();

            PreparedStatement insAdd = con.prepareStatement("insert into address(membership_id,address_type,house_number,street,area,pincode)"
            +"VALUES(?,?,?,?,?,?)");
            insAdd.setInt (1,membership_id);
            insAdd.setString(2,"C");
            insAdd.setInt(3,c_house_number);
            insAdd.setString(4,c_street);
            insAdd.setString(5,c_area);
            insAdd.setString(6,c_pincode);
            insAdd.execute();
            
            insAdd.setInt (1,membership_id);
            insAdd.setString(2,"P");
            insAdd.setInt(3,p_house_number);
            insAdd.setString(4,p_street);
            insAdd.setString(5,p_area);
            insAdd.setString(6,p_pincode);
            insAdd.execute();
            insAdd.close();

            con.close();
            out.println("Member and Address Created");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
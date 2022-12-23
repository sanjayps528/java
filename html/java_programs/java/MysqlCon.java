import java.sql.*;
class MysqlCon{
    public static void main(String args[]){
        try{
            //step 1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            //step 2 create the connection object
            Connection con =DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/lms","root","9986204054");

            //step 3 create the statement object
            Statement stmt = con.createStatement();

            //step 4 execute query 
            String query="insert into address(membership_id,address_type,house_number,street,area,pincode)"
            +"VALUES(?,?,?,?,?,?)";
            PreparedStatement ppdStmnt = con.preparedStatement(query);
            ppdStmnt.setInt (1,membership_id);
            ppdStmnt.setString(2,address_type);
            ppdStmnt.setInt(3,c_house_number);
            ppdStmnt.setString(4,c_street);
            ppdStmnt.setString(5,c_area);
            ppdStmnt.setString(6,c_pincode);
            

            ResultSet rs = stmt.executeQuery("select * from address ");
            while(rs.next())
            System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3));

            //step 5 close the connection
            con.close();
        }
        catch(Exception e){System.out.println(e);}
    }
}
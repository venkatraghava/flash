package webapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
public class datadao {
public void adddetails(data d)
{
	Connection con=null;
	PreparedStatement pstmt=null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "raghava143@");
    pstmt=con.prepareStatement("insert into project values(?,?,?,?,?,?,?)");
    pstmt.setString(1, d.name);
    pstmt.setInt(2,d.id);
    File f=new File(d.propic);
    FileInputStream fis=new FileInputStream(f);
    pstmt.setBinaryStream(3,fis);
    pstmt.setString(4,d.collegename);
    pstmt.setString(5,d.username);
    pstmt.setString(6, d.email);
    pstmt.setString(7, d.password);
    int res=pstmt.executeUpdate();
    if(res>0)
    {
    	System.out.println("success");
    }
    fis.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
finally {
    if (pstmt != null) {
        try {
            pstmt.close();
        } catch (SQLException e) { /* ignored */}
    }
    if (con != null) {
        try {
            con.close();
        } catch (SQLException e) { /* ignored */}
    }
}
}
public data getdata(String username,String password)
{
	Connection con=null;
    Statement stmt=null;
	data d=new data();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "raghava143@");
		PreparedStatement pstmt=con.prepareStatement("select * from project where username=? and password=?");
	    pstmt.setString(1, username);
	    pstmt.setString(2, password);
		ResultSet rs=pstmt.executeQuery();
	    if(rs.next())
	    {
	    	d.name=rs.getString(1);
	    	d.id=rs.getInt(2);
	    	d.collegename=rs.getString(4);
	        d.username=rs.getString(5);
	        d.email=rs.getString(6);
	        d.password=rs.getString(7);
	    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		 if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e) { /* ignored */}
		    }
	}
	return d;
}
public byte[] getimage(int id){
	byte[] image = null;
	Connection con=null;
    PreparedStatement pstmt=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "raghava143@");
	    pstmt=con.prepareStatement("select image from project where id="+id);
	    System.out.println("succes1");
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()) {
	image = rs.getBytes(1);
	}
	}catch(Exception e) {
		e.printStackTrace();
	}
	finally {
	    if (pstmt != null) {
	        try {
	            pstmt.close();
	        } catch (SQLException e) { /* ignored */}
	    }
	    if (con != null) {
	        try {
	            con.close();
	        } catch (SQLException e) { /* ignored */}
	    }
	}
	return image;
}
}


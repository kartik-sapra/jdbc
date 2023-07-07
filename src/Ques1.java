import java.sql.*;
import java.util.*;
public class Ques1 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter roll no,name and age");
		int n=sc.nextInt();
		String nm=sc.next();
		int a=sc.nextInt();
		String ss="jdbc:mysql://localhost:3306/mydb";
		try(Connection con=DriverManager.getConnection(ss,"root","kartik@123"))
		{
			PreparedStatement pst=con.prepareStatement("insert into student values(?,?,?)");
			pst.setInt(1,n);
			pst.setString(2,nm);
			pst.setInt(3,a);
			int e=pst.executeUpdate();
			PreparedStatement pst1=con.prepareStatement("select * from student");
			ResultSet rs=pst1.executeQuery();
			if(e>0)
				System.out.println("record added");
			else
				System.out.println("failed");
			if(rs.next())
			{
				int x=rs.getInt(1);
				String y=rs.getString(2);
				int z=rs.getInt(3);
				System.out.println(x+"\t"+y+"\t"+z);
			}
			
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		
	}

}

import java.sql.*;
import java.util.*;
public class Ques2 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter designation");
//		int n=sc.nextInt();
		String nm=sc.next();
//		int a=sc.nextInt();
		String ss="jdbc:mysql://localhost:3306/mydb";
		try(Connection con=DriverManager.getConnection(ss,"root","kartik@123"))
		{
			PreparedStatement pst=con.prepareStatement("select * from Employee where desig=? ");
			//pst.setInt(1,n);
			pst.setString(1,nm);
			//.setInt(3,a);
		//	int e=pst.executeUpdate();
			//PreparedStatement pst1=con.prepareStatement("select * from student");
			ResultSet rs=pst.executeQuery();
//			if(e>0)
//				System.out.println("record added");
//			else
//				System.out.println("failed");
			while(rs.next())
			{
				//int x=rs.getInt(1);
				String y=rs.getString(2);
				//int z=rs.getInt(3);
				System.out.println(y);
			}
			
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		
	}

}

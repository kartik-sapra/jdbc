import java.sql.*;
public class App8
{
	public static void main(String args[])
	{
		try
		{
//Class.forName("com.mysql.jdbc.Driver");
String ss="jdbc:mysql://localhost:3306/mydb";
Connection con=DriverManager.getConnection(ss,"root","kartik@123");
Statement st=con.createStatement();
boolean b=st.execute("select * from dept");
//boolean b=st.execute("update dept set loc='Manali'");
if(b)
{
	ResultSet rs=st.getResultSet();
while(rs.next())
{
	int no=rs.getInt("deptno");
	String name=rs.getString("dname");
	String add=rs.getString("loc");
	System.out.println(no+"\t"+name+"\t"+add);
}
}
else
{
	int mod=st.getUpdateCount();
	System.out.println("mod is\t"+mod);
	if(mod>0)
	{
		System.out.println("Records are successfully added");
	}
}
con.close();
}
catch(Exception ee)
{
	System.out.println(ee);
}
}
}
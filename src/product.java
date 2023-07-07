import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class product {
	private int pid,qty;
	private double cost;
	private String name;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public product(int pid, int qty, double cost, String name) {
		super();
		this.pid = pid;
		this.qty = qty;
		this.cost = cost;
		this.name = name;
	}
	@Override
	public String toString() {
		return "product [pid=" + pid + ", qty=" + qty + ", cost=" + cost + ", name=" + name + "]";
	}
	public static void main(String[] args)
	{
		product p=new product(1,100,2000,"fan");
		System.out.println(p);
		String ss="jdbc:mysql://localhost:3306/mydb";
		try(Connection con=DriverManager.getConnection(ss,"root","kartik@123"))
				{
			PreparedStatement pst=con.prepareStatement("insert into product values(?,?,?,?)");
			pst.setInt(1,p.getPid());
			pst.setInt(2, p.getQty());
			pst.setDouble(3,p.getCost());
			pst.setString(4,p.getName());
			int val=pst.executeUpdate();
			if(val>0)
				System.out.println("record added");
			else
				System.out.println("not added");
			p=null;
			pst=con.prepareStatement("select * from product");

			ResultSet rs=pst.executeQuery();
			rs.next();
			product p2=new product(rs.getInt(1),rs.getInt(2),rs.getDouble(3),rs.getString(4));
			System.out.println(p2);
			
//			if(rs.next())
//			{
//				int a=rs.getInt(1);
//				int b=rs.getInt(2);
//				double c=rs.getDouble(3);
//				String d=rs.getString(4);
//				System.out.println(a+"\t"+b+"\t"+c+"\t"+d);
//			}
				}
		catch(Exception ee) {
		System.out.println(ee);
		}
		
	}
	

}

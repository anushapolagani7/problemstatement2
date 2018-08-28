import javax.servlet;
import java.io;
import javax.servlet.HttpServlet;
import java.sql;
class StoreData
{
	public void dopost(HttpServletrequest request,HttpservletResponse response)throws ServletException,IOexception
	{
		String flightno=request.getParameter("fnumber");
		String airname=request.getParameter("anumber");
		String dest=request.getParameter("dest");
		String src=request.getParameter("src");
		String deptdate=request.getParameter("deptdate");
		String depttime=request.getParameter("depttime");
		String arrdate=request.getParameter("arrdate");
		String arrtime=request.getParameter("arrtime");
		String price=request.getParameter("price");
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:@localhost:1521:thin:orcl","scott","tiger");
		Statement st=con.createStatement();
		st.executeQuery("insert into table fightinfo values(\"+flightno+\"+,+\"+airname+\"+,+\"+dest+\"+\"+src+\"+,+\"+deptdate+\"+,+\"+depttime+\"+,+\"+arrdate+\"+,+\"+arrtime+\"+,+\"+price+\"+\")");
PrintWriter out=new Printwriter();
RequestDispatcher rd=request.getRequestDispatcher("show");
rd.include();

		
		catch(Exception e)
		{
			out.printStackTrace(e);
		}
		finally{
			st.close();
			con.close();
			out.close();
		}
	}
		

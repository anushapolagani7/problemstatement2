import javax.servlet;
import java.io;
import javax.servlet.HttpServlet;
import java.sql;
class ShowData
{
	public void dopost(HttpServletrequest request,HttpservletResponse response)throws ServletException,IOexception
	{  PrintWriter out=new Printwriter();
	response.setContentType("text/html");
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:@localhost:1521:thin:orcl","scott","tiger");
		Statement st=con.createStatement();
		Resultset rs=st.executeQuery("select *from fightinfo");
		ResultsetMetadata rsmd=rs.getResultsetMetadata();
		while(rs.next)
		{
		String flightno=rs.getString("fnumber");
		String airname=rs.getString("anumber");
		String dest=rs.getString("dest");
		String src=rs.getString("src");
		String deptdate=rs.getString("deptdate");
		String depttime=rs.getString("depttime");
		String arrdate=rs.getString("arrdate");
		String arrtime=rs.getString("arrtime");
		String price=rs.getString("price");
		}
		out.print("<html><body>
		         <table><tr><td>flight number:</td><td>+"flightno+"</td></tr>
				 <tr><td>Airline number:</td><td>+"airname"+</td></tr>
				 <tr><td>Destination:</td><td>+"dest"+</td></tr>
				 <tr><td>Source:</td><td>+"src"+</td></tr>
				  <tr><td>Departure time</td><td>+"depttime"+</td></tr>
				   <tr><td>Departure Dt</td><td>+"deptdate"+</td></tr>
				    <tr><td>Arrival Time</td><td>+"arrtime"+</td></tr>
				    <tr><td>Arrval dt</td><td>+"arrdate"+</td></tr>
					 <tr><td>price of ticket</td><td>+"price"+</td></tr>
					 </table>
					 </body>
					 </html>");
	}
	catch(Exception e)
	{
		out.printStackTrace();
	}
	finally
	{
		out.close();
		
		st.close();
		con.close();
	}
}
					 
		
			
			
			

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ImportZipcode")
public class ImportZipcode extends HttpServlet {

    private static final long serialVersionUID = 1L;
    double distance1;

    public ImportZipcode()
    {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        HttpSession ssn=request.getSession(true);
        out.print( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0" );
        out.print( "Transitional//EN\">\n" );
        out.print( "<html><head><title>ImportZipCode</title></head>\n<body>" );

        try
        {
        	String host 	= "cs3.calstatela.edu";
        	String port 	= "3306";
        	String dbName 	= "cs320stu163";
        	
            String username = "cs320stu163";
            String password = "!#pWw.D#";
            String url ="jdbc:mysql://" + host + ":" + port + "/" + dbName;

            Connection c = DriverManager
                .getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM  `TABLE 1`" );
            ArrayList<zipCodeAdd> entries = new ArrayList<zipCodeAdd>();
            
            out.println("ZIP"); out.println("Latitude");out.println("Longitude");out.println("CITY");out.println("State");out.println("</br>");
            
            while( rs.next() )
            {
                          
                distance1= distance((Double.parseDouble(request.getParameter("lat"))),(Double.parseDouble(request.getParameter("lon"))),rs.getDouble( "Latitude" ),rs.getDouble( "Longitude" ));
                if(distance1-(Double.parseDouble(request.getParameter("radius")))<=(Double.parseDouble(request.getParameter("radius"))))
                {
                	out.println( rs.getInt("ZIP"));out.println("   ");
                    out.println( rs.getDouble( "Latitude" ) );out.println("   ");
                    out.println( rs.getDouble( "Longitude" ) );out.println("   ");
                    out.println( rs.getString("CITY"));out.println("   ");
                    out.println( rs.getString( "State" ) );out.println("   ");
                    out.println("</br>");
                    
                    entries.add( new zipCodeAdd( rs.getInt("ZIP"),rs.getDouble( "Latitude" ),  rs.getDouble( "Longitude" ),rs.getString("CITY"),rs.getString( "State" ) ));
                    
                	
                }
            }
            
            ssn.setAttribute("ImportSession", entries);
            
            /*try {
                RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/NearByZipcodes.jsp");
                rd.forward(request, response);
                
            } catch (Exception e) {
                e.printStackTrace();
            }*/
           /* getServletContext().setAttribute( "entries", entries );
            RequestDispatcher dispatcher =request.getServletContext().getRequestDispatcher("/WEB-INF/NearByZipcodes.jsp");
            dispatcher.forward(request, response);
           */ c.close();
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }

        out.print( "</body></html>" );
        
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
    	double theta = lon1-lon2;
    	double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
    	dist = Math.acos(dist);
    	dist = rad2deg(dist);
    	dist = dist * 60 * 1.1515;
    	return (dist);
    }
    
    private double deg2rad(double deg) {
    	return (deg * Math.PI / 180.0);
    }
    
    private double rad2deg(double rad) {
    	return (rad * 180 / Math.PI);
    }
    
}

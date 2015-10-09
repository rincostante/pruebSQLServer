package ar.gob.ambiente.servicios.pruebasqlserver;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://vmsqldes:1433;" +
            "databaseName=RegistroUnicoDeEmpresas;user=web_user;password=web_user;";
            Connection con = DriverManager.getConnection(connectionUrl);
            System.out.println("Conxión correcta!");
            System.out.println(".................");
            
            String sql = "SELECT CUIT, RazonSocial, NombreDeFantasia FROM Empresa";
            
            Statement stmt = null;
            
            stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                System.out.println(rs.getString("CUIT") + " - " + rs.getString("RazonSocial") + " - " + rs.getString("NombreDeFantasia"));
            }
            
            con.close();
            
        }catch(SQLException e){
            System.out.println("SQL Exception: "+ e.toString());
        }catch(ClassNotFoundException cE){
            System.out.println("Class Not Found Exception: "+ cE.toString());
        }
    }
}

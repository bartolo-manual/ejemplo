package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Controlador {

	Connection con;
	PreparedStatement ps;
	private Animales ani;
	
	public Connection Conexion(){
		try {
			con=DriverManager.getConnection("jdbc:msql:/localhost:3306/ejemplo","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
	public boolean guardaranimal(Animales ani) {
	    
		boolean guarda = false;
	    Conexion();
	    try {
	        ps = con.prepareStatement("insert into AnimalesBartolo values(?,?,?)");
	        ps.setInt(1, ani.getIdAnimales());
	        ps.setString(2, ani.getTamaño());
	        ps.setString(3, ani.getRaza());
	        int filasmodificadas = ps.executeUpdate();
	        if (filasmodificadas > 0) {
	            guarda = true;
	            JOptionPane.showMessageDialog(null, "guardado");
	        } else {
	            JOptionPane.showMessageDialog(null, "no guardado");
	        }
	        ps.close();
	        con.close();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        // e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "error al guardar" + e);
	    }
	    return guarda;
	}
}

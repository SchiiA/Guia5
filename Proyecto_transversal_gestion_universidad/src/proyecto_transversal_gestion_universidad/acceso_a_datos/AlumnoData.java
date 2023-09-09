
package proyecto_transversal_gestion_universidad.acceso_a_datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto_transversal_gestion_universidad.entidades.Alumno;


public class AlumnoData {
    private Connection con=null;
    
    public AlumnoData (){
        con=Conexion.getConection();
    }
    
    public void guardarAlumno (Alumno alumno){
    
        String sql = "Insert into alumno (dni,apellido,nombre,fechaNacimiento,estado)" + "values (?,?,?,?,?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()){
                    
                alumno.setIdAlumno(rs.getInt(1));
            
                JOptionPane.showMessageDialog(null, "Alumno Guardado");
                            
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno");
        }
      
    }
    
    
}
 

                                                                                                                                                                    
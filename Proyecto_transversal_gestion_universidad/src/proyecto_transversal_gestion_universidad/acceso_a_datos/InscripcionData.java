/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_transversal_gestion_universidad.acceso_a_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto_transversal_gestion_universidad.entidades.Inscripcion;

/**
 *
 * @author Equipo
 */
public class InscripcionData {
    private Connection con;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
        con=Conexion.getConection();
    }
    
    public void guardarInscripcion(Inscripcion insc){
        
        String sql="insert into inscripcion (nota, idAlumno,idMateria)values (?,?,?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                insc.setIdInscripto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno: "+insc.getAlumno().getNombre()+" fue inscripto a la materia: "+insc.getMateria().getNombre());
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
    }
    
    public ArrayList<Inscripcion> obtenerInscripciones(){
        return null;
    }
}

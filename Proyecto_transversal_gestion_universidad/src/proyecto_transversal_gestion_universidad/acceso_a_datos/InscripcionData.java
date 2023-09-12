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
import javax.swing.JOptionPane;
import proyecto_transversal_gestion_universidad.entidades.Alumno;
import proyecto_transversal_gestion_universidad.entidades.Inscripcion;
import proyecto_transversal_gestion_universidad.entidades.Materia;

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
        ArrayList<Inscripcion> lista=new ArrayList<>();
        Inscripcion ins=null;
        String sql="select* from inscripcion in join alumno al on(in.idALumno=al.idAlumno) join materia mat on (in.idMateria=mat.idMateria) where al.estado=true and mat.estado=true";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ins.setIdInscripto(rs.getInt("idInscripcion"));
                ins.setNota(rs.getDouble("nota"));
                int idAlumno=(rs.getInt("idAlumno"));
                Alumno alumno=aluData.buscarAlumnoPorDni(idAlumno);
                ins.setAlumno(alumno);
                int idMateria=rs.getInt("idMateria");
                Materia materia=matData.buscarMateria(idMateria);
                ins.setMateria(materia);
                lista.add(ins);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
        return lista;
    }
    
}

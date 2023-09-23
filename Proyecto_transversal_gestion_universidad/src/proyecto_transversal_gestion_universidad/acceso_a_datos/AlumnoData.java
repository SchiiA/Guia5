package proyecto_transversal_gestion_universidad.acceso_a_datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto_transversal_gestion_universidad.entidades.Alumno;
import proyecto_transversal_gestion_universidad.entidades.Materia;

public class AlumnoData {

    private Connection con = null;

    public AlumnoData() {
        con = Conexion.getConection();
    }

    public boolean guardarAlumno(Alumno alumno) {
        boolean veri = true;
        if (buscarAlumnoPorDni(alumno.getDni()) == null) {
            String sql = "Insert into alumno (dni,apellido,nombre,fechaNacimiento,estado)" + "values (?,?,?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, alumno.getDni());
                ps.setString(2, alumno.getApellido());
                ps.setString(3, alumno.getNombre());
                ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
                ps.setBoolean(5, alumno.isEstado());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    alumno.setIdAlumno(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Alumno Guardado");
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
            }
        } else {
            veri = modificarAlumnoExistenteOff(alumno);
        }
        return veri;
    }

    private boolean modificarAlumnoExistenteOff(Alumno alumno) {
        boolean veri = false;
        String sql = "UPDATE alumno SET apellido= ?,nombre= ?,fechaNacimiento= ?, estado=true WHERE dni= ? and estado=false ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, alumno.getApellido());
            ps.setString(2, alumno.getNombre());
            ps.setDate(3, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(4, alumno.getDni());
            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "alumno Guardado");
                veri = true;
            } else {
                JOptionPane.showMessageDialog(null, "alumno ya existente, intente buscarlo por su dni");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alumno");
        }
        return veri;
    }

    public void modificarAlumno(Alumno alumno) {

        String sql = "UPDATE alumno SET apellido= ?,nombre= ?,fechaNacimiento= ?" + "WHERE dni= ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, alumno.getApellido());
            ps.setString(2, alumno.getNombre());
            ps.setDate(3, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(4, alumno.getDni());

            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "alumno modificado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alumno");
        }
    }

    public void eliminarAlumno(int dni) {

        String sql = "UPDATE alumno SET estado =0 WHERE dni= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "Alumno Eliminado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alumno");
        }

    }

    public List<Alumno> listarAlumnos() {
        String sql = "SELECT idAlumno,dni,apellido,nombre,fechaNacimiento FROM alumno WHERE estado=true";
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alumno");
        }
        return alumnos;
    }

//    private Alumno buscarAlumnoPorDni2(int dni) {
//        String sql = "SELECT * FROM alumno WHERE dni= ?";
//        Alumno alumno = null;
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, dni);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                alumno = new Alumno();
//                alumno.setIdAlumno(rs.getInt("idALumno"));
//                alumno.setDni(rs.getInt("dni"));
//                alumno.setApellido(rs.getString("apellido"));
//                alumno.setNombre(rs.getString("nombre"));
//                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
//                alumno.setEstado(rs.getBoolean("estado"));
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return alumno;
//    }
    public Alumno buscarAlumnoPorDni(int dni) {
        String sql = "SELECT idAlumno,dni,apellido,nombre,fechaNacimiento FROM alumno WHERE dni= ? AND estado= 1";
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idALumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);

            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumno;
    }

    public Alumno buscarAlumnoPorId(int id) {
        String sql = "SELECT dni,apellido,nombre,fechaNacimiento FROM alumno WHERE idAlumno= ? AND estado= 1";
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumno;
    }

}

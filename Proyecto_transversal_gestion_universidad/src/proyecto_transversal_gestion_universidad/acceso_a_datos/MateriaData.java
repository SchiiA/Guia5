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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyecto_transversal_gestion_universidad.entidades.Materia;

/**
 *
 * @author Equipo
 */
public class MateriaData {

    private Connection con = null;
    public static ArrayList<Materia> listaMateria = new ArrayList<>();

    public MateriaData() {
        this.con = Conexion.getConection();
    }

    public boolean guardarMateria(Materia mat) {
        boolean verifi=true;
        if (buscarMateriaPorNombre(mat.getNombre(), mat.getAnio()) == null) {
            String sql = "INSERT INTO materia(nombre,año,estado) VALUES (?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, mat.getNombre());
                ps.setInt(2, mat.getAnio());
                ps.setBoolean(3, mat.isEstado());
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    mat.setIdMateria(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Materia Guardado!");
                }
                ps.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexion... " + ex.getMessage());
            }
        } else {
            verifi=modificarMateriaExistenteOff(mat);
        }
        return verifi;
    }

    public boolean modificarMateriaExistenteOff(Materia mat) {
        boolean verifi=false;
        String sql = "update materia set estado=true,año=? where nombre like ? and estado=false";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mat.getAnio());
            ps.setString(2, mat.getNombre());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia Guardado!");
                verifi=true;
            } else {
                JOptionPane.showMessageDialog(null, "La materia ingresada de ese año ya existe, intente buscarlo por su nombre");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla materia");
        }
        return verifi;
    }

    public boolean modificarMateria(Materia mat) {
        ArrayList<Materia> materias = new ArrayList<>(listarMaterias(mat.getNombre()));
        boolean verifi = false;
        for (Materia re : materias) {
            if (re.getAnio() == mat.getAnio()) {
                verifi = true;
            }
        }
        if (verifi == false) {
            String query = "UPDATE materia SET año=? ,estado=? where idMateria=?";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, mat.getAnio());
                ps.setBoolean(2, mat.isEstado());
                ps.setInt(3, mat.getIdMateria());
                ps.executeUpdate();
                int exito = ps.executeUpdate();
                if (exito == 1) {
                    verifi = true;
                    JOptionPane.showMessageDialog(null, "materia Modificada");
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexion... " + ex.getMessage());
            }
            return verifi;
        } else {
            JOptionPane.showMessageDialog(null, "la materia a modificar con el año ingresado ya existe");
            return verifi;
        }
    }

    public void eliminarMateria(String nombre,int anio) {
        String SQL = "UPDATE materia SET estado=false where nombre=? and año=?";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, nombre);
            ps.setInt(2, anio);
            ps.executeUpdate();
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "materia eliminada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion... " + ex.getMessage());
        }
    }

    public Materia buscarMateria(int id) {
        String sql = "SELECT nombre,año,estado FROM materia WHERE idMateria =? AND estado = 1";
        Materia materia = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "no existe la materia");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
        return materia;
    }

    public Materia buscarMateriaPorNombre(String nombre) {

        String sql = "SELECT idMateria, año, estado FROM materia WHERE nombre like ? AND estado = 1";
        Materia materia = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(nombre);
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(true);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia: " + ex.getMessage());
        }

        return materia;
    }

    public Materia buscarMateriaPorNombre(String nombre, int anio) {
        String sql = "SELECT idMateria, año, estado FROM materia WHERE nombre like ? AND año = ?";
        Materia materia = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setInt(2, anio);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(nombre);
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(true);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia: " + ex.getMessage());
        }

        return materia;
    }

    public ArrayList<Materia> listarMaterias(String nombre) {
        ArrayList<Materia> materias = new ArrayList<>();
        Materia materia = null;
        String sql = "select * from materia where estado=true and nombre like ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
        return materias;
    }

    public ArrayList<Materia> listarMaterias() {
        ArrayList<Materia> materias = new ArrayList<>();
        Materia materia = null;
        String sql = "select * from materia where estado=true";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
        return materias;
    }
}

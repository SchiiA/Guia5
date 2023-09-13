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
        this.con = Conexion.getConexion();
    }

    public void guardarMateria(Materia mat) {
        String sql = "INSERT INTO materia(nombre,año,estado) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, mat.getNombre());
            ps.setInt(2, mat.getAño());
            ps.setBoolean(3, mat.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mat.setIdMateria(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo tener el ID...");
            }
            ps.close();
            JOptionPane.showMessageDialog(null, "Guardado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion... " + ex.getMessage());
        }
    }

    public void modificarMateria(Materia mat) {
        String query = "UPDATE materia SET nombre=?,año=? ,estado=?"
                + "where idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, mat.getNombre());
            ps.setInt(2, mat.getAño());
            ps.setBoolean(3, mat.isEstado());
            ps.executeUpdate();
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "materia Modificada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion... " + ex.getMessage());
        }
    }

    public void eliminarMateria(int id) {
        String SQL = "UPDATE materia SET estado=0"
                + "where idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
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
        String sql = "SELECT idMateria, año, estado FROM materia WHERE nombre = ? AND estado = 1";
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
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró una materia con ese nombre.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia: " + ex.getMessage());
        }

        return materia;
    }
}

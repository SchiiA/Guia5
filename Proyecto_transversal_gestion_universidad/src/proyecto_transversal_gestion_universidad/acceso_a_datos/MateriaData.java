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
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void guardarMateria(Materia mat) {
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
        if (buscarMateriaPorNombre(mat.getNombre()).getAnio()!=mat.getAnio()) {
            String query = "UPDATE materia SET año=? ,estado=? where idMateria=?";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, mat.getAnio());
                ps.setBoolean(2, mat.isEstado());
                ps.setInt(3, mat.getIdMateria());
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
    }

    public void eliminarMateria(String nombre) {
        String SQL = "UPDATE materia SET estado=false where nombre=?";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, nombre);
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
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia: " + ex.getMessage());
        }

        return materia;
    }

    public Materia buscarMateriaPorNombre(String nombre, int anio) {
        String sql = "SELECT idMateria, año, estado FROM materia WHERE nombre = ? AND estado = 1 AND año = ?";
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

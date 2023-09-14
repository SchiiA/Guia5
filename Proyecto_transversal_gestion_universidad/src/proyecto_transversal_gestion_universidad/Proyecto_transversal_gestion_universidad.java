/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_transversal_gestion_universidad;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import proyecto_transversal_gestion_universidad.acceso_a_datos.AlumnoData;
import proyecto_transversal_gestion_universidad.acceso_a_datos.Conexion;
import proyecto_transversal_gestion_universidad.acceso_a_datos.MateriaData;
import proyecto_transversal_gestion_universidad.entidades.Alumno;
import proyecto_transversal_gestion_universidad.entidades.Materia;


public class Proyecto_transversal_gestion_universidad {

    
    public static void main(String[] args) {
//   
//        MateriaData mat=new MateriaData();
//        for (Materia materia:mat.buscarMateria()){
//            System.out.println(materia.getAño());
//            System.out.println(materia.getClass());
//        }
        AlumnoData alu=new AlumnoData();
        System.out.println(alu.buscarAlumnoPorDni2(123));
    }
    
}

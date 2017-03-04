/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author educacionit
 */
public class DAO {

    /**
     * @param c
     * @param a
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    
    public static List<Alumno> getAlumnos (Connection c) throws SQLException {
        
        String selectSql = "SELECT * FROM Alumnos";
        
        PreparedStatement ps=c.prepareStatement(selectSql);
        ResultSet rs = ps.executeQuery();
        List<Alumno> alumnos = new ArrayList();
        while (rs.next()) {
            alumnos.add(new Alumno (rs.getInt("id"), rs.getString("nombre"),rs.getString("Apellido")));
        }
        
        ps.close();
        return alumnos;
    }
    
    public static void saveAlumno (Connection c, Alumno a) throws SQLException {
        
        String insertSql = "INSERT INTO Alumnos (NOMBRE,APELLIDO) VALUES (?,?)";
        
        PreparedStatement ps=c.prepareStatement(insertSql);
        
        ps.setString(1, a.getNombre());   
        ps.setString(2, a.getApellido());
        
        ps.executeUpdate();
        ps.close();
        
    }
    
    public static void updateAlumno (Connection c, Alumno a) throws SQLException {
        
        String insertSql = "UPDATE Alumnos SET NOMBRE = ?, APELLIDO = ? WHERE id = ?";
        
        PreparedStatement ps=c.prepareStatement(insertSql);
        
           
        ps.setString(1, a.getApellido());
        ps.setString(2, a.getNombre());
        ps.setInt(3, a.getId());

        ps.executeUpdate();
        ps.close();
        
    }
             
    
     
    public static void main(String[] args) throws SQLException {
        Connection c=DriverManager.getConnection("jdbc:mysql://localhost/data","root","");
        Alumno a1= new Alumno (3, "Juan","Lopez");
        updateAlumno(c,a1);
        getAlumnos(c).stream().forEach(System.out::println);
        
        
    }
    
}

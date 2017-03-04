package db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author educacionit
 */
public class Delete {
    
    public static void deleteAlumno (Connection c, Alumno a) throws SQLException {
    
        String query="DELETE FROM ALUMNOS WHERE ID=?";
        PreparedStatement st= c.prepareStatement(query);
        
    }
}

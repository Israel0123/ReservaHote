/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author isrm_
 */
public class Conexion {
    
    public String db="basereserva";
    public String url="jdbc:mysql://127.0.0.1"+db;
    public String user="root";
    public String pass="";
    
    public Conexion(){
    }
    
    public Connection Conectar()  
    {
        Connection link=null;
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link=DriverManager.getConnection(this.url, this.user, this.pass);///conexion con la base de datos
        } catch ( Exception e) {
            JOptionPane.showConfirmDialog(null, e);///muestra el mensaje de la excepcion en una ventana
        }
        
        return link;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vhabitacion;
import Datos.vproducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isrm_
 */
public class fproducto {
    
     private Conexion mysql=new Conexion();//instancia de la  cadena de conexion.
    private Connection cn=mysql.Conectar();//variable de para enlazar con el metodo conectar.
    private String sSQL;///variable de conexion, obtiene los datos de la base de datos
    public Integer totalregistros;//va acontar el numero total de registros
    
    ///metodo en el cual se va a manejar la tabla para poder mostrar los datos, se manejaran dos vectores uno sera las filas y el otro las columnas

       public DefaultTableModel  mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID", "Producto", "Descripcion","Unidad Medida","Precio Venta"};///variable de los totilos de la tabla
        String [] registro=new String [5];//vector en el cual se almacenara el numero total de registros.
        totalregistros=0;///se inicializa la variable total de registros.
        modelo=new DefaultTableModel(null, titulos);//se le pasan dos parametros null y titulos para que lo vaya colocando cada vez que se inicialicen
        
        sSQL="Select * from producto where nombre like '%"+buscar+"%' order by idproducto desc"; //obtiene los registros de la tabla habitacion y los ordena por id
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);///obtiene la consulta de la base de datos
            
            while(rs.next()){
                registro[0]=rs.getString("idproducto");
                registro[1]=rs.getString("nombre");
                registro[2]=rs.getString("descripcion");
                registro[3]=rs.getString("unidad_medida");
                registro[4]=rs.getString("precio_venta");
                
                totalregistros=totalregistros+1;///este es el contador que aparece en la parte derecha inferior de la tabla.
                modelo.addRow(registro);
                
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       }
       
       public boolean Insertar(vproducto dts)
       {
           sSQL="insert into producto (nombre, descripcion, unidad_medida,precio_venta)"+
                   "values(?,?,?,?)";
           try {
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setString(1, dts.getNombre());
               pst.setString(2, dts.getDescripcion());
               pst.setString(3, dts.getUnidad_medida());
               pst.setDouble(4, dts.getPrecio_venta());
               
              int n=pst.executeUpdate();
                
                if(n!=0)//se verifica que n no este vacio o que tenga un valor diferente a 0
                {
                    return true;///si no esta vacio regresa un valor verdadero
                }
                else
                    return false;////si esta vacio regrresa un valor falso
                
            }catch(Exception e)
            {
                JOptionPane.showConfirmDialog(null,e);///si se produce una excepcion se captura la excepcion
                return false;///se regresa un valor falso en caso de que se ejecute la excepcion
            }
 
       }
       
       public boolean Editar(vproducto dts)
       {
           sSQL="update producto set nombre=?, descripcion=?, unidad_medida=?, precio_venta=?"+
                   "where idproducto=?";
           try {
               
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setString(1, dts.getNombre());
               pst.setString(2, dts.getDescripcion());
               pst.setString(3, dts.getUnidad_medida());
               pst.setDouble(4, dts.getPrecio_venta());
               
              pst.setInt(5,dts.getIdproducto());
              int n=pst.executeUpdate();
                
                if(n!=0)//se verifica que n no este vacio o que tenga un valor diferente a 0
                {
                    return true;///si no esta vacio regresa un valor verdadero
                }
                else
                    return false;////si esta vacio regrresa un valor falso
               
           } catch (Exception e) {
               JOptionPane.showConfirmDialog(null, e);
               return false;
           }
           
       }
       public boolean Eliminar(vproducto dts)
       {
           sSQL="delete from producto where idproducto=?";
           try {
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setInt(1, dts.getIdproducto());
               
               int n=pst.executeUpdate();
                
                if(n!=0)//se verifica que n no este vacio o que tenga un valor diferente a 0
                {
                    return true;///si no esta vacio regresa un valor verdadero
                }
                else
                    return false;////si esta vacio regrresa un valor falso
               
               
           } catch (Exception e) {
               JOptionPane.showConfirmDialog(null,e);
               return false;
           }
       }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vhabitacion;
import Datos.vpago;
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
public class fpago {
    
     private Conexion mysql=new Conexion();//instancia de la  cadena de conexion.
    private Connection cn=mysql.Conectar();//variable de para enlazar con el metodo conectar.
    private String sSQL;///variable de conexion, obtiene los datos de la base de datos
    public Integer totalregistros;//va acontar el numero total de registros
    
    ///metodo en el cual se va a manejar la tabla para poder mostrar los datos, se manejaran dos vectores uno sera las filas y el otro las columnas

       public DefaultTableModel  mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID","Idreserva","Comprobante","Numero", "Igv", "Total","Fecha Emision","Fecha Paga"};///variable de los totilos de la tabla
        String [] registro=new String [8];//vector en el cual se almacenara el numero total de registros.
        totalregistros=0;///se inicializa la variable total de registros.
        modelo=new DefaultTableModel(null, titulos);//se le pasan dos parametros null y titulos para que lo vaya colocando cada vez que se inicialicen
        
        sSQL="Select * from pago where idreserva="+buscar+"%' order by idpago desc"; //obtiene los registros de la tabla habitacion y los ordena por id
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);///obtiene la consulta de la base de datos
            
            while(rs.next()){
                registro[0]=rs.getString("idpago");
                registro[1]=rs.getString("idreserva");
                registro[2]=rs.getString("tipo_comprobante");
                registro[3]=rs.getString("num_comprobante");
                registro[4]=rs.getString("igv");
                registro[5]=rs.getString("total_pago");
                registro[6]=rs.getString("fecha_emision");
                registro[7]=rs.getString("fecha_pago");
                
                totalregistros=totalregistros+1;///este es el contador que aparece en la parte derecha inferior de la tabla.
                modelo.addRow(registro);
                
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       }
       
       public boolean Insertar(vpago dts)
       {
           sSQL="insert into pago (idreserva, tipo_comprobante, igv,total_pago,fecha_emision,fecha_pago)"+
                   "values(?,?,?,?,?,?,?)";
           try {
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setInt(1, dts.getIdreserva());
               pst.setString(2, dts.getTipo_comprobante());
               pst.setString(3, dts.getNum_comprobante());
               pst.setDouble(4, dts.getIgv());
               pst.setDouble(5, dts.getTotal_pago());
               pst.setDate(6, dts.getFecha_emision());
               pst.setDate(7, dts.getFecha_pago());
               
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
       
       public boolean Editar(vpago dts)
       {
           sSQL="update producto set idreserva=?, tipo_comprobante=?, num_comprobante=?, igv=?,total_pago=?,fecha_emision=?,fecha_pago=?"+
                   "where idpago=?";
           try {
               
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setInt(1, dts.getIdreserva());
               pst.setString(2, dts.getTipo_comprobante());
               pst.setString(3, dts.getNum_comprobante());
               pst.setDouble(4, dts.getIgv());
               pst.setDouble(5, dts.getTotal_pago());
               pst.setDate(6, dts.getFecha_emision());
               pst.setDate(7, dts.getFecha_pago());
               pst.setInt(8,dts.getPago());
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
       public boolean Eliminar(vpago dts)
       {
           sSQL="delete from producto where idpago=?";
           try {
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setInt(1, dts.getPago());
               
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

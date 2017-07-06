/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vhabitacion;
import Datos.vproducto;
import Datos.vreserva;
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
public class freserva {
    
     private Conexion mysql=new Conexion();//instancia de la  cadena de conexion.
    private Connection cn=mysql.Conectar();//variable de para enlazar con el metodo conectar.
    private String sSQL;///variable de conexion, obtiene los datos de la base de datos
    public Integer totalregistros;//va acontar el numero total de registros
    
    ///metodo en el cual se va a manejar la tabla para poder mostrar los datos, se manejaran dos vectores uno sera las filas y el otro las columnas

       public DefaultTableModel  mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID", "Idhabitacion", "Numero","icliente","Cliente","idtrabajador","Trabajador","Tipo Reserva","Fecha Reserva","Fecha Ingreso","Fecha Salida","Costo","Estado"};///variable de los totilos de la tabla
        String [] registro=new String [13];//vector en el cual se almacenara el numero total de registros.
        totalregistros=0;///se inicializa la variable total de registros.
        modelo=new DefaultTableModel(null, titulos);//se le pasan dos parametros null y titulos para que lo vaya colocando cada vez que se inicialicen
        
        sSQL="Select r.idreserva, r.idhabitacion, h.numero,r.idcliente,"+
                "(select nombre from persona where idpersona=r.idcliente)as cliente,"+
                "(select apaterno from persona where idpersona=r.idcliente)as clienteap,"+
                "r.idtrabajador,(select nombre from persona where idpersona=r.idtrabajador)as trabajadorn,"+
                "(select apaterno from persona where idpersona=r.idtrabajador)as trabajadorap,"+
                "r.tipo_reserva, r.fecha_reserva,r.fecha_ingresa,r.fecha_salida,"+
                "r.costo_alojamiento,r.estado from reserva r inner join habitacion h on r.idhabitacion=h.idhabitacion where r.fecha_reserva like '%"+buscar+"%' order by idreserva desc"; //obtiene los registros de la tabla habitacion y los ordena por id
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);///obtiene la consulta de la base de datos
            
            while(rs.next()){
                registro[0]=rs.getString("idreserva");
                registro[1]=rs.getString("idhabitacion");
                registro[2]=rs.getString("numero");
                registro[3]=rs.getString("idcliente");
                registro[4]=rs.getString("clienten")+" "+rs.getString("clienteap");
                registro[5]=rs.getString("idtrabajador");
                registro[6]=rs.getString("trabajadorn")+" "+rs.getString("trabajadorap");
                registro[7]=rs.getString("tipo_reserva");
                registro[8]=rs.getString("fecha_reserva");
                registro[9]=rs.getString("fecha_ingresa");
                registro[10]=rs.getString("fecha_salida");
                registro[11]=rs.getString("costo_alojamiento");
                registro[12]=rs.getString("estado");
                
                totalregistros=totalregistros+1;///este es el contador que aparece en la parte derecha inferior de la tabla.
                modelo.addRow(registro);
                
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       }
       
       public boolean Insertar(vreserva dts)
       {
           sSQL="insert into reserva (idhabitacion,idcliente,idtrabajador,tipo_reserva,fecha_reserva,fecha_ingresa,fecha_salida,costo_alojamiento,estado)"+
                   "values(?,?,?,?,?,?,?,?,?)";
           try {
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setInt(1, dts.getIdhabitacion());
               pst.setInt(2, dts.getIdcliente());
               pst.setInt(3, dts.getIdTrabajador());
               pst.setString(4, dts.getTipo_reserva());
               pst.setDate(5, dts.getFecha_reserva());
               pst.setDate(6, dts.getFecha_ingresa());
               pst.setDate(7, dts.getFecha_salida());
               pst.setDouble(8, dts.getCosto_alojamiento());
               pst.setString(9, dts.getEstado());
               
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
       
       public boolean Editar(vreserva dts)
       {
           sSQL="update reserva set idhabitacion=?, idcliente=?, idtrabajador=?, tipo_reserva=?, fecha_reserva=?, fecha_ingresa=?, fecha_salida=?, costo_alojamiento=?, estado=?"+
                   "where idreserva=?";
           try {
               
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setInt(1, dts.getIdhabitacion());
               pst.setInt(2, dts.getIdcliente());
               pst.setInt(3, dts.getIdTrabajador());
               pst.setString(4, dts.getTipo_reserva());
               pst.setDate(5, dts.getFecha_reserva());
               pst.setDate(6, dts.getFecha_ingresa());
               pst.setDate(7, dts.getFecha_salida());
               pst.setDouble(8, dts.getCosto_alojamiento());
               pst.setString(9, dts.getEstado());
               
              pst.setInt(10,dts.getIdreserva());
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
       
       public boolean pagar(vreserva dts)
       {
           sSQL="update reserva set estado='Pagada'"+
                   "where idreserva=?";
           try {
               
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setInt(1, dts.getIdreserva());
               
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
       
       public boolean Eliminar(vreserva dts)
       {
           sSQL="delete from reserva where idreserva=?";
           try {
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setInt(1, dts.getIdreserva());
               
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

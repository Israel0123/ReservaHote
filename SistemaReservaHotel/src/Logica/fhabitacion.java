/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author isrm_
 */
import Datos.vhabitacion;///se importa la clase vhabitacion del paquete Datos
import java.sql.Connection;//Se importa la clase de conexion Connection
import java.sql.PreparedStatement;
import java.sql.ResultSet;//se importa la clase para poder visualizar el resultado de la consulta a la base de datos
import java.sql.Statement;
import javax.swing.JOptionPane;//se utiliza la clase JOptionPane para la cachar mensajes de la excepciones ocurridas
import javax.swing.table.DefaultTableModel;///se llama a la tabla para poder guardar datos dentro de esta

public class fhabitacion {
    
    private Conexion mysql=new Conexion();//instancia de la  cadena de conexion.
    private Connection cn=mysql.Conectar();//variable de para enlazar con el metodo conectar.
    private String sSQL;///variable de conexion, obtiene los datos de la base de datos

    /**
     *
     */
    public Integer totalregistros;//va acontar el numero total de registros
    
    ///metodo en el cual se va a manejar la tabla para poder mostrar los datos, se manejaran dos vectores uno sera las filas y el otro las columnas

    
    public boolean ocupar(vhabitacion dts)
    {
        sSQL="update habitacion estado='Ocupado'"+
                "where idhabitacion=?";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdhabitacion());
            
            int n=pst.executeUpdate();
            
            if(n!=0)
            {
                return true;
            }
            else
            {
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
       public DefaultTableModel  mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID", "Numero", "piso","Descripcion","Caracteristicas", "Precio", "Estado", "Tipo Habitacion"};///variable de los totilos de la tabla
        String [] registro=new String [8];//vector en el cual se almacenara el numero total de registros.
        totalregistros=0;///se inicializa la variable total de registros.
        modelo=new DefaultTableModel(null, titulos);//se le pasan dos parametros null y titulos para que lo vaya colocando cada vez que se inicialicen
        
        sSQL="Select * from habitacion where piso like '%"+buscar+"%' order by idhabitacion"; //obtiene los registros de la tabla habitacion y los ordena por id
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);///obtiene la consulta de la base de datos
            
            while(rs.next()){
                registro[0]=rs.getString("idhabitacion");
                registro[1]=rs.getString("numero");
                registro[2]=rs.getString("piso");
                registro[3]=rs.getString("descripcion");
                registro[4]=rs.getString("caracteristicas");
                registro[5]=rs.getString("precio_diario");
                registro[6]=rs.getString("estado");
                registro[7]=rs.getString("tipo_habitacion");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       }
       
       public DefaultTableModel  mostrarvista(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID", "Numero", "piso","Descripcion","Caracteristicas", "Precio", "Estado", "Tipo Habitacion"};///variable de los totilos de la tabla
        String [] registro=new String [8];//vector en el cual se almacenara el numero total de registros.
        totalregistros=0;///se inicializa la variable total de registros.
        modelo=new DefaultTableModel(null, titulos);//se le pasan dos parametros null y titulos para que lo vaya colocando cada vez que se inicialicen
        
        sSQL="Select * from habitacion where piso like '%"+buscar+"%' and estado='Disponible' order by idhabitacion"; //obtiene los registros de la tabla habitacion y los ordena por id
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);///obtiene la consulta de la base de datos
            
            while(rs.next()){
                registro[0]=rs.getString("idhabitacion");
                registro[1]=rs.getString("numero");
                registro[2]=rs.getString("piso");
                registro[3]=rs.getString("descripcion");
                registro[4]=rs.getString("caracteristicas");
                registro[5]=rs.getString("precio_diario");
                registro[6]=rs.getString("estado");
                registro[7]=rs.getString("tipo_habitacion");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       }
       
       public boolean Insertar(vhabitacion dts)
       {
           sSQL="insert into habitacion (numero, piso, descripcion, caracteristicas, precio_diario, estado, tipo_habitacion)"+
                   "values(?,?,?,?,?,?,?)";
           try {
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setString(1, dts.getNumero());
               pst.setString(2, dts.getPiso());
               pst.setString(3, dts.getDescripcion());
               pst.setString(4, dts.getCaracteristicas());
               pst.setDouble(5, dts.getPrecio_diario());
               pst.setString(6, dts.getEstado());
               pst.setString(7, dts.getTipo_habitacion());
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
       
       public boolean Editar(vhabitacion dts)
       {
           sSQL="update habitacion set numero=?, piso=?, descripcion=?, caracteristicas=?, precio_diario=?, estado=?, tipo_habitacion"+
                   "where idhabitacion=?";
           try {
               
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setString(1, dts.getNumero());
               pst.setString(2, dts.getPiso());
               pst.setString(3, dts.getDescripcion());
               pst.setString(4, dts.getCaracteristicas());
               pst.setDouble(5, dts.getPrecio_diario());
               pst.setString(6, dts.getEstado());
               pst.setString(7, dts.getTipo_habitacion());
               pst.setInt(8, dts.getIdhabitacion());
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
       
       
        public boolean desocupar(vhabitacion dts)
       {
           sSQL="update habitacion set estado='Disponible'"+
                   "where idhabitacion=?";
           try {
               
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setInt(1, dts.getIdhabitacion());
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
       
             
       
       public boolean Eliminar(vhabitacion dts)
       {
           sSQL="delete from habitacion where idhabitacion=?";
           try {
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setInt(1, dts.getIdhabitacion());
               
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

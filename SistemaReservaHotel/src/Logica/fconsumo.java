package Logica;

import Datos.vconsumo;
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
public class fconsumo {
    
     private Conexion mysql=new Conexion();//instancia de la  cadena de conexion.
    private Connection cn=mysql.Conectar();//variable de para enlazar con el metodo conectar.
    private String sSQL;///variable de conexion, obtiene los datos de la base de datos
    public Integer totalregistros;//va acontar el numero total de registros
    public Double totalconsumo;
    ///metodo en el cual se va a manejar la tabla para poder mostrar los datos, se manejaran dos vectores uno sera las filas y el otro las columnas

       public DefaultTableModel  mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID", "Producto", "idreserva","idproducto","producto","cantidad","Precio Venta","Estado"};///variable de los totilos de la tabla
        String [] registro=new String [7];//vector en el cual se almacenara el numero total de registros.
        totalregistros=0;///se inicializa la variable total de registros.
        totalconsumo=0.0;
        modelo=new DefaultTableModel(null, titulos);//se le pasan dos parametros null y titulos para que lo vaya colocando cada vez que se inicialicen
        
        sSQL="Select c.idconsumo,c.idreserva,c.idproducto,p.nombre,c.cantidad,c.precio_venta,"
                + "c.estado from consumo c inner join producto p on c.idproducto=p.idproducto"+
                "where c.idreserva="+buscar+"order by c.idconsumo desc"; //obtiene los registros de la tabla habitacion y los ordena por id
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);///obtiene la consulta de la base de datos
            
            while(rs.next()){
                registro[0]=rs.getString("idconsumo");
                registro[1]=rs.getString("idreserva");
                registro[2]=rs.getString("idproducto");
                registro[3]=rs.getString("nombre");
                registro[4]=rs.getString("cantidad");
                registro[5]=rs.getString("precio_venta");
                registro[6]=rs.getString("estado");
                
                totalregistros=totalregistros+1;///este es el contador que aparece en la parte derecha inferior de la tabla.
                totalconsumo=totalconsumo+(rs.getDouble("cantidad")*rs.getDouble("precio venta"));
                modelo.addRow(registro);
                
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       }
       
       public boolean Insertar(vconsumo dts)
       {
           sSQL="insert into consumo (idreserva,idproducto,cantidad,precio_venta,estado)"+
                   "values(?,?,?,?,?)";
           try {
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setInt(1, dts.getIdreserva());
               pst.setInt(2, dts.getIdproducto());
               pst.setDouble(3, dts.getCantidad());
               pst.setDouble(4, dts.getPrecio_venta());
               pst.setString(5,dts.getEstado());
               
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
       
       public boolean Editar(vconsumo dts)
       {
           sSQL="update consumo set idreserva=?, idproducto=?, cantidad=?, precio_venta=?,estado=?"+
                   "where idconsumo=?";
           try {
               
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setInt(1, dts.getIdreserva());
               pst.setInt(2, dts.getIdproducto());
               pst.setDouble(3, dts.getCantidad());
               pst.setDouble(4, dts.getPrecio_venta());
               pst.setString(5,dts.getEstado());
               
               
              pst.setInt(6,dts.getIdconsumo());
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
       public boolean Eliminar(vconsumo dts)
       {
           sSQL="delete from consumo where idconsumo=?";
           try {
               PreparedStatement pst=cn.prepareStatement(sSQL);
               pst.setInt(1, dts.getIdconsumo());
               
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

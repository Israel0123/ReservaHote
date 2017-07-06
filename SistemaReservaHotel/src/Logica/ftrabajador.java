/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.vtrabajador;
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
public class ftrabajador {

    private Conexion mysql = new Conexion();//instancia de la  cadena de conexion.
    private Connection cn = mysql.Conectar();//variable de para enlazar con el metodo conectar.
    private String sSQL;///variable de conexion, obtiene los datos de la base de datos
    private String sSQL2;
    public Integer totalregistros;//va acontar el numero total de registros

    ///metodo en el cual se va a manejar la tabla para poder mostrar los datos, se manejaran dos vectores uno sera las filas y el otro las columnas
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno", "Doc", "Numero Documento", "Direccion", "Telefono", "Email", "Sueldo","Acceso","Login","Clave","Estado"};///variable de los totilos de la tabla
        String[] registro = new String[14];//vector en el cual se almacenara el numero total de registros.
        totalregistros = 0;///se inicializa la variable total de registros.
        modelo = new DefaultTableModel(null, titulos);//se le pasan dos parametros null y titulos para que lo vaya colocando cada vez que se inicialicen

        
        //esta opcion fue la que me funciono ya que el join lo realizaba en la misma linea
        sSQL="select p.idpersona, p.nombre, p.apaterno,p.amaterno, p.tipo_documento, p.num_documento,"+
                "p.direccion, p.telefono, p.email,t.sueldo,t.acceso,t.login,t.password,t.estado from persona p inner join trabajador t on p.idpersona=t.idpersona where num_documento like'%"
                +buscar+"%' order by idpersona desc";
        
        /*estas es la opcion del video pero no me funciono.
        sSQL = "select p.idpersona, p.nombre, p.apaterno, p.amaterno, p.tipo_documento, p.num_documento,"+
                "p.direccion, p.telefono, p.email, c.codigo_cliente from persona p inner join cliente c"+
                "on p.idpersona=c.idpersona where num_documento like '%"+
                buscar+"%' order by idpersona desc"; //obtiene los registros de la tabla habitacion y los ordena por id
        */

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);///obtiene la consulta de la base de datos

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                registro[4] = rs.getString("tipo_documento");
                registro[5] = rs.getString("num_documento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("sueldo");
                registro[10] = rs.getString("acceso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("password");
                registro[13] = rs.getString("estado");
                totalregistros = totalregistros + 1;///este es el contador que aparece en la parte derecha inferior de la tabla.
                modelo.addRow(registro);

            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean Insertar(vtrabajador dts) {
        sSQL = "insert into persona (nombre, apaterno, amaterno,tipo_documento, num_documento, direccion, telefono, email)"
                + "values(?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into trabajador (idpersona,sueldo, acceso, login,password,estado)"
                + "values((select idpersona from persona order by idpersona desc limit 1),?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());

            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;////si esta vacio regrresa un valor falso
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"este es un mensje");
            JOptionPane.showConfirmDialog(null, e);///si se produce una excepcion se captura la excepcion
            return false;///se regresa un valor falso en caso de que se ejecute la excepcion
        }

    }

    public boolean Editar(vtrabajador dts) {
        sSQL = "update persona set nombre=?, apaterno=?, amaterno=?, tipo_documento=?,num_documento=?,"
                +"direccion=?,telefono=?,email=? where idpersona=?";
        
        sSQL2 = "update trabajador set sueldo=?, acceso=?, login=?, password=?, estado=?"
                + "where idpersona=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());
            pst.setInt(9, dts.getIdpersona());

            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());
            pst2.setInt(6, dts.getIdpersona());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;////si esta vacio regrresa un valor falso
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"este es un mensje 2");
            JOptionPane.showConfirmDialog(null, e);///si se produce una excepcion se captura la excepcion
            return false;///se regresa un valor falso en caso de que se ejecute la excepcion
        }

    }

    public boolean Eliminar(vtrabajador dts) {
        sSQL = "delete from trabajador where idpersona=?";
        sSQL2= "delete from persona where idpersona=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            
            pst.setInt(1, dts.getIdpersona());
            pst2.setInt(1, dts.getIdpersona());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;////si esta vacio regrresa un valor falso
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);///si se produce una excepcion se captura la excepcion
            return false;///se regresa un valor falso en caso de que se ejecute la excepcion
        }

    }
    
    public DefaultTableModel Login(String login, String password) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno","Acceso","Login","Clave","Estado"};///variable de los totilos de la tabla
        String[] registro = new String[8];//vector en el cual se almacenara el numero total de registros.
        totalregistros = 0;///se inicializa la variable total de registros.
        modelo = new DefaultTableModel(null, titulos);//se le pasan dos parametros null y titulos para que lo vaya colocando cada vez que se inicialicen

        
        sSQL="select p.idpersona, p.nombre,p.nombre, p.apaterno, p.amaterno,"
                +"t.acceso,t.login,t.password,t.estado from persona p inner join trabajador t on p.idpersona=t.idpersona where t.login='"
                +login+"'and t.password='"+password+"'and t.estado='A'";
        //esta opcion fue la que me funciono ya que el join lo realizaba en la misma linea
        /*sSQL="select p.idpersona, p.nombre, p.apaterno,p.amaterno, "+
                "t.acceso,t.login,t.password,t.estado from persona p inner join trabajador t on p.idpersona=t.idpersona where t.login='"
                +login+"' and t.password'"+password+"'and t.estado=A'";
        */
        
        /*estas es la opcion del video pero no me funciono.
        sSQL = "select p.idpersona, p.nombre, p.apaterno, p.amaterno, p.tipo_documento, p.num_documento,"+
                "p.direccion, p.telefono, p.email, c.codigo_cliente from persona p inner join cliente c"+
                "on p.idpersona=c.idpersona where num_documento like '%"+
                buscar+"%' order by idpersona desc"; //obtiene los registros de la tabla habitacion y los ordena por id
        */

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);///obtiene la consulta de la base de datos

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                registro[4] = rs.getString("acceso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                registro[7] = rs.getString("estado");
                totalregistros = totalregistros + 1;///este es el contador que aparece en la parte derecha inferior de la tabla.
                modelo.addRow(registro);

            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
}

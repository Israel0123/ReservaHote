/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;


public class vpago {
    
    private int pago;
    private int idreserva;
    private String tipo_comprobante;
    private String num_comprobante;
    private Double igv;
    private Double total_pago;
    private Date fecha_emision;
    private Date fecha_pago;

    public vpago() {
    }

    public vpago(int pago, int idreserva, String tipo_comprobante, String num_comprobante, Double igv, Double total_pago, Date fecha_emision, Date fecha_pago) {
        this.pago = pago;
        this.idreserva = idreserva;
        this.tipo_comprobante = tipo_comprobante;
        this.num_comprobante = num_comprobante;
        this.igv = igv;
        this.total_pago = total_pago;
        this.fecha_emision = fecha_emision;
        this.fecha_pago = fecha_pago;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getTipo_comprobante() {
        return tipo_comprobante;
    }

    public void setTipo_comprobante(String tipo_comprobante) {
        this.tipo_comprobante = tipo_comprobante;
    }

    public String getNum_comprobante() {
        return num_comprobante;
    }

    public void setNum_comprobante(String num_comprobante) {
        this.num_comprobante = num_comprobante;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotal_pago() {
        return total_pago;
    }

    public void setTotal_pago(Double total_pago) {
        this.total_pago = total_pago;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    
    
    
    
}

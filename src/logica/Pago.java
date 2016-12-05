/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package logica;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */

//Le damos un nombre a la clase
public class Pago
{
        private int k_idpago;
        private String n_formapago;
        private Date f_pago; //fecha
        private int k_idcuota;
        private int q_valorpagado;
	
        private ArrayList k_idpagoArray = new ArrayList();
        private ArrayList n_formapagoArray = new ArrayList();
        private ArrayList f_pagoArray = new ArrayList();
        private ArrayList k_idcuotaArray = new ArrayList();
        
    public int getK_idpago() {
        return k_idpago;
    }

    public void setK_idpago(int k_idpago) {
        this.k_idpago = k_idpago;
    }

    public String getN_formapago() {
        return n_formapago;
    }

    public void setN_formapago(String n_formapago) {
        this.n_formapago = n_formapago;
    }

    public Date getF_pago() {
        return f_pago;
    }

    public void setF_pago(Date f_pago) {
        this.f_pago = f_pago;
    }

    public int getK_idcuota() {
        return k_idcuota;
    }

    public void setK_idcuota(int k_idcuota) {
        this.k_idcuota = k_idcuota;
    }

    public int getQ_valorpagado() {
        return q_valorpagado;
    }

    public void setQ_valorpagado(int q_valorpagado) {
        this.q_valorpagado = q_valorpagado;
    }

    public ArrayList getK_idpagoArray() {
        return k_idpagoArray;
    }

    public void setK_idpagoArray(ArrayList k_idpagoArray) {
        this.k_idpagoArray = k_idpagoArray;
    }

    public ArrayList getN_formapagoArray() {
        return n_formapagoArray;
    }

    public void setN_formapagoArray(ArrayList n_formapagoArray) {
        this.n_formapagoArray = n_formapagoArray;
    }

    public ArrayList getF_pagoArray() {
        return f_pagoArray;
    }

    public void setF_pagoArray(ArrayList f_pagoArray) {
        this.f_pagoArray = f_pagoArray;
    }

    public ArrayList getK_idcuotaArray() {
        return k_idcuotaArray;
    }

    //Atributos de la clase
    public void setK_idcuotaArray(ArrayList k_idcuotaArray) {
        this.k_idcuotaArray = k_idcuotaArray;
    }
	

       
}
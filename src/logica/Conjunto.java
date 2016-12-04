/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author SEBASTIAN
 */
public class Conjunto {
    
    //Atributos de la clase
    private int k_codigo;
    private String n_nombre;
    private int v_mensual;
    private float t_descuento;
    private int q_cuentabancaria;
    private int q_diasdescuento;
    private float t_mora;
	
    //Constructor con el mismo nombre de la clase
    public Conjunto(){}
    
    public Conjunto(int k_codigo){
        this.k_codigo = k_codigo;
    }
    
    //Constructor 
    public Conjunto(int k_codigo,String n_nombre,int v_mensual,float t_descuento,int q_cuentabancaria,int q_diasdescuento,float t_mora){
        this.k_codigo = k_codigo;
        this.n_nombre = n_nombre;
        this.v_mensual = v_mensual;
        this.t_descuento = t_descuento;
        this.q_cuentabancaria = q_cuentabancaria;
        this.q_diasdescuento = q_diasdescuento;
        this.t_mora = t_mora;
    }
    
    /*
        Metodos Get/Set
    */
    public int getK_codigo() {
        return k_codigo;
    }

    public void setK_codigo(int k_codigo) {
        this.k_codigo = k_codigo;
    }

    public String getN_nombre() {
        return n_nombre;
    }

    public void setN_nombre(String n_nombre) {
        this.n_nombre = n_nombre;
    }

    public int getV_mensual() {
        return v_mensual;
    }

    public void setV_mensual(int v_mensual) {
        this.v_mensual = v_mensual;
    }

    public float getT_descuento() {
        return t_descuento;
    }

    public void setT_descuento(float t_descuento) {
        this.t_descuento = t_descuento;
    }

    public int getQ_cuentabancaria() {
        return q_cuentabancaria;
    }

    public void setQ_cuentabancaria(int q_cuentabancaria) {
        this.q_cuentabancaria = q_cuentabancaria;
    }

    public int getQ_diasdescuento() {
        return q_diasdescuento;
    }

    public void setQ_diasdescuento(int q_diasdescuento) {
        this.q_diasdescuento = q_diasdescuento;
    }

    public float getT_mora() {
        return t_mora;
    }

    public void setT_mora(float t_mora) {
        this.t_mora = t_mora;
    }
    
}

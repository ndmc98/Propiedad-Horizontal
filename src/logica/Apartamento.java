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
public class Apartamento {

    //Atributos de la clase
    private int k_idapartamento;
    private int q_area;
    private int q_piso;
    private float t_coeficiente;
    private long k_identificacion;
    private int k_idbloque;
    
    //Constructor con el mismo nombre de la clase
    public Apartamento() {
    }

    public Apartamento(int k_idapartamento,int q_area,int q_piso,float t_coeficiente,long k_identificacion,int k_idbloque){
        this.k_idapartamento = k_idapartamento;
        this.q_area = q_area;
        this.q_piso = q_piso;
        this.t_coeficiente = t_coeficiente;
        this.k_identificacion = k_identificacion;
        this.k_idbloque = k_idbloque;
    }
    
    /*
        Metodos Get/Set
    */
    public int getK_idapartamento() {
        return k_idapartamento;
    }

    public void setK_idapartamento(int k_idapartamento) {
        this.k_idapartamento = k_idapartamento;
    }

    public int getQ_area() {
        return q_area;
    }

    public void setQ_area(int q_area) {
        this.q_area = q_area;
    }

    public int getQ_piso() {
        return q_piso;
    }

    public void setQ_piso(int q_piso) {
        this.q_piso = q_piso;
    }

    public float getT_coeficiente() {
        return t_coeficiente;
    }

    public void setT_coeficiente(float t_coeficiente) {
        this.t_coeficiente = t_coeficiente;
    }

    public long getK_identificacion() {
        return k_identificacion;
    }

    public void setK_identificacion(long k_identificacion) {
        this.k_identificacion = k_identificacion;
    }

    public int getK_idbloque() {
        return k_idbloque;
    }

    public void setK_idbloque(int k_idbloque) {
        this.k_idbloque = k_idbloque;
    }
    
    
}

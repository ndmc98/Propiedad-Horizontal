/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Daniel
 */
public class Bloque {
    
    //Atributos de la clase
    private int k_idbloque;
    private int k_codigo;

    //Constructor con el mismo nombre de la clase
    public Bloque() {}
    
    public Bloque(int k_idbloque,int k_codigo){
        this.k_idbloque = k_idbloque;
        this.k_codigo = k_codigo;
    }

    /*
        Metodos Get/Set
    */
    public int getK_idbloque() {
        return k_idbloque;
    }

    public void setK_idbloque(int k_idbloque) {
        this.k_idbloque = k_idbloque;
    }

    public int getK_codigo() {
        return k_codigo;
    }

    public void setK_codigo(int k_codigo) {
        this.k_codigo = k_codigo;
    }
    
}

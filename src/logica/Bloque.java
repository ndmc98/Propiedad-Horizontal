package logica;

/**
 *
 * @author
 */
public class Bloque {

    // Atributos de la clase
    private int k_idbloque;
    private int k_codigo;

    // Constructores
    public Bloque() {
    }

    public Bloque(int k_idbloque, int k_codigo) {
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

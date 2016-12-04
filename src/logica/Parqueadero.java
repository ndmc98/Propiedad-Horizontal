package logica;

/**
 *
 * @author
 */
public class Parqueadero {

    // Atributos de la clase
    private int k_idparqueadero;
    private int k_idapartamento;

    // Constructores
    public Parqueadero() {
    }

    public Parqueadero(int idparqueadero, int idapartamento) {
        this.k_idparqueadero = idparqueadero;
        this.k_idapartamento = idapartamento;
    }

    /*
        Metodos Get/Set
     */
    public int getK_idparqueadero() {
        return k_idparqueadero;
    }

    public void setK_idparqueadero(int k_idparqueadero) {
        this.k_idparqueadero = k_idparqueadero;
    }

    public int getK_idapartamento() {
        return k_idapartamento;
    }

    public void setK_idapartamento(int k_idapartamento) {
        this.k_idapartamento = k_idapartamento;
    }

}

package logica;

/**
 *
 * @author
 */
public class EspacioComun {
    // Atributos de la clase

    private int k_idespaciocomun;
    private String n_tipo;
    private Long v_alquiler;
    private int k_codigo;
    private String i_estadoEspacio;

    // Constructores
    public EspacioComun() {
    }

    public EspacioComun(int k_idespaciocomun, String n_tipo, Long v_alquiler, int k_codigo, String i_estadoEspacio) {
        this.k_idespaciocomun = k_idespaciocomun;
        this.n_tipo = n_tipo;
        this.v_alquiler = v_alquiler;
        this.k_codigo = k_codigo;
        this.i_estadoEspacio = i_estadoEspacio;
    }

    /*
        Metodos Get/Set
     */
    public String getI_estadoEspacio() {
        return i_estadoEspacio;
    }

    public void setI_estadoEspacio(String i_estadoEspacio) {
        this.i_estadoEspacio = i_estadoEspacio;
    }

    public int getK_idespaciocomun() {
        return k_idespaciocomun;
    }

    public void setK_idespaciocomun(int k_idespaciocomun) {
        this.k_idespaciocomun = k_idespaciocomun;
    }

    public String getN_tipo() {
        return n_tipo;
    }

    public void setN_tipo(String n_tipo) {
        this.n_tipo = n_tipo;
    }

    public long getV_alquiler() {
        return v_alquiler;
    }

    public void setV_alquiler(long v_alquiler) {
        this.v_alquiler = v_alquiler;
    }

    public int getK_codigo() {
        return k_codigo;
    }

    public void setK_codigo(int k_codigo) {
        this.k_codigo = k_codigo;
    }

}

package logica;

import java.sql.Date;

/**
 *
 * @author
 */
public class PagoEspacio {

    // Atributos de la clase
    private int k_idpagoespacio;
    private Date f_pagoec;
    private Long q_valorpagado;
    private String n_formapago;
    private int k_idreserva;

    // Constructores
    public PagoEspacio() {
    }
    
    public PagoEspacio(int k_idpagoespacio, Date f_pagoec, Long q_valorpagado, String n_formapago, int k_idreserva) {
        this.k_idpagoespacio = k_idpagoespacio;
        this.f_pagoec = f_pagoec;
        this.q_valorpagado = q_valorpagado;
        this.n_formapago = n_formapago;
        this.k_idreserva = k_idreserva;
    }

    /*
        Metodos Get and Set
     */
    public int getK_idpagoespacio() {
        return k_idpagoespacio;
    }

    public void setK_idpagoespacio(int k_idpagoespacio) {
        this.k_idpagoespacio = k_idpagoespacio;
    }

    public Date getF_pagoec() {
        return f_pagoec;
    }

    public void setF_pagoec(Date f_pagoec) {
        this.f_pagoec = f_pagoec;
    }

    public int getK_idreserva() {
        return k_idreserva;
    }

    public void setK_idreserva(int k_idreserva) {
        this.k_idreserva = k_idreserva;
    }

    public Long getQ_valorpagado() {
        return q_valorpagado;
    }

    public void setQ_valorpagado(Long q_valorpagado) {
        this.q_valorpagado = q_valorpagado;
    }

    public String getN_formapago() {
        return n_formapago;
    }

    public void setN_formapago(String n_formapago) {
        this.n_formapago = n_formapago;
    }

}

package logica;

import java.sql.Date;

/**
 *
 * @author
 */
public class Reserva {

    // Atributos de la clase
    private int k_idreserva;
    private Date f_fin;
    private Date f_inicio;
    private Long k_identificacion;
    private int k_idespaciocomun;

    // Constructores
    public Reserva() {
    }

    @SuppressWarnings("SillyAssignment")
    public Reserva(int k_idreserva, Date f_fin, Date f_inicio, Long K_identificacion, int k_idespaciocomun) {
        this.k_idreserva = k_idreserva;
        this.f_fin = f_fin;
        this.f_inicio = f_inicio;
        this.k_identificacion = k_identificacion;
        this.k_idespaciocomun = k_idespaciocomun;
    }

    public Reserva(int k_idreserva) {
        this.k_idreserva = k_idreserva;
    }
    
    public Reserva(Date f_fin, Date f_inicio, Integer k_idespaciocomun) {
        this.f_fin = f_fin;
        this.f_inicio = f_inicio;
        this.k_idespaciocomun = k_idespaciocomun;
    }
    
    /*
        Metodos Get/Set
     */
    public Long getK_identificacion() {
        return k_identificacion;
    }

    public void setK_identificacion(Long k_identificacion) {
        this.k_identificacion = k_identificacion;
    }

    public int getK_idreserva() {
        return k_idreserva;
    }

    public void setK_idreserva(int k_idreserva) {
        this.k_idreserva = k_idreserva;
    }

    public Date getF_fin() {
        return f_fin;
    }

    public void setF_fin(Date f_fin) {
        this.f_fin = f_fin;
    }

    public Date getF_inicio() {
        return f_inicio;
    }

    public void setF_inicio(Date f_inicio) {
        this.f_inicio = f_inicio;
    }

    public int getK_idespaciocomun() {
        return k_idespaciocomun;
    }

    public void setK_idespaciocomun(int k_idespaciocomun) {
        this.k_idespaciocomun = k_idespaciocomun;
    }

}

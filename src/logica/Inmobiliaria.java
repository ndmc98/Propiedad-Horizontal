package logica;

import datos.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import util.CaException;

/**
 *
 * @author
 */
public class Inmobiliaria {

    private final ConjuntoDAO conjuntoDAO;
    private final BloqueDAO bloqueDAO;
    private final ApartamentoDAO apartamentoDAO;
    private final ParqueaderoDAO parqueaderoDAO;
    private final EspacioComunDAO espacioDAO;
    private final ReservaDAO reservaDAO;

    public Inmobiliaria() {
        conjuntoDAO = new ConjuntoDAO();
        bloqueDAO = new BloqueDAO();
        apartamentoDAO = new ApartamentoDAO();
        parqueaderoDAO = new ParqueaderoDAO();
        espacioDAO = new EspacioComunDAO();
        reservaDAO = new ReservaDAO();
    }

    /*
        Bloque
     */
    public void incluirBloque(Bloque bloque) throws CaException {
        bloqueDAO.setBloque(bloque);
        bloqueDAO.incluirBloque();
    }

    public Bloque buscarBloque(Bloque bloque) throws CaException {
        bloqueDAO.setBloque(bloque);
        bloqueDAO.buscarBloque();
        return bloqueDAO.getBloque();
    }

    public BloqueDAO getBloqueDAO() {
        return bloqueDAO;
    }

    public boolean sinBloques() throws CaException {
        return bloqueDAO.isVacio() == 0;
    }

    public JComboBox<String> listaBloques(int k_codigo) throws CaException {
        return bloqueDAO.listarBloques(k_codigo);
    }

    /*
        Conjunto
     */
    public void incluirConjunto(Conjunto conjunto) throws CaException {
        conjuntoDAO.setConjunto(conjunto);
        conjuntoDAO.incluirConjunto();
    }

    public Conjunto buscarConjunto(Conjunto conjunto) throws CaException {
        conjuntoDAO.setConjunto(conjunto);
        conjuntoDAO.buscarConjunto();
        return conjuntoDAO.getConjunto();
    }

    public ConjuntoDAO getConjuntoDAO() {
        return conjuntoDAO;
    }

    public JComboBox<String> listaConjuntos() throws CaException {
        return conjuntoDAO.listarConjuntos();
    }

    /*
       Apartamento
     */
    public void incluirApartamento(Apartamento apartamento) throws CaException {
        apartamentoDAO.setApartamento(apartamento);
        apartamentoDAO.incluirApartamento();
    }

    public Apartamento buscarApartamento(Apartamento apartamento) throws CaException {
        apartamentoDAO.setApartamento(apartamento);
        apartamentoDAO.buscarApartamento();
        return apartamentoDAO.getApartamento();
    }

    public ApartamentoDAO getApartamentoDAO() {
        return apartamentoDAO;
    }

    /*
       Parqueadero
     */
    public void incluirParqueadero(Parqueadero parqueadero) throws CaException {
        parqueaderoDAO.setParqueadero(parqueadero);
        parqueaderoDAO.incluirParqueadero();
    }

    public Parqueadero buscarParqueadero(Parqueadero parqueadero) throws CaException {
        parqueaderoDAO.setParqueadero(parqueadero);
        parqueaderoDAO.buscarParqueadero();
        return parqueaderoDAO.getParqueadero();
    }

    public ParqueaderoDAO getParqueaderoDAO() {
        return parqueaderoDAO;
    }

    public JComboBox<String> listaEspacios(int k_idbloquee, int k_codigo) throws CaException {
        return apartamentoDAO.listarApartamento(k_idbloquee, k_codigo);
    }

    /*
       Espacio Comun
     */
    public void incluirEspacioComun(EspacioComun espacio) throws CaException {
        espacioDAO.setEspacioComun(espacio);
        espacioDAO.incluirEspacioComun();
    }

    public EspacioComun buscarEspacioComun(EspacioComun espacio) throws CaException {
        espacioDAO.setEspacioComun(espacio);
        espacioDAO.buscarEspacioComun();
        return espacioDAO.getEspacioComun();
    }

    public EspacioComunDAO getEspacioComunDAO() {
        return espacioDAO;
    }

    public JComboBox<String> listaEspacios(int k_codigo) throws CaException {
        return espacioDAO.listarEspacioComun(k_codigo);
    }

    public DefaultTableModel tableEspacios() throws CaException {
        return espacioDAO.buscarTableEC();
    }

    /*
       Reserva
     */
    public void incluirReserva(Reserva reserva) throws CaException {
        reservaDAO.setReserva(reserva);
        reservaDAO.incluirReserva();
    }

    public Reserva buscarReserva(Reserva reserva) throws CaException {
        reservaDAO.setReserva(reserva);
        reservaDAO.buscarReserva();
        return reservaDAO.getReserva();
    }

    public ReservaDAO getReservaDAO() {
        return reservaDAO;
    }

    public int busquedaId(Long k_identificacion, int k_codigo) throws CaException {
        return reservaDAO.buscarIdPersona(k_identificacion, k_codigo);
    }

}

package datos;

import logica.PagoEspacio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author
 */
public class PagoEspacioDAO {

    private PagoEspacio pagoespacio;

    /*
     * Constructor de la clase
     */
    public PagoEspacioDAO() {
        pagoespacio = new PagoEspacio();
    }

    /**
     * Incluye una nueva fila en la tabla Pago Espacio.
     *
     * @throws CaException
     */
    public void incluirPagoEspacio() throws CaException {
        try {
            String strSQL = "INSERT INTO PagoEspacio (k_idpagoespacio, f_pagoec, q_valorpagado, n_formapago, k_idreserva) VALUES(?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt;
            prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, pagoespacio.getK_idpagoespacio());
            prepStmt.setDate(2, pagoespacio.getF_pagoec());
            prepStmt.setLong(3, pagoespacio.getQ_valorpagado());
            prepStmt.setString(4, pagoespacio.getN_formapago());
            prepStmt.setInt(5, pagoespacio.getK_idreserva());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PagoEspacioDAO", "No pudo crear el Pago Espacio " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    /**
     * Busqueda en la tabla Pago Espacio.
     *
     * @throws CaException
     */
    public void buscarPagoEspacio() throws CaException {
        try {
            String strSQL = "SELECT k_idpagoespacio, f_pagoec, q_valorpagado, n_formapago, k_idreserva FROM PagoEspacio WHERE k_idpagoespacio = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, pagoespacio.getK_idpagoespacio());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                pagoespacio.setK_idpagoespacio(rs.getInt(1));
                pagoespacio.setF_pagoec(rs.getDate(2));
                pagoespacio.setQ_valorpagado(rs.getLong(3));
                pagoespacio.setN_formapago(rs.getString(4));
                pagoespacio.setK_idreserva(rs.getInt(5));
            }
        } catch (SQLException e) {
            throw new CaException("PagoEspacioDAO", "No pudo recuperar el Pago Espacio " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }

    /**
     * verifica la existencia de una reserva.
     *
     * @param k_idreserva
     * @param k_codigo
     * @return int
     * @throws CaException
     */
    public int buscarNumReserva(Integer k_idreserva, int k_codigo) throws CaException {
        try {
            int encontrado = 0;
            String strSQL = "SELECT r.k_idreserva FROM Reserva r, EspacioComun ec, Conjunto c WHERE r.k_idespaciocomun = ec.k_idespaciocomun AND ec.k_codigo = c.k_codigo AND c.k_codigo = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, k_codigo);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                if (k_idreserva.equals(rs.getInt(1))) {
                    encontrado = 1;
                    break;
                } else {
                    encontrado = 0;
                }
            }
            return encontrado;
        } catch (SQLException e) {
            throw new CaException("Apartamento", "No pudo encontrar el Apartamento " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    /**
     * Actualiza la tabla Pago Espacio.
     *
     * @throws CaException
     */
    public void actualizarPagoEspacio() throws CaException {

    }

    /**
     * Elmina un registrpo de Pago Espacio.
     *
     * @throws CaException
     */
    public void eliminarPagoEspacio() throws CaException {

    }

    /*
        Metodos Get and Set
     */
    public void setPagoEspacio(PagoEspacio pagoespacio) {
        this.pagoespacio = pagoespacio;
    }

    public PagoEspacio getPagoEspacio() {
        return pagoespacio;
    }

}

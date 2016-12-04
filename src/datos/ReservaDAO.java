package datos;

import logica.Reserva;
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
public class ReservaDAO {

    private Reserva reserva;

    /*
     * Constructor de la clase
     */
    public ReservaDAO() {
        reserva = new Reserva();
    }

    /**
     * Incluye una nueva fila en la tabla Reserva.
     *
     * @throws CaException
     */
    public void incluirReserva() throws CaException {
        try {
            String strSQL = "INSERT INTO Reserva (k_idreserva, f_fin, f_inicio, k_identificacion, k_idespaciocomun) VALUES(?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt;
            prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, reserva.getK_idreserva());
            prepStmt.setDate(2, reserva.getF_fin());
            prepStmt.setDate(3, reserva.getF_inicio());
            prepStmt.setLong(4, reserva.getK_identificacion());
            prepStmt.setInt(5, reserva.getK_idespaciocomun());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ReservaDAO", "No pudo crear la Reserva " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void eliminaReserva() throws CaException {
        try {
            String strSQL = "DELETE FROM Reserva r, PagoEspacio pe WHERE r.k_idreserva = pe.k_idreserva AND r.k_idreserva = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setInt(1, reserva.getK_idreserva());
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("Apartamento", "No pudo encontrar el Apartamento " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        
    }

    /**
     * Busqueda en la tabla Reserva.
     *
     * @throws CaException
     */
    public void buscarReserva() throws CaException {
        try {
            String strSQL = "SELECT k_idreserva, f_fin, f_inicio, k_identificacion, k_idespaciocomun FROM Reserva WHERE k_idreserva = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, reserva.getK_idreserva());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                reserva.setK_idreserva(rs.getInt(1));
                reserva.setF_fin(rs.getDate(2));
                reserva.setF_inicio(rs.getDate(3));
                reserva.setK_identificacion(rs.getLong(4));
                reserva.setK_idespaciocomun(rs.getInt(5));
            }
        } catch (SQLException e) {
            throw new CaException("ReservaDAO", "No pudo recuperar Reserva " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }

    /**
     * Busqueda de la persona que realizara la reserva.
     *
     * @param k_identificacion
     * @param k_codigo
     * @return int
     * @throws CaException
     */
    public int buscarIdPersona(Long k_identificacion, int k_codigo) throws CaException {
        try {
            int encontrado = 0;
            String strSQL = "SELECT p.k_identificacion FROM Persona p, Apartamento a, Bloquee b, Conjunto c WHERE p.k_idapartamento = a.k_idapartamento AND a.k_idbloquee = b.k_idbloquee AND b.k_codigo = c.k_codigo AND c.k_codigo = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, k_codigo);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                if (k_identificacion.equals(rs.getLong(1))) {
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

    /*
        Metodos Get/Set
     */
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Reserva getReserva() {
        return reserva;
    }
}

package datos;

import logica.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
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
     * @return 
     * @throws CaException
     */
    public DefaultTableModel buscarReserva() throws CaException {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            String strSQL = "SELECT k_idreserva AS \"Numero de Reserva\", f_inicio AS \"Fecha Inicio\", f_fin AS \"Fecha Fin\", k_identificacion AS \"Solicitante\" FROM Reserva r, EspacioComun ec, Conjunto c WHERE r.k_idespaciocomun = ep.k_idespaciocomun AND c.k_codigo = ec.k_codigo AND r.k_idespaciocomun = ? AND r.f_inicio between ? AND ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, reserva.getK_idespaciocomun());
            prepStmt.setDate(2, reserva.getF_inicio());
            prepStmt.setDate(3, reserva.getF_fin());
            ResultSet rs = prepStmt.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
            }
            while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            return modelo;
        } catch (SQLException e) {
            throw new CaException("EspacioComunDAO", "No pudo recuperar el Espacio Comun " + e.getMessage());
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

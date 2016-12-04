package datos;

import logica.Parqueadero;
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
public class ParqueaderoDAO {

    private Parqueadero parqueadero;

    /*
     * Constructor de la clase
     */
    public ParqueaderoDAO() {
        parqueadero = new Parqueadero();
    }

    /**
     * Incluye una nueva fila en la tabla Parqueadero.
     *
     * @throws CaException
     */
    public void incluirParqueadero() throws CaException {
        try {
            String strSQL = "INSERT INTO Parqueadero (k_idparqueadero, k_idapartamento) VALUES(?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt;
            prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, parqueadero.getK_idparqueadero());
            prepStmt.setInt(2, parqueadero.getK_idapartamento());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No pudo crear el Parqueadero " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    /**
     * Busqueda en la tabla Parqueadero.
     *
     * @throws CaException
     */
    public void buscarParqueadero() throws CaException {
        try {
            String strSQL = "SELECT k_idparqueadero, k_idapartamento FROM Parqueadero WHERE k_idparqueadero = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, parqueadero.getK_idparqueadero());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                parqueadero.setK_idparqueadero(rs.getInt(1));
                parqueadero.setK_idapartamento(rs.getInt(2));
            }
        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No pudo recuperar el Parqueadero " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }

    /*
        Metodos Get/Set
     */
    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

}

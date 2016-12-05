package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import logica.Bloque;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author
 */
public class BloqueDAO {

    private Bloque bloque;

    /*
     * Constructor de la clase
     */
    public BloqueDAO() {
        bloque = new Bloque();
    }

    /**
     * Verifica si esta vacia la tabla.
     *
     * @param k_codigo
     * @return int
     * @throws CaException
     */
    public int isVacio(Integer k_codigo) throws CaException {
        try {
            String strSQL = "SELECT * FROM Bloquee WHERE k_codigo = ? ";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, k_codigo);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            throw new CaException("Bloque", "No pudo encontrar el conjunto" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    /**
     * Lista los bloques.
     *
     * @param k_codigo
     * @return JComboBox
     * @throws CaException
     */
    public JComboBox<String> listarBloques(int k_codigo) throws CaException {
        try {
            final JComboBox<String> listaBloques = new JComboBox<>();
            String strSQL = "SELECT k_idbloquee FROM Bloquee where k_codigo = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, k_codigo);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                listaBloques.addItem(Integer.toString(rs.getInt(1)));
            }
            return listaBloques;
        } catch (SQLException e) {
            throw new CaException("Conjuntos", "No pudo encontrar el conjunto" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    /**
     * Incluye una nueva fila en la tabla.
     *
     * @throws CaException
     */
    public void incluirBloque() throws CaException {
        try {
            String strSQL = "INSERT INTO Bloquee (k_idbloquee,k_codigo) VALUES(?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                prepStmt.setInt(1, bloque.getK_idbloque());
                prepStmt.setInt(2, bloque.getK_codigo());
                prepStmt.executeUpdate();
            }
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("BloqueDAO", "No pudo crear el bloque" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    /**
     * Realiza busqueda en la tabla.
     *
     * @throws CaException
     */
    public void buscarBloque() throws CaException {
        try {
            String strSQL = "SELECT k_idbloquee,k_codigo FROM Bloquee WHERE k_idbloquee = ? and k_codigo = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, bloque.getK_idbloque());
            prepStmt.setInt(2, bloque.getK_codigo());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                bloque.setK_idbloque(rs.getInt(1));
                bloque.setK_codigo(rs.getInt(2));
            }
        } catch (SQLException e) {
            throw new CaException("BloqueDAO", "No pudo recuperar el Bloque " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void actualizarMunicipio() throws CaException {

    }

    /*
        Metodos Get/Set
     */
    public Bloque getBloque() {
        return bloque;
    }

    public void setBloque(Bloque bloque) {
        this.bloque = bloque;
    }

}

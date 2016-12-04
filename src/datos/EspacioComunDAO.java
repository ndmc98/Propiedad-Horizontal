package datos;

import logica.EspacioComun;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author
 */
public class EspacioComunDAO {

    private EspacioComun espaciocomun;

    /*
     * Constructor de la clase
     */
    public EspacioComunDAO() {
        espaciocomun = new EspacioComun();
    }

    /**
     * Lista Espacio Comun.
     *
     * @param k_codigo
     * @return JComboBox
     * @throws CaException
     */
    public JComboBox<String> listarEspacioComun(int k_codigo) throws CaException {
        try {
            final JComboBox<String> listaEspacios = new JComboBox<>();
            String strSQL = "SELECT ec.k_idespaciocomun FROM EspacioComun ec, Conjunto c WHERE c.k_codigo = ec.k_codigo AND c.k_codigo = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, k_codigo);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                listaEspacios.addItem(Integer.toString(rs.getInt(1)));
            }
            return listaEspacios;
        } catch (SQLException e) {
            throw new CaException("Espacio Comun", "No pudo encontrar el Espacio Comun " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    /**
     * Se genera un modelo para JTable de los Espacioa Comunes.
     *
     * @return DefaultTableModel
     * @throws CaException
     */
    public DefaultTableModel buscarTableEC() throws CaException {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            String strSQL = "SELECT k_idespaciocomun AS \"Numero del Espacio\", n_tipoEspacio AS \"Tipo\", v_alquiler AS \"valor Alquiler\", i_estadoEspacio AS \"Estado\" FROM EspacioComun";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
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
     * Incluye una nueva fila en la tabla Espacio Comun.
     *
     * @throws CaException
     */
    public void incluirEspacioComun() throws CaException {
        try {
            String strSQL = "INSERT INTO EspacioComun (k_idespaciocomun, n_tipoEspacio, v_alquiler, k_codigo, i_estadoEspacio) VALUES(?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt;
            prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, espaciocomun.getK_idespaciocomun());
            prepStmt.setString(2, espaciocomun.getN_tipo());
            prepStmt.setLong(3, espaciocomun.getV_alquiler());
            prepStmt.setInt(4, espaciocomun.getK_codigo());
            prepStmt.setString(5, espaciocomun.getI_estadoEspacio());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("EspacioComunDAO", "No pudo crear el Espacio Comun " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    /**
     * Busqueda en la tabla Espacio Comun.
     *
     * @throws CaException
     */
    public void buscarEspacioComun() throws CaException {
        try {
            String strSQL = "SELECT k_idespaciocomun, n_tipoEspacio, v_alquiler, k_codigo, i_estadoEspacio FROM EspacioComun WHERE k_idespaciocomun = ? ";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, espaciocomun.getK_idespaciocomun());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                espaciocomun.setK_idespaciocomun(rs.getInt(1));
                espaciocomun.setN_tipo(rs.getString(2));
                espaciocomun.setV_alquiler(rs.getLong(3));
                espaciocomun.setK_codigo(rs.getInt(4));
                espaciocomun.setI_estadoEspacio(rs.getString(5));
            }
        } catch (SQLException e) {
            throw new CaException("EspacioComunDAO", "No pudo recuperar el Espacio Comun " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }

    /**
     * Actualizar tabla Espacio Comun.
     *
     * @throws CaException
     */
    public void actualizarEspacioComun() throws CaException {

    }

    /*
        Metodos Get/Set
     */
    public void setEspacioComun(EspacioComun espacio) {
        this.espaciocomun = espacio;
    }

    public EspacioComun getEspacioComun() {
        return espaciocomun;
    }

}

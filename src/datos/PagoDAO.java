package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import logica.Apartamento;
import logica.Cuota;
import logica.Pago;
import static sun.rmi.transport.TransportConstants.Return;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author Daniel
 */
public class PagoDAO {

    private Pago pago;
    private Cuota cuota;
    private Apartamento apartamento;

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public Cuota getCuota() {
        return cuota;
    }

    /**
     * Constructor de la clase
     */
    public PagoDAO() {
        pago = new Pago();
        cuota=new Cuota();
        apartamento=new Apartamento();
        
    }

    /**
     * @throws CaException
     */
    
       
       
    public int buscarIdPago(Long k_identificacion, int k_codigo) throws CaException {
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
    
    
    public DefaultTableModel ConsultarTablaHistoricoPagos() throws CaException {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            String strSQL = "SELECT k_idpago AS \"Numero del pago\", n_formapago AS \"Forma\", f_pago AS \"Fecha\", q_valorpagado AS \"Valor Pagado\" FROM Pago";
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
            throw new CaException("PagoDAO", "No pudo recuperar el Pago " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }
    
 

    public void buscarCartera() throws CaException {
        try {
            String strSQL = "SELECT * FROM Pago";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            try (PreparedStatement prepStmt = conexion.prepareStatement(strSQL)) {
                ResultSet rs = prepStmt.executeQuery();
                while (rs.next()) {
                    pago.setK_idpago(rs.getInt(1));
                    pago.setN_formapago(rs.getString(2));
                    pago.setF_pago(rs.getDate(3));
                    pago.setK_idcuota(rs.getInt(4));
                    pago.setQ_valorpagado(rs.getInt(5));
                }
            }
        } catch (SQLException e) {
            throw new CaException("PagoDAO", "No pudo recuperar los pagos\n " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

}

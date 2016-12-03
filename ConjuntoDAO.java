/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import logica.Conjunto;

import oracle.jdbc.driver.OracleConnection;

import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author SEBASTIAN
 */
public class ConjuntoDAO {

    private Conjunto conjunto;

    /*
     * Constructor de la clase
     */
    public ConjuntoDAO() {
        conjunto = new Conjunto();
    }

    public JComboBox<String> listarConjuntos() throws CaException {
        try {
            final JComboBox<String> listaConjuntos = new JComboBox<String>();
            String strSQL = "SELECT k_codigo FROM Conjunto";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                listaConjuntos.addItem(Integer.toString(rs.getInt(1)));
            }
            return listaConjuntos;
        } catch (SQLException e) {
            throw new CaException("Conjuntos", "No pudo encontrar el conjunto" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    /**
     * Incluye una nueva fila en la tabla.
     * @throws CaException
     */
    public void incluirConjunto() throws CaException {
        try {
            String strSQL = "INSERT INTO Conjunto (k_codigo,n_nombre,v_mensual,t_descuento,q_cuentabancaria,q_diasdescuento,t_mora) VALUES(?,?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1,conjunto.getK_codigo());
            prepStmt.setString(2,conjunto.getN_nombre());
            prepStmt.setInt(3,conjunto.getV_mensual());
            prepStmt.setFloat(4,conjunto.getT_descuento());
            prepStmt.setInt(5,conjunto.getQ_cuentabancaria());
            prepStmt.setInt(6,conjunto.getQ_diasdescuento());
            prepStmt.setFloat(7,conjunto.getT_mora());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ConjuntoDAO", "No pudo crear el municipio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarConjunto() throws CaException {
        try {
            String strSQL = "SELECT k_codigo,n_nombre,v_mensual,t_descuento,q_cuentabancaria,q_diasdescuento,t_mora FROM Conjunto WHERE k_codigo = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, conjunto.getK_codigo());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                conjunto.setK_codigo(rs.getInt(1));
                conjunto.setN_nombre(rs.getString(2));
                conjunto.setV_mensual(rs.getInt(3));
                conjunto.setT_descuento(rs.getFloat(4));
                conjunto.setQ_cuentabancaria(rs.getInt(5));
                conjunto.setQ_diasdescuento(rs.getInt(6));
                conjunto.setT_mora(rs.getFloat(7));
            }
        } catch (SQLException e) {
            throw new CaException("ConjuntoDAO", "No pudo recuperar el Conjunto " + e.getMessage());
        }
    }

    public void actualizarMunicipio() throws CaException {
        
    }

    public Conjunto getConjunto() {
        return conjunto;
    }

    public void setConjunto(Conjunto conjunto) {
        this.conjunto = conjunto;
    }
    
}

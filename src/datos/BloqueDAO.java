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
import javax.swing.JComboBox;
import logica.Bloque;

import oracle.jdbc.driver.OracleConnection;

import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author SEBASTIAN
 */
public class BloqueDAO {

    private Bloque bloque;

    /*
     * Constructor de la clase
     */
    public BloqueDAO() {
        bloque = new Bloque();
    }
    
    public int isVacio() throws CaException{
        try {
            String strSQL = "SELECT * FROM Bloquee";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            if(rs.next()){
                return 1;
            }else{
                return 0;
            }
        } catch (SQLException e) {
            throw new CaException("Bloque", "No pudo encontrar el conjunto" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public JComboBox<String> listarBloques(int k_codigo) throws CaException {
        try {
            final JComboBox<String> listaBloques = new JComboBox<String>();
            String strSQL = "SELECT k_idbloquee FROM Bloquee where k_codigo = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, k_codigo);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
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
     * @throws CaException
     */
    public void incluirBloque() throws CaException {
        try {
            String strSQL = "INSERT INTO Bloquee (k_idbloquee,k_codigo) VALUES(?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1,bloque.getK_idbloque());
            prepStmt.setInt(2,bloque.getK_codigo());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("BloqueDAO", "No pudo crear el bloque" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

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
        }  finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void actualizarMunicipio() throws CaException {
        
    }

    public Bloque getBloque() {
        return bloque;
    }

    public void setBloque(Bloque bloque) {
        this.bloque = bloque;
    }

}

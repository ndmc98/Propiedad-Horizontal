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
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Apartamento;

import oracle.jdbc.driver.OracleConnection;

import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author SEBASTIAN
 */
public class ApartamentoDAO {
    
    private Apartamento apartamento;

    /*
     * Constructor de la clase
     */
    public ApartamentoDAO() {
        apartamento = new Apartamento();
    }

    /**
     * Incluye una nueva fila en la tabla.
     * @throws CaException
     */
    public void incluirApartamento() throws CaException {
        try {
            String strSQL = "INSERT INTO Apartamento (k_idapartamento, q_area, q_piso, t_coeficiente, k_identificacion, k_idbloquee) VALUES(?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1,apartamento.getK_idapartamento());
            prepStmt.setInt(2,apartamento.getQ_area());
            prepStmt.setInt(3,apartamento.getQ_piso());
            prepStmt.setFloat(4,apartamento.getT_coeficiente());
            prepStmt.setLong(5,apartamento.getK_identificacion());
            prepStmt.setInt(6,apartamento.getK_idbloque());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ApartamentoDAO", "No pudo crear el apartamento" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarApartamento() throws CaException {
        try {
            String strSQL = "SELECT k_idapartamento, q_area, q_piso, t_coeficiente, k_identificacion, k_idbloquee FROM Apartamento WHERE k_idbloquee = ? and k_identificacion = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, apartamento.getK_idbloque());
            prepStmt.setLong(2, apartamento.getK_identificacion());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                apartamento.setK_idapartamento(rs.getInt(1));
                apartamento.setQ_area(rs.getInt(2));
                apartamento.setQ_piso(rs.getInt(3));
                apartamento.setT_coeficiente(rs.getFloat(4));
                apartamento.setK_identificacion(rs.getLong(5));
                apartamento.setK_idbloque(rs.getInt(6));
            }
        } catch (SQLException e) {
            throw new CaException("ApartamentoDAO", "No pudo recuperar el Apartmaento " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void actualizarApartamento() throws CaException {
        try {
            String strSQL = "UPDATE Apartamento SET q_area = ?, q_piso = ?, t_coeficiente = ?"
                    + " WHERE k_idapartamento = ? ";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1,apartamento.getQ_area());
            prepStmt.setInt(2,apartamento.getQ_piso());
            prepStmt.setFloat(3,apartamento.getT_coeficiente());
            prepStmt.setInt(4,apartamento.getK_idapartamento());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException ex) {
            Logger.getLogger(ApartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }    
    
}

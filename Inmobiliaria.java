/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.*;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import util.CaException;

/**
 *
 * @author SEBASTIAN
 */
public class Inmobiliaria {
    
    private ConjuntoDAO conjuntoDAO;
    
    public Inmobiliaria (){
        conjuntoDAO = new ConjuntoDAO();
    }
    
    public JComboBox<String> listaConjuntos() throws CaException{
        return conjuntoDAO.listarConjuntos();
    }
    
    public void incluirConjunto(Conjunto conjunto) throws CaException {
        conjuntoDAO.setConjunto(conjunto);
        conjuntoDAO.incluirConjunto();
    }

    public Conjunto buscarConjunto(Conjunto conjunto) throws CaException {
        conjuntoDAO.setConjunto(conjunto);
        conjuntoDAO.buscarConjunto();
        return conjuntoDAO.getConjunto();
    }

    public ConjuntoDAO getConjuntoDAO() {
        return conjuntoDAO;
    }
    
}

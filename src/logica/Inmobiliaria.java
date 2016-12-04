/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.*;
import javax.swing.JComboBox;
import util.CaException;

/**
 *
 * @author SEBASTIAN
 */
public class Inmobiliaria {
    
    private ConjuntoDAO conjuntoDAO;
    private BloqueDAO bloqueDAO;
    private ApartamentoDAO apartamentoDAO;
    
    public Inmobiliaria (){
        conjuntoDAO = new ConjuntoDAO();
        bloqueDAO = new BloqueDAO();
        apartamentoDAO = new ApartamentoDAO();
    }
    
    // Bloque
    
    public void incluirBloque(Bloque bloque) throws CaException {
        bloqueDAO.setBloque(bloque);
        bloqueDAO.incluirBloque();
    }

    public Bloque buscarBloque(Bloque bloque) throws CaException {
        bloqueDAO.setBloque(bloque);
        bloqueDAO.buscarBloque();
        return bloqueDAO.getBloque();
    }
    
    
    public BloqueDAO getBloqueDAO() {
        return bloqueDAO;
    }
    
    public boolean sinBloques() throws CaException{
        if(bloqueDAO.isVacio()==0){
            return true;
        }else{
            return false;
        }
    }
    
    public JComboBox<String> listaBloques(int k_codigo) throws CaException{
        return bloqueDAO.listarBloques(k_codigo);
    }
    
    // Conjunto
    
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
    
    public JComboBox<String> listaConjuntos() throws CaException{
        return conjuntoDAO.listarConjuntos();
    }
    
    // Apartamento
    
    public void incluirApartamento(Apartamento apartamento) throws CaException {
        apartamentoDAO.setApartamento(apartamento);
        apartamentoDAO.incluirApartamento();
    }

    public Apartamento buscarApartamento(Apartamento apartamento) throws CaException {
        apartamentoDAO.setApartamento(apartamento);
        apartamentoDAO.buscarApartamento();
        return apartamentoDAO.getApartamento();
    }

    public ApartamentoDAO getApartamentoDAO() {
        return apartamentoDAO;
    }
    
}

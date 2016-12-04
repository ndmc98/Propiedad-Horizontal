package presentacion;

import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.Conjunto;
import logica.Inmobiliaria;
import logica.PagoEspacio;
import util.CaException;

/**
 *
 * @author
 */
public class JFramePagoEspacio extends javax.swing.JFrame {

    Conjunto conjunto;
    Inmobiliaria inmobiliaria = new Inmobiliaria();
    PagoEspacio pagoEspacio;
    int encontrada;

    /**
     * Creates new form JFramePagoEspacio
     */
    public JFramePagoEspacio(Conjunto conjunto) {
        initComponents();
        this.conjunto = conjunto;
    }

    public void buscarReserva() throws CaException {
        encontrada = inmobiliaria.busquedaReserva(Integer.parseInt((String) spnNumReserva.getValue()), conjunto.getK_codigo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNumPago = new javax.swing.JLabel();
        spnNumPago = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        lblvalorPago = new javax.swing.JLabel();
        lblFormaPago = new javax.swing.JLabel();
        boxFormaPago = new javax.swing.JComboBox<>();
        lblNumReserva = new javax.swing.JLabel();
        datePago = new com.toedter.calendar.JDateChooser();
        spnValorPago = new javax.swing.JSpinner();
        spnNumReserva = new javax.swing.JSpinner();
        btnRegistrarPago = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNumPago.setText("Número unico de Pago:");
        getContentPane().add(lblNumPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 28, 200, -1));

        spnNumPago.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9999, 1));
        getContentPane().add(spnNumPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 90, -1));

        jLabel1.setText("Fecha Pago:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 90, -1));

        lblvalorPago.setText("Valor Pago:");
        getContentPane().add(lblvalorPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 90, -1));

        lblFormaPago.setText("Forma Pago:");
        getContentPane().add(lblFormaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 80, -1));

        boxFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cheque", "Efectivo", " " }));
        getContentPane().add(boxFormaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 100, -1));

        lblNumReserva.setText("Número de la reserva:");
        getContentPane().add(lblNumReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 140, -1));
        getContentPane().add(datePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 150, -1));

        spnValorPago.setModel(new javax.swing.SpinnerNumberModel(Long.valueOf(1L), Long.valueOf(1L), Long.valueOf(9999999L), Long.valueOf(1L)));
        getContentPane().add(spnValorPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 130, -1));

        spnNumReserva.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9999, 1));
        getContentPane().add(spnNumReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 100, -1));

        btnRegistrarPago.setText("Registrar");
        btnRegistrarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPagoActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPagoActionPerformed
        try {
            buscarReserva();
            if (encontrada == 1) {
                pagoEspacio = new PagoEspacio((int) spnNumPago.getValue(), (Date) datePago.getDate(), (Long) spnValorPago.getValue(), (String) boxFormaPago.getSelectedItem(), (int) spnNumReserva.getValue());
                inmobiliaria.incluirPagoEspacio(pagoEspacio);
            } else if (encontrada == 0) {
                JOptionPane.showMessageDialog(this, "Número de identificacion no encontrado", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (CaException ex) {
            JOptionPane.showMessageDialog(this, "Número de identificacion no encontrado", "Error", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(JFrameReserva.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnRegistrarPagoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxFormaPago;
    private javax.swing.JButton btnRegistrarPago;
    private com.toedter.calendar.JDateChooser datePago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblFormaPago;
    private javax.swing.JLabel lblNumPago;
    private javax.swing.JLabel lblNumReserva;
    private javax.swing.JLabel lblvalorPago;
    private javax.swing.JSpinner spnNumPago;
    private javax.swing.JSpinner spnNumReserva;
    private javax.swing.JSpinner spnValorPago;
    // End of variables declaration//GEN-END:variables
}

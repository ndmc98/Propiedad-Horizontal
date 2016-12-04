/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logica.Conjunto;
import logica.Inmobiliaria;
import logica.Reserva;
import util.CaException;

/**
 *
 * @author Hogar
 */
public class JFrameReserva extends javax.swing.JFrame {

    Conjunto conjunto;
    Inmobiliaria inmobiliaria = new Inmobiliaria();
    Reserva reserva;
    int encontrado;

    /**
     * Creates new form PrototipoGUI
     */
    public JFrameReserva(Conjunto conjunto) {
        initComponents();
        this.conjunto = conjunto;
        btnReservar.setEnabled(false);
        listaEspacios();
        llenadoTable();
    }

    public void buscarIdentificacion() throws CaException {
        encontrado = inmobiliaria.busquedaId((Long) spnIdentif.getValue(), conjunto.getK_codigo());
    }

    public void listaEspacios() {
        try {
            listaEspComun.removeAllItems();
            for (int i = 0; i < inmobiliaria.listaEspacios(conjunto.getK_codigo()).getItemCount(); i++) {
                listaEspComun.addItem(inmobiliaria.listaEspacios(conjunto.getK_codigo()).getItemAt(i));
            }
        } catch (CaException ex) {
            Logger.getLogger(Bienvenida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenadoTable() {
        try {
            this.jTable1.setModel(inmobiliaria.tableEspacios());
            jTable1.setEnabled(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        lblECsolicitado = new javax.swing.JLabel();
        listaEspComun = new javax.swing.JComboBox<>();
        lblFinicio = new javax.swing.JLabel();
        lblFin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblInfoSol = new javax.swing.JLabel();
        lblIdenti = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        btnReservar = new javax.swing.JButton();
        lblNumReserva = new javax.swing.JLabel();
        spnIdReserva = new javax.swing.JSpinner();
        spnIdentif = new javax.swing.JSpinner();
        dateInicio = new com.toedter.calendar.JDateChooser();
        dateFin = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reservas Comunales");
        setBackground(new java.awt.Color(166, 225, 247));
        setForeground(new java.awt.Color(102, 153, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblECsolicitado.setText("Espacio comunal solicitado:");
        getContentPane().add(lblECsolicitado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 195, 25));

        listaEspComun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaEspComunActionPerformed(evt);
            }
        });
        getContentPane().add(listaEspComun, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 116, -1));

        lblFinicio.setText("Fecha inicio:");
        getContentPane().add(lblFinicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 100, -1));

        lblFin.setText("Fecha fin:");
        getContentPane().add(lblFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 14, 333));

        lblInfoSol.setText("Información del solicitante:");
        getContentPane().add(lblInfoSol, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, -1));

        lblIdenti.setText("Identificación:");
        getContentPane().add(lblIdenti, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Nombre Completo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 30, -1, -1));

        jLabel8.setText("Identificación:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 71, -1, -1));

        jTextField2.setEnabled(false);
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 27, 180, -1));

        jTextField3.setEnabled(false);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 68, 180, -1));

        jLabel10.setText("Correo:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jTextField5.setEnabled(false);
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 360, 180));

        btnReservar.setText("Reservar\n");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });
        getContentPane().add(btnReservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 95, 45));

        lblNumReserva.setText("Numero unico de identificacion de reserva:");
        getContentPane().add(lblNumReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 240, -1));

        spnIdReserva.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9999, 1));
        getContentPane().add(spnIdReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 80, -1));

        spnIdentif.setModel(new javax.swing.SpinnerNumberModel(Long.valueOf(1L), Long.valueOf(1L), Long.valueOf(9999999999L), Long.valueOf(1L)));
        getContentPane().add(spnIdentif, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 100, -1));
        getContentPane().add(dateInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 150, -1));
        getContentPane().add(dateFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 150, -1));

        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 850, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void listaEspComunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaEspComunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaEspComunActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        reserva = new Reserva((int) spnIdReserva.getValue(), (Date) dateFin.getDate(), (Date) dateInicio.getDate(), (Long) spnIdentif.getValue(), (int) listaEspComun.getSelectedItem());
    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            buscarIdentificacion();
            if (encontrado == 1) {
                btnReservar.setEnabled(true);
            } else if (encontrado == 0) {
                JOptionPane.showMessageDialog(this, "Número de identificacion no encontrado", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (CaException ex) {
            Logger.getLogger(JFrameReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnReservar;
    private com.toedter.calendar.JDateChooser dateFin;
    private com.toedter.calendar.JDateChooser dateInicio;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblECsolicitado;
    private javax.swing.JLabel lblFin;
    private javax.swing.JLabel lblFinicio;
    private javax.swing.JLabel lblIdenti;
    private javax.swing.JLabel lblInfoSol;
    private javax.swing.JLabel lblNumReserva;
    private javax.swing.JComboBox<String> listaEspComun;
    private javax.swing.JSpinner spnIdReserva;
    private javax.swing.JSpinner spnIdentif;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import logica.Conjunto;

/**
 *
 * @author SEBASTIAN
 */
public class EliminarModificar extends javax.swing.JFrame {

    Conjunto conjunto;
    
    /**
     * Creates new form Actualizar
     */
    public EliminarModificar(Conjunto conjunto) {
        initComponents();
        this.conjunto = conjunto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        modificar = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        valoresGloabalesM = new javax.swing.JButton();
        apartamentoM = new javax.swing.JButton();
        espacioComunM = new javax.swing.JButton();
        conjuntoM = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        eliminar = new javax.swing.JLabel();
        pagoReservaD = new javax.swing.JButton();
        personaD = new javax.swing.JButton();
        telefonoD = new javax.swing.JButton();
        pagoCuaotaD = new javax.swing.JButton();
        cuotaD = new javax.swing.JButton();
        reservaD = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        modificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        modificar.setText("Modificar");
        jPanel1.add(modificar);

        jButton5.setText("Pago Reserva");
        jPanel1.add(jButton5);

        jButton6.setText("Persona");
        jPanel1.add(jButton6);

        jButton9.setText("Telefono");
        jPanel1.add(jButton9);

        jButton8.setText("Pago Cuota");
        jPanel1.add(jButton8);

        jButton7.setText("Cuota");
        jPanel1.add(jButton7);

        valoresGloabalesM.setText("Valores Globales");
        valoresGloabalesM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valoresGloabalesMActionPerformed(evt);
            }
        });
        jPanel1.add(valoresGloabalesM);

        apartamentoM.setText("Apartamento");
        apartamentoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apartamentoMActionPerformed(evt);
            }
        });
        jPanel1.add(apartamentoM);

        espacioComunM.setText("Espacio Comun");
        jPanel1.add(espacioComunM);

        conjuntoM.setText("Conjunto");
        jPanel1.add(conjuntoM);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 160, 340));

        eliminar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        eliminar.setText("Eliminar");
        jPanel2.add(eliminar);

        pagoReservaD.setText("Pago Reserva");
        jPanel2.add(pagoReservaD);

        personaD.setText("Persona");
        jPanel2.add(personaD);

        telefonoD.setText("Telefono");
        jPanel2.add(telefonoD);

        pagoCuaotaD.setText("Pago Cuota");
        jPanel2.add(pagoCuaotaD);

        cuotaD.setText("Cuota");
        jPanel2.add(cuotaD);

        reservaD.setText("Reserva");
        jPanel2.add(reservaD);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 340));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel3.add(salir);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void apartamentoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apartamentoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apartamentoMActionPerformed

    private void valoresGloabalesMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valoresGloabalesMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valoresGloabalesMActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.setEnabled(false);
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton apartamentoM;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton conjuntoM;
    private javax.swing.JButton cuotaD;
    private javax.swing.JLabel eliminar;
    private javax.swing.JButton espacioComunM;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel modificar;
    private javax.swing.JButton pagoCuaotaD;
    private javax.swing.JButton pagoReservaD;
    private javax.swing.JButton personaD;
    private javax.swing.JButton reservaD;
    private javax.swing.JButton salir;
    private javax.swing.JButton telefonoD;
    private javax.swing.JButton valoresGloabalesM;
    // End of variables declaration//GEN-END:variables
}

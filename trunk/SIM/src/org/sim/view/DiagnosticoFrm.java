/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CUPSFrm.java
 *
 * Created on 20/03/2011, 12:46:24 PM
 */

package org.sim.view;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import org.sim.domain.Cups;
import org.sim.domain.Diagnostico;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Administrador
 */
public class DiagnosticoFrm extends javax.swing.JInternalFrame {

    private Diagnostico diagnostico;
    /** Creates new form CUPSFrm */
    public DiagnosticoFrm() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo_Diagnostico = new javax.swing.JTextField();
        txtNombre_Diagnostico = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Registro y Consulta de Diagnosticos CIE10");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Registro de Diagnosticos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Código");

        txtCodigo_Diagnostico.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCodigo_Diagnostico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigo_DiagnosticoKeyPressed(evt);
            }
        });

        txtNombre_Diagnostico.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Nombre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo_Diagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre_Diagnostico, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo_Diagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre_Diagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sim/view/images/page.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo Registro");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sim/view/images/disk.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar Registro");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);
        jToolBar1.add(jSeparator1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sim/view/images/page_white_magnify.png"))); // NOI18N
        jButton3.setToolTipText("Vista Preliminar");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sim/view/images/printer.png"))); // NOI18N
        jButton4.setToolTipText("Imprimir");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator2);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sim/view/images/magnifier.png"))); // NOI18N
        jButton5.setToolTipText("Consultar");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigo_DiagnosticoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigo_DiagnosticoKeyPressed
        int codigoTecla = evt.getKeyCode();
        if(codigoTecla == KeyEvent.VK_ENTER || codigoTecla == KeyEvent.VK_TAB){
            diagnostico = Diagnostico.cargar(txtCodigo_Diagnostico.getText());
            txtCodigo_Diagnostico.setEnabled(false);
            txtNombre_Diagnostico.requestFocus();
            if(diagnostico != null){
                txtNombre_Diagnostico.setText(diagnostico.getNombre());
            }else{
                txtNombre_Diagnostico.setText("");
            }

        }
}//GEN-LAST:event_txtCodigo_DiagnosticoKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo();
}//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
        nuevo();
}//GEN-LAST:event_btnGuardarActionPerformed
 private void nuevo(){
        txtCodigo_Diagnostico.setEnabled(true);
        txtCodigo_Diagnostico.setText("");
        txtCodigo_Diagnostico.requestFocus();
        txtNombre_Diagnostico.setText("");
        diagnostico = null;
    }

    private void guardar(){
        if(diagnostico == null) diagnostico = new Diagnostico();
        diagnostico.setCodigo(txtCodigo_Diagnostico.getText());
        diagnostico.setNombre(txtNombre_Diagnostico.getText());
        try{
            diagnostico.guardar();
        }catch(RepositoryException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtCodigo_Diagnostico;
    private javax.swing.JTextField txtNombre_Diagnostico;
    // End of variables declaration//GEN-END:variables

}

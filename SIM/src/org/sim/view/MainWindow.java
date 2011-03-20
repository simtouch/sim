/*
 * MainWindow.java
 *
 * Created on 21/02/2011, 04:34:55 PM
 */

package org.sim.view;

import org.sim.view.actions.*;

/**
 *
 * @author Franky Villadiego
 */
public class MainWindow extends javax.swing.JFrame {

    /***********************************************/
    /*       Formularios de la aplicación          */
    /***********************************************/
    EntidadFrm entidadFrm = new EntidadFrm();
    PacientesFrm pacientesFrm = new PacientesFrm();
    CUPSFrm cupsFrm = new CUPSFrm();
    DiagnosticoFrm diagnosticoFrm = new DiagnosticoFrm();

    


    public MainWindow() {
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

        desktopPane = new javax.swing.JDesktopPane();
        toolBar = new javax.swing.JToolBar();
        pacientesButton = new javax.swing.JButton();
        entidadButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        agendaButton = new javax.swing.JButton();
        historiaButton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        opcionButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        pacienteMenuItem = new javax.swing.JMenuItem();
        entidadMenuItem = new javax.swing.JMenuItem();
        salirMenuItem = new javax.swing.JMenuItem();
        registroMenu = new javax.swing.JMenu();
        agendaMenuItem = new javax.swing.JMenuItem();
        historiaMenuItem = new javax.swing.JMenuItem();
        herramientasMenu = new javax.swing.JMenu();
        codigoCUPSMenuItem = new javax.swing.JMenuItem();
        diagnosticoMenuItem = new javax.swing.JMenuItem();
        medicamentoMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        tarifaMenuItem = new javax.swing.JMenuItem();
        planMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        opcionMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        toolBar.setFloatable(false);
        toolBar.setRollover(true);
        toolBar.setAutoscrolls(true);

        pacientesButton.setAction(new MostrarFormPacientes(desktopPane, pacientesFrm));
        pacientesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sim/view/images/people2.png"))); // NOI18N
        pacientesButton.setFocusable(false);
        pacientesButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pacientesButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(pacientesButton);

        entidadButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sim/view/images/plus_24.png"))); // NOI18N
        entidadButton.setFocusable(false);
        entidadButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        entidadButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(entidadButton);
        toolBar.add(jSeparator3);

        agendaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sim/view/images/date_24.png"))); // NOI18N
        agendaButton.setFocusable(false);
        agendaButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        agendaButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(agendaButton);

        historiaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sim/view/images/clipboard_24.png"))); // NOI18N
        historiaButton.setFocusable(false);
        historiaButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        historiaButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(historiaButton);
        toolBar.add(jSeparator4);

        opcionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sim/view/images/tools_24.png"))); // NOI18N
        opcionButton.setFocusable(false);
        opcionButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        opcionButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(opcionButton);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("label"); // NOI18N
        archivoMenu.setText(bundle.getString("menu.file")); // NOI18N

        pacienteMenuItem.setAction(new MostrarFormPacientes(desktopPane, pacientesFrm));
        pacienteMenuItem.setText(bundle.getString("menu.patients")); // NOI18N
        archivoMenu.add(pacienteMenuItem);

        entidadMenuItem.setAction(new MostrarFormEntidad(desktopPane, entidadFrm, true));
        entidadMenuItem.setText(bundle.getString("menu.entity")); // NOI18N
        archivoMenu.add(entidadMenuItem);

        salirMenuItem.setText(bundle.getString("menu.exit")); // NOI18N
        salirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuItemActionPerformed(evt);
            }
        });
        archivoMenu.add(salirMenuItem);

        menuBar.add(archivoMenu);

        registroMenu.setText("Resgistro");

        agendaMenuItem.setText("Agenda");
        registroMenu.add(agendaMenuItem);

        historiaMenuItem.setText("Historia clínica");
        registroMenu.add(historiaMenuItem);

        menuBar.add(registroMenu);

        herramientasMenu.setText("Herramientas");

        codigoCUPSMenuItem.setAction(new MostrarFormCups(desktopPane, cupsFrm, true));
        codigoCUPSMenuItem.setText("Códigos CUPS");
        herramientasMenu.add(codigoCUPSMenuItem);

        diagnosticoMenuItem.setAction(new MostrarFormCups(desktopPane, diagnosticoFrm,true));
        diagnosticoMenuItem.setText("Diagnósticos CIE10");
        herramientasMenu.add(diagnosticoMenuItem);

        medicamentoMenuItem.setText("Medicamentos");
        herramientasMenu.add(medicamentoMenuItem);
        herramientasMenu.add(jSeparator1);

        tarifaMenuItem.setText("Tarifas");
        herramientasMenu.add(tarifaMenuItem);

        planMenuItem.setText("Planes");
        herramientasMenu.add(planMenuItem);
        herramientasMenu.add(jSeparator2);

        opcionMenuItem.setText("Opciones");
        herramientasMenu.add(opcionMenuItem);

        menuBar.add(herramientasMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
            .addComponent(toolBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirMenuItemActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        Usuario u = Usuario.cargar("franky");
//        if(u==null){
//            JOptionPane.showMessageDialog(null, "Aun no hay usuarios en la BD");
//        }
    }//GEN-LAST:event_formWindowOpened




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agendaButton;
    private javax.swing.JMenuItem agendaMenuItem;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.JMenuItem codigoCUPSMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem diagnosticoMenuItem;
    private javax.swing.JButton entidadButton;
    private javax.swing.JMenuItem entidadMenuItem;
    private javax.swing.JMenu herramientasMenu;
    private javax.swing.JButton historiaButton;
    private javax.swing.JMenuItem historiaMenuItem;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JMenuItem medicamentoMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton opcionButton;
    private javax.swing.JMenuItem opcionMenuItem;
    private javax.swing.JMenuItem pacienteMenuItem;
    private javax.swing.JButton pacientesButton;
    private javax.swing.JMenuItem planMenuItem;
    private javax.swing.JMenu registroMenu;
    private javax.swing.JMenuItem salirMenuItem;
    private javax.swing.JMenuItem tarifaMenuItem;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables

}

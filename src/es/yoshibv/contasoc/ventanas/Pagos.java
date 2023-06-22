/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.yoshibv.contasoc.ventanas;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author jomaa
 */
public class Pagos extends javax.swing.JFrame {
    private int xMouse, yMouse;
    /**
     * Creates new form Socios
     */
    public Pagos() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void headerMousePressed(java.awt.event.MouseEvent evt){
        xMouse = evt.getX();
        yMouse = evt.getY();
    }
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/logo_small.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ToolBar = new javax.swing.JToolBar();
        jLabelLogo = new javax.swing.JLabel();
        toolBarFiller = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        MinimizeBtn = new javax.swing.JPanel();
        MinimizeTxt = new javax.swing.JLabel();
        ExitBtn = new javax.swing.JPanel();
        ExitTxt = new javax.swing.JLabel();
        MenuToolBar = new javax.swing.JToolBar();
        InicioMenuBtn = new javax.swing.JButton();
        SociosMenuBtn = new javax.swing.JButton();
        PagosMenuBtn = new javax.swing.JButton();
        InformeMenuBtn = new javax.swing.JButton();
        ListaEsperaMenuBtn = new javax.swing.JButton();
        toolBarFiller1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        DataPanel = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();
        FechaTxt = new javax.swing.JLabel();
        FechaPanel = new javax.swing.JScrollPane();
        FechaField = new javax.swing.JTextPane();
        ProveedorTxt = new javax.swing.JLabel();
        ProveedorPanel = new javax.swing.JScrollPane();
        ProveedorField = new javax.swing.JTextPane();
        ConceptoTxt = new javax.swing.JLabel();
        ConceptoPanel = new javax.swing.JScrollPane();
        ConceptoField = new javax.swing.JTextPane();
        CantidadTxt = new javax.swing.JLabel();
        CantidadPanel = new javax.swing.JScrollPane();
        CantidadField = new javax.swing.JTextPane();
        NFacturaTxt = new javax.swing.JLabel();
        NFacturaPanel = new javax.swing.JScrollPane();
        NFacturaField = new javax.swing.JTextPane();
        MiddlePanel = new javax.swing.JPanel();
        ListaIngresosPanel = new javax.swing.JScrollPane();
        ListaIngresosField = new javax.swing.JTextArea();
        RightPanel = new javax.swing.JPanel();
        AgregarBtn = new javax.swing.JButton();
        BuscarBtn = new javax.swing.JButton();
        ModificarBtn = new javax.swing.JButton();
        EliminarBtn = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ToolBar.setBackground(new java.awt.Color(255, 255, 255));
        ToolBar.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.SystemColor.windowBorder));
        ToolBar.setFloatable(false);
        ToolBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ToolBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                ToolBarMouseDragged(evt);
            }
        });

        jLabelLogo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_small.png"))); // NOI18N
        jLabelLogo.setText("Contasoc - Pagos");
        jLabelLogo.setIconTextGap(6);
        jLabelLogo.setMaximumSize(new java.awt.Dimension(86, 32));
        jLabelLogo.setMinimumSize(new java.awt.Dimension(86, 32));
        jLabelLogo.setName(""); // NOI18N
        jLabelLogo.setPreferredSize(new java.awt.Dimension(170, 32));
        ToolBar.add(jLabelLogo);

        toolBarFiller.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toolBarFiller.setFocusable(true);
        ToolBar.add(toolBarFiller);

        MinimizeBtn.setBackground(new java.awt.Color(255, 255, 255));
        MinimizeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MinimizeBtn.setMaximumSize(new java.awt.Dimension(32, 32));
        MinimizeBtn.setMinimumSize(new java.awt.Dimension(32, 32));
        MinimizeBtn.setPreferredSize(new java.awt.Dimension(32, 32));
        MinimizeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MinimizeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinimizeBtnMouseExited(evt);
            }
        });
        MinimizeBtn.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        MinimizeTxt.setBackground(new java.awt.Color(255, 255, 255));
        MinimizeTxt.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        MinimizeTxt.setText("—");
        MinimizeTxt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MinimizeTxt.setMaximumSize(new java.awt.Dimension(32, 32));
        MinimizeTxt.setMinimumSize(new java.awt.Dimension(32, 32));
        MinimizeTxt.setPreferredSize(new java.awt.Dimension(32, 32));
        MinimizeBtn.add(MinimizeTxt);

        ToolBar.add(MinimizeBtn);

        ExitBtn.setBackground(new java.awt.Color(255, 255, 255));
        ExitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExitBtn.setMaximumSize(new java.awt.Dimension(32, 32));
        ExitBtn.setMinimumSize(new java.awt.Dimension(32, 32));
        ExitBtn.setPreferredSize(new java.awt.Dimension(32, 32));
        ExitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitBtnMouseExited(evt);
            }
        });
        ExitBtn.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        ExitTxt.setBackground(new java.awt.Color(255, 255, 255));
        ExitTxt.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        ExitTxt.setText("X");
        ExitTxt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ExitTxt.setMaximumSize(new java.awt.Dimension(32, 32));
        ExitTxt.setMinimumSize(new java.awt.Dimension(32, 32));
        ExitTxt.setPreferredSize(new java.awt.Dimension(32, 32));
        ExitBtn.add(ExitTxt);

        ToolBar.add(ExitBtn);

        getContentPane().add(ToolBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        MenuToolBar.setBackground(new java.awt.Color(255, 255, 255));
        MenuToolBar.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.SystemColor.windowBorder));
        MenuToolBar.setFloatable(false);
        MenuToolBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuToolBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MenuToolBarMouseDragged(evt);
            }
        });

        InicioMenuBtn.setText("Inicio");
        InicioMenuBtn.setContentAreaFilled(false);
        InicioMenuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InicioMenuBtn.setFocusable(false);
        InicioMenuBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        InicioMenuBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        InicioMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioMenuBtnActionPerformed(evt);
            }
        });
        MenuToolBar.add(InicioMenuBtn);

        SociosMenuBtn.setText("Socios");
        SociosMenuBtn.setContentAreaFilled(false);
        SociosMenuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SociosMenuBtn.setFocusable(false);
        SociosMenuBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SociosMenuBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        SociosMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SociosMenuBtnActionPerformed(evt);
            }
        });
        MenuToolBar.add(SociosMenuBtn);

        PagosMenuBtn.setText("Ingresos");
        PagosMenuBtn.setContentAreaFilled(false);
        PagosMenuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PagosMenuBtn.setFocusable(false);
        PagosMenuBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PagosMenuBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PagosMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagosMenuBtnActionPerformed(evt);
            }
        });
        MenuToolBar.add(PagosMenuBtn);

        InformeMenuBtn.setText("Informe");
        InformeMenuBtn.setContentAreaFilled(false);
        InformeMenuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InformeMenuBtn.setFocusable(false);
        InformeMenuBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        InformeMenuBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MenuToolBar.add(InformeMenuBtn);

        ListaEsperaMenuBtn.setText("Lista de Espera");
        ListaEsperaMenuBtn.setContentAreaFilled(false);
        ListaEsperaMenuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ListaEsperaMenuBtn.setFocusable(false);
        ListaEsperaMenuBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ListaEsperaMenuBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MenuToolBar.add(ListaEsperaMenuBtn);

        toolBarFiller1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toolBarFiller1.setFocusable(true);
        MenuToolBar.add(toolBarFiller1);

        getContentPane().add(MenuToolBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 34, 900, 25));

        DataPanel.setBackground(new java.awt.Color(255, 255, 255));

        LeftPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        LeftPanel.setPreferredSize(new java.awt.Dimension(410, 470));

        FechaTxt.setText("Fecha:");

        FechaPanel.setViewportView(FechaField);

        ProveedorTxt.setText("Proveedor:");

        ProveedorPanel.setViewportView(ProveedorField);

        ConceptoTxt.setText("Concepto:");

        ConceptoPanel.setViewportView(ConceptoField);

        CantidadTxt.setText("Cantidad:");

        CantidadPanel.setViewportView(CantidadField);

        NFacturaTxt.setText("Nº de factura:");

        NFacturaPanel.setViewportView(NFacturaField);

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addComponent(FechaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(FechaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addComponent(ConceptoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(ConceptoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addComponent(CantidadTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(CantidadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addComponent(NFacturaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(NFacturaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addComponent(ProveedorTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(ProveedorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FechaPanel)
                    .addComponent(FechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProveedorPanel)
                    .addComponent(ProveedorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ConceptoPanel)
                    .addComponent(ConceptoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CantidadPanel)
                    .addComponent(CantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NFacturaPanel)
                    .addComponent(NFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 296, Short.MAX_VALUE))
        );

        DataPanel.add(LeftPanel);

        MiddlePanel.setPreferredSize(new java.awt.Dimension(255, 470));

        ListaIngresosField.setEditable(false);
        ListaIngresosField.setColumns(20);
        ListaIngresosField.setRows(5);
        ListaIngresosPanel.setViewportView(ListaIngresosField);

        javax.swing.GroupLayout MiddlePanelLayout = new javax.swing.GroupLayout(MiddlePanel);
        MiddlePanel.setLayout(MiddlePanelLayout);
        MiddlePanelLayout.setHorizontalGroup(
            MiddlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MiddlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ListaIngresosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );
        MiddlePanelLayout.setVerticalGroup(
            MiddlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MiddlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ListaIngresosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );

        DataPanel.add(MiddlePanel);

        RightPanel.setPreferredSize(new java.awt.Dimension(155, 470));

        AgregarBtn.setText("Agregar");
        AgregarBtn.setToolTipText("");
        AgregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarBtnActionPerformed(evt);
            }
        });

        BuscarBtn.setText("Buscar");

        ModificarBtn.setText("Modificar");

        EliminarBtn.setText("Eliminar");

        javax.swing.GroupLayout RightPanelLayout = new javax.swing.GroupLayout(RightPanel);
        RightPanel.setLayout(RightPanelLayout);
        RightPanelLayout.setHorizontalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AgregarBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BuscarBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(ModificarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(EliminarBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                .addContainerGap())
        );
        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(AgregarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BuscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ModificarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EliminarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(280, Short.MAX_VALUE))
        );

        DataPanel.add(RightPanel);

        getContentPane().add(DataPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 840, 480));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bg_notext.png"))); // NOI18N
        jLabelFondo.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.SystemColor.windowBorder));
        jLabelFondo.setMaximumSize(new java.awt.Dimension(900, 600));
        jLabelFondo.setMinimumSize(new java.awt.Dimension(900, 600));
        jLabelFondo.setPreferredSize(new java.awt.Dimension(900, 600));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void MinimizeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeBtnMouseClicked
        // TODO add your handling code here:
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_MinimizeBtnMouseClicked

    private void MinimizeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeBtnMouseEntered
        // TODO add your handling code here:
        MinimizeBtn.setBackground(Color.decode("#287AE9"));
    }//GEN-LAST:event_MinimizeBtnMouseEntered

    private void MinimizeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeBtnMouseExited
        // TODO add your handling code here:
        MinimizeBtn.setBackground(Color.decode("#FFFFFF"));
    }//GEN-LAST:event_MinimizeBtnMouseExited

    private void ExitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseClicked
        // TODO add your handling code here:
        System.exit(0);

    }//GEN-LAST:event_ExitBtnMouseClicked

    private void ExitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseEntered
        // TODO add your handling code here:
        ExitBtn.setBackground(Color.RED);
    }//GEN-LAST:event_ExitBtnMouseEntered

    private void ExitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseExited
        // TODO add your handling code here:
        ExitBtn.setBackground(Color.decode("#FFFFFF"));
    }//GEN-LAST:event_ExitBtnMouseExited

    private void ToolBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToolBarMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_ToolBarMouseDragged

    private void MenuToolBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuToolBarMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuToolBarMouseDragged

    private void InicioMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioMenuBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InicioMenuBtnActionPerformed

    private void AgregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgregarBtnActionPerformed

    private void PagosMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagosMenuBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PagosMenuBtnActionPerformed

    private void SociosMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SociosMenuBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SociosMenuBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarBtn;
    private javax.swing.JButton BuscarBtn;
    private javax.swing.JTextPane CantidadField;
    private javax.swing.JScrollPane CantidadPanel;
    private javax.swing.JLabel CantidadTxt;
    private javax.swing.JTextPane ConceptoField;
    private javax.swing.JScrollPane ConceptoPanel;
    private javax.swing.JLabel ConceptoTxt;
    private javax.swing.JPanel DataPanel;
    private javax.swing.JButton EliminarBtn;
    private javax.swing.JPanel ExitBtn;
    private javax.swing.JLabel ExitTxt;
    private javax.swing.JTextPane FechaField;
    private javax.swing.JScrollPane FechaPanel;
    private javax.swing.JLabel FechaTxt;
    private javax.swing.JButton InformeMenuBtn;
    private javax.swing.JButton InicioMenuBtn;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JButton ListaEsperaMenuBtn;
    private javax.swing.JTextArea ListaIngresosField;
    private javax.swing.JScrollPane ListaIngresosPanel;
    private javax.swing.JToolBar MenuToolBar;
    private javax.swing.JPanel MiddlePanel;
    private javax.swing.JPanel MinimizeBtn;
    private javax.swing.JLabel MinimizeTxt;
    private javax.swing.JButton ModificarBtn;
    private javax.swing.JTextPane NFacturaField;
    private javax.swing.JScrollPane NFacturaPanel;
    private javax.swing.JLabel NFacturaTxt;
    private javax.swing.JButton PagosMenuBtn;
    private javax.swing.JTextPane ProveedorField;
    private javax.swing.JScrollPane ProveedorPanel;
    private javax.swing.JLabel ProveedorTxt;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JButton SociosMenuBtn;
    private javax.swing.JToolBar ToolBar;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.Box.Filler toolBarFiller;
    private javax.swing.Box.Filler toolBarFiller1;
    // End of variables declaration//GEN-END:variables
}

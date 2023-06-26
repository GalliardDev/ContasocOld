/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.yoshibv.contasoc.ventanas;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author jomaa
 */
@SuppressWarnings("serial")
public class ListaEspera extends javax.swing.JFrame {
    private int xMouse, yMouse;
    /**
     * Creates new form Socios
     */
    public ListaEspera() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/newlogo_small.png"));
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
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(0, 0));
        InicioMenuBtn = new javax.swing.JButton();
        SociosMenuBtn = new javax.swing.JButton();
        IngresosMenuBtn = new javax.swing.JButton();
        PagosMenuBtn = new javax.swing.JButton();
        InformeMenuBtn = new javax.swing.JButton();
        toolBarFiller1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        DataPanel = new javax.swing.JPanel();
        MiddlePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        RightPanel = new javax.swing.JPanel();
        ActualizarBtn = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contasoc");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        setIconImage(getIconImage());

        ToolBar.setBackground(new java.awt.Color(255, 255, 255));
        ToolBar.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.SystemColor.windowBorder));
        ToolBar.setFloatable(false);
        ToolBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ToolBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                ToolBarMouseDragged(evt);
            }
        });

        ToolBar.add(filler2);
        jLabelLogo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/toolbarlogo.png"))); // NOI18N
        jLabelLogo.setText("Contasoc - Lista de Espera");
        jLabelLogo.setIconTextGap(6);
        jLabelLogo.setMaximumSize(new java.awt.Dimension(86, 32));
        jLabelLogo.setMinimumSize(new java.awt.Dimension(86, 32));
        jLabelLogo.setName(""); // NOI18N
        jLabelLogo.setPreferredSize(new java.awt.Dimension(200, 32));
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
        InicioMenuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mouseClicked(java.awt.event.MouseEvent evt) {
        		InicioMenuBtnMouseClicked(evt);
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
        SociosMenuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	SociosMenuBtnMouseClicked(evt);
            }
        });
        MenuToolBar.add(SociosMenuBtn);

        IngresosMenuBtn.setText("Ingresos");
        IngresosMenuBtn.setContentAreaFilled(false);
        IngresosMenuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IngresosMenuBtn.setFocusable(false);
        IngresosMenuBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IngresosMenuBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        IngresosMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresosMenuBtnActionPerformed(evt);
            }
        });
        IngresosMenuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	IngresosMenuBtnMouseClicked(evt);
            }
        });
        MenuToolBar.add(IngresosMenuBtn);

        PagosMenuBtn.setText("Pagos");
        PagosMenuBtn.setContentAreaFilled(false);
        PagosMenuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PagosMenuBtn.setFocusable(false);
        PagosMenuBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PagosMenuBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PagosMenuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	PagosMenuBtnMouseClicked(evt);
            }
        });
        MenuToolBar.add(PagosMenuBtn);

        InformeMenuBtn.setText("Informe");
        InformeMenuBtn.setContentAreaFilled(false);
        InformeMenuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InformeMenuBtn.setFocusable(false);
        InformeMenuBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        InformeMenuBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        InformeMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InformeMenuBtnActionPerformed(evt);
            }
        });
        InformeMenuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	InformeMenuBtnMouseClicked(evt);
            }
        });
        MenuToolBar.add(InformeMenuBtn);

        toolBarFiller1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toolBarFiller1.setFocusable(true);
        MenuToolBar.add(toolBarFiller1);

        getContentPane().add(MenuToolBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 34, 900, 25));

        DataPanel.setBackground(new java.awt.Color(255, 255, 255));

        MiddlePanel.setPreferredSize(new java.awt.Dimension(665, 470));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nº socio", "Nombre", "Teléfono", "Email", "Fecha de Alta"
            }
        ) {
            @SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            @SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(155);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(35);
        }

        javax.swing.GroupLayout MiddlePanelLayout = new javax.swing.GroupLayout(MiddlePanel);
        MiddlePanel.setLayout(MiddlePanelLayout);
        MiddlePanelLayout.setHorizontalGroup(
            MiddlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MiddlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                .addContainerGap())
        );
        MiddlePanelLayout.setVerticalGroup(
            MiddlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MiddlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );

        DataPanel.add(MiddlePanel);

        RightPanel.setPreferredSize(new java.awt.Dimension(155, 470));

        ActualizarBtn.setText("Actualizar");
        ActualizarBtn.setToolTipText("");
        ActualizarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightPanelLayout = new javax.swing.GroupLayout(RightPanel);
        RightPanel.setLayout(RightPanelLayout);
        RightPanelLayout.setHorizontalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ActualizarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );
        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(ActualizarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(421, Short.MAX_VALUE))
        );

        DataPanel.add(RightPanel);

        getContentPane().add(DataPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 840, 480));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/newbg_notext.png"))); // NOI18N
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
    
    private void InicioMenuBtnMouseClicked(java.awt.event.MouseEvent evt) {
    	close();
    	Inicio i = new Inicio();
    	i.setVisible(true);
    }
    
    private void SociosMenuBtnMouseClicked(java.awt.event.MouseEvent evt) {
    	close();
    	Socios s = new Socios();
    	s.setVisible(true);
    }
    
    private void IngresosMenuBtnMouseClicked(java.awt.event.MouseEvent evt) {
    	close();
    	Ingresos i = new Ingresos();
    	i.setVisible(true);
    }
    
    private void PagosMenuBtnMouseClicked(java.awt.event.MouseEvent evt) {
    	close();
    	Pagos p = new Pagos();
    	p.setVisible(true);
    }
    
    private void InformeMenuBtnMouseClicked(java.awt.event.MouseEvent evt) {
    	close();
    	Informe i = new Informe();
    	i.setVisible(true);
    }

    private void ActualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularBtnActionPerformed
        // TODO add your handling code here:
    	actualizar();
    }//GEN-LAST:event_CalcularBtnActionPerformed

    private void IngresosMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresosMenuBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresosMenuBtnActionPerformed

    private void SociosMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SociosMenuBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SociosMenuBtnActionPerformed

    private void InformeMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InformeMenuBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InformeMenuBtnActionPerformed
    
    private void close() {
    	WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    private void actualizar() {
    	es.yoshibv.contasoc.listaespera.ListaEsperaGetter le = new es.yoshibv.contasoc.listaespera.ListaEsperaGetter();
		List<String> hortelanos = le.getHortelanos().stream().map(x->x.toString()).toList();
		List<List<String>> auxContainer = new ArrayList<List<String>>();
		for(String s:hortelanos) {
			List<String> aux = new ArrayList<String>();
			aux.add(s.split(";")[6]);
			aux.add(s.split(";")[0]);
			aux.add(s.split(";")[4]);
			aux.add(s.split(";")[5]);
			aux.add(s.split(";")[8]);
			auxContainer.add(aux);
		}
		
		final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
		defaultTableCellRenderer.setHorizontalTextPosition(SwingConstants.LEFT);
		int j = 0;
		for(List<String> aux:auxContainer) {
			for(int i = 0; i < 5; i++) {
				jTable1.getColumnModel().getColumn(i).setCellRenderer(defaultTableCellRenderer);
				jTable1.setValueAt(aux.get(i),j,i);
			}
			j++;

		}
    }


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
        	/*for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        	}*/
        	javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaEspera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarBtn;
    private javax.swing.JPanel DataPanel;
    private javax.swing.JPanel ExitBtn;
    private javax.swing.JLabel ExitTxt;
    private javax.swing.JButton InformeMenuBtn;
    private javax.swing.JButton IngresosMenuBtn;
    private javax.swing.JButton InicioMenuBtn;
    private javax.swing.JToolBar MenuToolBar;
    private javax.swing.JPanel MiddlePanel;
    private javax.swing.JPanel MinimizeBtn;
    private javax.swing.JLabel MinimizeTxt;
    private javax.swing.JButton PagosMenuBtn;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JButton SociosMenuBtn;
    private javax.swing.JToolBar ToolBar;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.Box.Filler toolBarFiller;
    private javax.swing.Box.Filler toolBarFiller1;
    private javax.swing.Box.Filler filler2;
    // End of variables declaration//GEN-END:variables
}

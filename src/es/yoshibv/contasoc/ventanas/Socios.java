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
import java.util.List;

import javax.swing.JTextPane;

import es.yoshibv.contasoc.ventanas.acciones.AñadirSocioBtnAction;

import java.util.ArrayList;

/**
 *
 * @author jomaa
 */
@SuppressWarnings("serial")
public class Socios extends javax.swing.JFrame {
    private int xMouse, yMouse;
    /**
     * Creates new form Socios
     */
    public Socios() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        IngresosMenuBtn = new javax.swing.JButton();
        PagosMenuBtn = new javax.swing.JButton();
        InformeMenuBtn = new javax.swing.JButton();
        ListaEsperaMenuBtn = new javax.swing.JButton();
        toolBarFiller1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        DataPanel = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();
        NumeroSocioTxt = new javax.swing.JLabel();
        NumeroSocioPanel = new javax.swing.JScrollPane();
        NumeroSocioField = new javax.swing.JTextPane();
        NombreTxt = new javax.swing.JLabel();
        NombrePanel = new javax.swing.JScrollPane();
        NombreField = new javax.swing.JTextPane();
        ApellidosTxt = new javax.swing.JLabel();
        ApellidosPanel = new javax.swing.JScrollPane();
        ApellidosField = new javax.swing.JTextPane();
        DNITxt = new javax.swing.JLabel();
        DNIPanel = new javax.swing.JScrollPane();
        DNIField = new javax.swing.JTextPane();
        DireccionTxt = new javax.swing.JLabel();
        DireccionPanel = new javax.swing.JScrollPane();
        DireccionField = new javax.swing.JTextPane();
        TelefonoTxt = new javax.swing.JLabel();
        TelefonoPanel = new javax.swing.JScrollPane();
        TelefonoField = new javax.swing.JTextPane();
        CorreoTxt = new javax.swing.JLabel();
        CorreoPanel = new javax.swing.JScrollPane();
        CorreoField = new javax.swing.JTextPane();
        NumeroHuertoTxt = new javax.swing.JLabel();
        NumeroHuertoPanel = new javax.swing.JScrollPane();
        NumeroHuertoField = new javax.swing.JTextPane();
        FechaAltaTxt = new javax.swing.JLabel();
        FechaAltaPanel = new javax.swing.JScrollPane();
        FechaAltaField = new javax.swing.JTextPane();
        FechaBajaTxt = new javax.swing.JLabel();
        FechaBajaPanel = new javax.swing.JScrollPane();
        FechaBajaField = new javax.swing.JTextPane();
        EstadoTxt = new javax.swing.JLabel();
        EstadoPanel = new javax.swing.JScrollPane();
        EstadoField = new javax.swing.JTextPane();
        TipoTxt = new javax.swing.JLabel();
        TipoPanel = new javax.swing.JScrollPane();
        TipoField = new javax.swing.JTextPane();
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
        setMaximumSize(new java.awt.Dimension(900, 600));
        setIconImage(getIconImage());
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
        jLabelLogo.setText("Contasoc - Socios");
        jLabelLogo.setIconTextGap(6);
        jLabelLogo.setMaximumSize(new java.awt.Dimension(86, 32));
        jLabelLogo.setMinimumSize(new java.awt.Dimension(86, 32));
        jLabelLogo.setName(""); // NOI18N
        jLabelLogo.setPreferredSize(new java.awt.Dimension(150, 32));
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

        IngresosMenuBtn.setText("Ingresos");
        IngresosMenuBtn.setContentAreaFilled(false);
        IngresosMenuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IngresosMenuBtn.setFocusable(false);
        IngresosMenuBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IngresosMenuBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
        InformeMenuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	InformeMenuBtnMouseClicked(evt);
            }
        });
        MenuToolBar.add(InformeMenuBtn);

        ListaEsperaMenuBtn.setText("Lista de Espera");
        ListaEsperaMenuBtn.setContentAreaFilled(false);
        ListaEsperaMenuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ListaEsperaMenuBtn.setFocusable(false);
        ListaEsperaMenuBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ListaEsperaMenuBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ListaEsperaMenuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	ListaEsperaMenuBtnMouseClicked(evt);
            }
        });
        MenuToolBar.add(ListaEsperaMenuBtn);

        toolBarFiller1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toolBarFiller1.setFocusable(true);
        MenuToolBar.add(toolBarFiller1);

        getContentPane().add(MenuToolBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 34, 900, 25));

        DataPanel.setBackground(new java.awt.Color(255, 255, 255));

        LeftPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        LeftPanel.setPreferredSize(new java.awt.Dimension(410, 470));

        NumeroSocioTxt.setText("Número de socio:");

        NumeroSocioPanel.setViewportView(NumeroSocioField);

        NombreTxt.setText("Nombre:");

        NombrePanel.setViewportView(NombreField);

        ApellidosTxt.setText("Apellidos:");

        ApellidosPanel.setViewportView(ApellidosField);

        DNITxt.setText("DNI:");

        DNIPanel.setViewportView(DNIField);

        DireccionTxt.setText("Dirección");

        DireccionPanel.setViewportView(DireccionField);

        TelefonoTxt.setText("Teléfono:");

        TelefonoPanel.setViewportView(TelefonoField);

        CorreoTxt.setText("Correo:");

        CorreoPanel.setViewportView(CorreoField);

        NumeroHuertoTxt.setText("Número de huerto:");

        NumeroHuertoPanel.setViewportView(NumeroHuertoField);

        FechaAltaTxt.setText("Fecha de alta:");

        FechaAltaPanel.setViewportView(FechaAltaField);

        FechaBajaTxt.setText("Fecha de baja:");

        FechaBajaPanel.setViewportView(FechaBajaField);

        EstadoTxt.setText("Estado:");

        EstadoPanel.setViewportView(EstadoField);

        TipoTxt.setText("Tipo:");

        TipoPanel.setViewportView(TipoField);

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addComponent(NumeroSocioTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(NumeroSocioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addComponent(ApellidosTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(ApellidosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addComponent(DNITxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(DNIPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addComponent(DireccionTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(DireccionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addComponent(TelefonoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(TelefonoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addComponent(CorreoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(CorreoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addComponent(NumeroHuertoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(NumeroHuertoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addComponent(FechaAltaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(FechaAltaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addComponent(FechaBajaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(FechaBajaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addComponent(EstadoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(EstadoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addComponent(TipoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(TipoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addComponent(NombreTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(NombrePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NumeroSocioPanel)
                    .addComponent(NumeroSocioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NombrePanel)
                    .addComponent(NombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ApellidosPanel)
                    .addComponent(ApellidosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DNIPanel)
                    .addComponent(DNITxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DireccionPanel)
                    .addComponent(DireccionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TelefonoPanel)
                    .addComponent(TelefonoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CorreoPanel)
                    .addComponent(CorreoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NumeroHuertoPanel)
                    .addComponent(NumeroHuertoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FechaAltaPanel)
                    .addComponent(FechaAltaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FechaBajaPanel)
                    .addComponent(FechaBajaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EstadoPanel)
                    .addComponent(EstadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TipoPanel)
                    .addComponent(TipoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 100, Short.MAX_VALUE))
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
    
    private void InicioMenuBtnMouseClicked(java.awt.event.MouseEvent evt) {
    	close();
    	Inicio i = new Inicio();
    	i.setVisible(true);
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
    
    private void ListaEsperaMenuBtnMouseClicked(java.awt.event.MouseEvent evt) {
    	close();
    	ListaEspera l = new ListaEspera();
    	l.setVisible(true);
    }

    private void AgregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBtnActionPerformed
        // TODO add your handling code here:
    	AñadirSocioBtnAction.añadirSocio(getTextFields());
    }//GEN-LAST:event_AgregarBtnActionPerformed
    
    private void close() {
    	WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    public List<JTextPane> getTextFields(){
    	List<JTextPane> aux = new ArrayList<JTextPane>();
    	aux.add(NombreField);
    	aux.add(ApellidosField);
    	aux.add(DNIField);
    	aux.add(DireccionField);
    	aux.add(TelefonoField);
    	aux.add(NumeroSocioField);
    	aux.add(NumeroHuertoField);
    	aux.add(FechaAltaField);
    	aux.add(FechaBajaField);
    	aux.add(EstadoField);
    	aux.add(TipoField);
    	return aux;
    }
    
    public List<String> getData() {
    	List<JTextPane> aux = new ArrayList<JTextPane>();
    	List<String> res = new ArrayList<String>();
    	for(JTextPane tp:aux) {
    		res.add(tp.getText());
    	}
    	return res;
    }
    
    public void setData(List<String> data) {
    	List<JTextPane> aux = getTextFields();
    	int i = 0;
    	while(i < aux.size()) {
    		for(String s:data) {
        		aux.get(i).setText(s);
        		i++;
        	}
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Socios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Socios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Socios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Socios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Socios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarBtn;
    private javax.swing.JTextPane ApellidosField;
    private javax.swing.JScrollPane ApellidosPanel;
    private javax.swing.JLabel ApellidosTxt;
    private javax.swing.JButton BuscarBtn;
    private javax.swing.JTextPane CorreoField;
    private javax.swing.JScrollPane CorreoPanel;
    private javax.swing.JLabel CorreoTxt;
    private javax.swing.JTextPane DNIField;
    private javax.swing.JScrollPane DNIPanel;
    private javax.swing.JLabel DNITxt;
    private javax.swing.JPanel DataPanel;
    private javax.swing.JTextPane DireccionField;
    private javax.swing.JScrollPane DireccionPanel;
    private javax.swing.JLabel DireccionTxt;
    private javax.swing.JButton EliminarBtn;
    private javax.swing.JTextPane EstadoField;
    private javax.swing.JScrollPane EstadoPanel;
    private javax.swing.JLabel EstadoTxt;
    private javax.swing.JPanel ExitBtn;
    private javax.swing.JLabel ExitTxt;
    private javax.swing.JTextPane FechaAltaField;
    private javax.swing.JScrollPane FechaAltaPanel;
    private javax.swing.JLabel FechaAltaTxt;
    private javax.swing.JTextPane FechaBajaField;
    private javax.swing.JScrollPane FechaBajaPanel;
    private javax.swing.JLabel FechaBajaTxt;
    private javax.swing.JButton InformeMenuBtn;
    private javax.swing.JButton IngresosMenuBtn;
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
    private javax.swing.JTextPane NombreField;
    private javax.swing.JScrollPane NombrePanel;
    private javax.swing.JLabel NombreTxt;
    private javax.swing.JTextPane NumeroHuertoField;
    private javax.swing.JScrollPane NumeroHuertoPanel;
    private javax.swing.JLabel NumeroHuertoTxt;
    private javax.swing.JTextPane NumeroSocioField;
    private javax.swing.JScrollPane NumeroSocioPanel;
    private javax.swing.JLabel NumeroSocioTxt;
    private javax.swing.JButton PagosMenuBtn;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JTextPane TelefonoField;
    private javax.swing.JScrollPane TelefonoPanel;
    private javax.swing.JLabel TelefonoTxt;
    private javax.swing.JTextPane TipoField;
    private javax.swing.JScrollPane TipoPanel;
    private javax.swing.JLabel TipoTxt;
    private javax.swing.JToolBar ToolBar;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.Box.Filler toolBarFiller;
    private javax.swing.Box.Filler toolBarFiller1;
    // End of variables declaration//GEN-END:variables
}

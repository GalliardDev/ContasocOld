package es.yoshibv.contasoc.gui;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class JFrameArrastrable extends JFrame {
    private int initialX;
    private int initialY;

    public JFrameArrastrable() {
        setUndecorated(true); // Establece el JFrame como undecorated
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Agrega un MouseListener al JFrame
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // Guarda la posición inicial del mouse
                initialX = e.getX();
                initialY = e.getY();
            }
        });

        // Agrega un MouseMotionListener al JFrame
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                // Calcula la diferencia entre la posición actual y la inicial del mouse
                int xOffset = e.getX() - initialX;
                int yOffset = e.getY() - initialY;

                // Actualiza la posición del JFrame sumando la diferencia
                setLocation(getLocation().x + xOffset, getLocation().y + yOffset);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrameArrastrable frame = new JFrameArrastrable();
            frame.setVisible(true);
        });
    }
}

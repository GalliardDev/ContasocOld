package es.exmaster.contasoc.util;

import java.awt.Toolkit;

public class ResourceTest {
    public static void main(String[] args) {
        java.awt.Image awtImg = Toolkit.getDefaultToolkit()
            .getImage(ClassLoader.getSystemResource("imagenes/logohuerto_sinletras.png"));
        if (awtImg == null) {
            System.out.println("Image not found.");
        } else {
            System.out.println("Image found.");
        }
    }
}


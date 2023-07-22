package es.exmaster.contasoc.test;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.io.ObjectInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.InvalidKeyException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;

public class CodePlayground {

    public static byte[] encrypt(String plainText, PublicKey publicKey) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(plainText.getBytes());
    }

    public static String decrypt(byte[] encryptedText, PrivateKey privateKey) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedText);
        return new String(decryptedBytes);
    }

    public static void saveKeyToFile(Key key, String fileName) throws Exception {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(key);
        oos.close();
        fos.close();
    }

    public static Key loadKeyFromFile(String fileName) throws Exception {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Key key = (Key) ois.readObject();
        ois.close();
        fis.close();
        return key;
    }

    public static void main(String[] args) {
        /*try {
            // Generar un par de claves RSA
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // Texto sin encriptar
            String plainText = "Hola, esto es un mensaje secreto.";

            // Encriptar
            byte[] encryptedText = encrypt(plainText, publicKey);
            System.out.println("Texto encriptado: " + new String(encryptedText));

            // Guardar la clave pública en un archivo
            saveKeyToFile(publicKey, "publicKey.key");

            // Guardar la clave privada en un archivo
            saveKeyToFile(privateKey, "privateKey.key");

            // Cargar la clave pública desde el archivo
            PublicKey loadedPublicKey = (PublicKey) loadKeyFromFile("publicKey.key");

            // Cargar la clave privada desde el archivo
            PrivateKey loadedPrivateKey = (PrivateKey) loadKeyFromFile("privateKey.key");

            // Desencriptar
            String decryptedText = decrypt(encryptedText, loadedPrivateKey);
            System.out.println("Texto desencriptado: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    	URL url = ClassLoader.getSystemResource("imagenes/newlogo.png");
    	if (url != null) {
    	    System.out.println("URL de la imagen: " + url.toString());
    	} else {
    	    System.out.println("La URL de la imagen es null. Verifica la ruta del recurso.");
    	}
    }
}

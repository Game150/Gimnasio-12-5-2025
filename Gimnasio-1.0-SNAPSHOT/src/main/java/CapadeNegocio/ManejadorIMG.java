/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapadeNegocio;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author game150
 */
public class ManejadorIMG {

    public static String guardarImagen(File archivo) {
        String Mensaje = "";
        try {
            BufferedImage imagen = ImageIO.read(archivo);
            File carpetaDestino = new File("/Web Pages/ProfileIMG");
            
            if (!archivo.exists()){
                Mensaje = "Error: archivo recibido es vacio";
            }
            if (!carpetaDestino.exists()) {
                carpetaDestino.mkdir();
            }
            File archivoGuardado = new File(carpetaDestino, archivo.getName());
            ImageIO.write(imagen, "jpg", archivoGuardado);
            
        } catch (IOException ex) {
            Mensaje = "Ocurrio un error inesperado: "+ex;
        
        }   
         
        return Mensaje;
           
    }
}

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

    public static Object guardarImagen(File archivo) {
        Object[] mensaje = new Object[2];
        
        if(archivo == null || !archivo.exists()){
            mensaje[1] = ("El archivo proporcionado es null o no existe");
            mensaje[0] = false;
            return mensaje;
        }
        
        try {
            
            BufferedImage imagen = ImageIO.read(archivo);
            
            if (imagen == null) { 
                mensaje[0] = false;
                mensaje[1] = ("La imagen no se puedo leer o es null");
                return mensaje;
            }
            
            File carpetaDestino = new File("/Web Pages/ProfileIMG");
            
            if (!carpetaDestino.isDirectory()) {
                System.err.println("Ocurrio un error inesperado al momento de crear la carpeta");
            }
            File archivoGuardado = new File(carpetaDestino, archivo.getName());
            
            if(!ImageIO.write(imagen, "jpg", archivoGuardado)){
                mensaje[0] = false; 
                mensaje[1] = (archivo.getName());
                return mensaje;
            }
            
            mensaje[0] = true;
            mensaje[1] = ("Imagen guarda correctamente");
            return mensaje;
            
        } catch (IOException ex) {
            mensaje[0] = false;
            mensaje[1] = ("Error de escritura: "+ex);
            return mensaje;
        
        }
    }
}

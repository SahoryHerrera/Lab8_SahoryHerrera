/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8_sahoryherrera;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author sahory
 */
public class Claudilist {

    private File archivo = null;
    String Nombre;
    ArrayList<Peliculas> Canciones = new ArrayList();

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<Peliculas> getCanciones() {
        return Canciones;
    }

    public void setCanciones(ArrayList<Peliculas> Seres_Vivos) {
        this.Canciones = Seres_Vivos;
    }

    public void Agregar_Seres_Vivos(Peliculas seres_vivos) {
        this.Canciones.add(seres_vivos);
    }

    public void creararchivo(String path) {
        archivo = new File(path);
    }

    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Peliculas t : Canciones) {
                bw.write(t.getNombre()+ "|");
                bw.write(t.getPuntuacion()+ "|");
                bw.write(t.getAno() + "|");
                bw.write(t.getArtista() + "|");
                 bw.write(t.getAlbum() + "|");
                bw.write("\n");
            }

            bw.flush();
        } catch (Exception e) {

        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        if (archivo.exists()) {
            System.out.println("ENTRO");
            Scanner sc = null;
            Canciones = new ArrayList();
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter("\\|");
                while (sc.hasNext()) {
                    String Nombre = sc.next();
                    int puntuacion = sc.nextInt();
                    int ano = sc.nextInt();
                    String artista = sc.next();
                    String album = sc.next();
                    System.out.println(Nombre + "-" + puntuacion + " " + ano + " " + artista+" "+album);
                   Canciones.add(new Peliculas(Nombre, puntuacion, ano, artista,album));
                    
                }
                System.out.println("Las Peliculas" + Canciones);
            } catch (Exception e) {
            }
            sc.close();
        }//Fin del if 
    }

    public String Abrir() {
        File fichero = null;
        FileReader fr = null;
        BufferedReader br = null;
        // tf_universo.setText("");
        String Texto = "";
        try {
            JFileChooser jfc = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");//CREAMOS EL FILTRO
            jfc.setFileFilter(filtro);//Lo agrega por defecto 

            int seleccion = jfc.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                fichero = jfc.getSelectedFile();
                archivo = new File(jfc.getSelectedFile().getPath());
                fr = new FileReader(fichero);
                br = new BufferedReader(fr);
                String Linea;
                // tf_universo.setText("");
                Texto = "Los programas de la claudilist: \n";
                while ((Linea = br.readLine()) != null) {
                    // System.out.println(Linea);
                    Texto += Linea;

                    Texto += "\n";
                }
                return Texto;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            br.close();
            fr.close();
        } catch (IOException ex) {

        }
        return Texto;
    }

}

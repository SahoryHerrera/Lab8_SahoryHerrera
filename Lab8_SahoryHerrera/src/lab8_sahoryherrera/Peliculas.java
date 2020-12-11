/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8_sahoryherrera;

/**
 *
 * @author Sahory
 */
public class Peliculas {
    String Nombre;
    int puntuacion;
    int ano;
    String artista;
    String album;

    public Peliculas() {
    }

    public Peliculas(String Nombre, int puntuacion, int ano, String artista, String album) {
        this.Nombre = Nombre;
        this.puntuacion = puntuacion;
        this.ano = ano;
        this.artista = artista;
        this.album = album;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    

  

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    
 

    @Override
    public String toString() {
        return Nombre;
    }
    
}

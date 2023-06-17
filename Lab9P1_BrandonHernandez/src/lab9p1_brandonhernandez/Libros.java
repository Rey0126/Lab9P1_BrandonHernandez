/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p1_brandonhernandez;
/**
 *
 * @author brhb2
 */
public class Libros {

    private String title;
    private String autor;
    private String genero;
    private int edad;
    

    public Libros() {

    }

    public Libros(String title, String autor, String genero, int edad) {

        this.title = title;
        this.autor = autor;
        this.genero = genero;
        this.edad = edad;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String toString(){
        return title + ':' + autor;
    }

}

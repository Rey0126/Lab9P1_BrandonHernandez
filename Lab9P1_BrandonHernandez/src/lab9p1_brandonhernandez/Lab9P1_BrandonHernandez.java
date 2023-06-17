/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab9p1_brandonhernandez;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author brhb2
 */
public class Lab9P1_BrandonHernandez {

    static Scanner sc = new Scanner(System.in);
    static Scanner sc2 = new Scanner(System.in);

    static ArrayList<Libros> newLibro = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean menu = true;
        boolean accion = false;

        while (menu) {

            System.out.println("== MENU ==");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Listar Libros");
            System.out.println("3. Modificar Libro");
            System.out.println("4. Eliminar Libro");
            System.out.println("5. Buscar Libro por titulo");
            System.out.println("6. Buscar libros según autor");
            System.out.println("7. Búsqueda con filtro de genero");
            System.out.println("8. Salir");
            System.out.println("Ingrese una opcion: ");
            int opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    crearLibro();

                    accion = true;

                    break;

                case 2:

                    if (accion) {
                        printArrayList();
                    } else {
                        System.out.println("Primero debes agregar libros");
                    }

                    break;

                case 3:

                    if (accion) {
                        System.out.println("Ha ingresado la opción de modificar libros, elija el libro que modificara:");
                        printArrayList();
                        System.out.println("Ingrese el numero del Libro que quiere modificar");
                        int index = sc.nextInt();
                        System.out.println("Has seleccionado el libro " + newLibro.get(index - 1).getTitle() + " ¿Qué atributo deseas modificar?");

                        System.out.println(""" 
                                           == Sub Menu ==
                                           1. Titulo\n
                                           2. Autor\n
                                           3. Genero\n
                                           4. Edad minima
                                           """);

                        int atributo = sc.nextInt();

                        switch (atributo) {

                            case 1:

                                System.out.println("Modificara el titulo del libro, ingrese un nuevo titulo:");
                                String newTitle = sc2.nextLine();
                                newLibro.get(index - 1).setTitle(newTitle);
                                System.out.println("¡Libro modificado exitosamente!");

                                break;

                            case 2:

                                System.out.println("Modificara el autor del libro, ingrese un nuevo autor:");
                                String newAutor = sc2.nextLine();
                                newLibro.get(index - 1).setAutor(newAutor);
                                System.out.println("¡Libro modificado exitosamente!");

                                break;

                            case 3:

                                System.out.println("Modificara el genero del libro, ingrese un nuevo genero:");
                                String newGenero = sc2.nextLine();
                                newLibro.get(index - 1).setGenero(newGenero);
                                System.out.println("¡Libro modificado exitosamente!");

                                break;

                            case 4:

                                System.out.println("Modificara la edad minima, ingrese la nueva edad minima:");
                                int newEdad = sc.nextInt();
                                newLibro.get(index - 1).setEdad(newEdad);
                                System.out.println("¡Libro modificado exitosamente!");

                                break;

                        }

                    } else {
                        System.out.println("Primero debes agregar libros");
                    }

                    break;

                case 4:

                    if (accion) {

                        System.out.println("Ha ingresado la opción de eliminar libros, elija el libro que eliminara:");
                        printArrayList();
                        System.out.println("Ingrese el numero del Libro que quiere eliminar");
                        int index = sc.nextInt();
                        System.out.println("Has seleccionado el libro " + newLibro.get(index - 1).getTitle());
                        Eliminar(index - 1);
                        System.out.println("¡El Libro ha sido eliminado exitosamente!");

                    } else {
                        System.out.println("Primero debes agregar libros");
                    }

                    break;

                case 5:

                    if (accion) {

                        System.out.println("Ha ingresado la opcion buscar libro por titulo");
                        System.out.println("Ingrese el titulo a buscar");
                        String titulo = sc2.nextLine();
                        buscarTitulo(titulo);

                    } else {
                        System.out.println("Primero debes agregar libros");
                    }

                    break;

                case 6:

                    if (accion) {

                        System.out.println("Ha ingresado la opcion buscar libro por autor");
                        System.out.println("Ingrese el autor a buscar");
                        String autor = sc2.nextLine();
                        buscarAutor(autor);

                    } else {
                        System.out.println("Primero debes agregar libros");
                    }

                    break;

                case 7:

                    if (accion) {

                        System.out.println("Ha ingresado la opcion buscar libro por genero");
                        System.out.println("Ingrese el genero a buscar");
                        String genero = sc2.nextLine();
                        buscarGenero(genero);

                    } else {
                        System.out.println("Primero debes agregar libros");
                    }

                    break;

                case 8:

                    menu = false;

                    break;

                default:
                    System.out.println("Opcion Invalida!!!");
                    break;

            }

        }

    }

    public static void crearLibro() {

        System.out.println("Ha elegido la opción para agregar un libro, por favor aporte la información solicitada");
        System.out.println("Ingrese un titulo:");
        String titulo = sc2.nextLine();
        System.out.println("Ingrese el autor:");
        String autor = sc2.nextLine();
        System.out.println("Ingrese el genero:");
        String genero = sc2.nextLine();
        System.out.println("Edad minima:");
        int edad = sc.nextInt();
        while (edad < 0) {
            System.out.println("Dato invalido!!!");
            System.out.println("Edad minima:");
            edad = sc.nextInt();
        }
        Libros l = new Libros(titulo, autor, genero, edad);
        newLibro.add(l);
        System.out.println("Libro agregado exitosamente!");

    }

    public static void printArrayList() {

        for (int i = 0; i < newLibro.size(); i++) {

            System.out.println("Libro " + (i + 1));
//            Libros la = newLibro.get(i);
            System.out.println("Titulo: " + newLibro.get(i).getTitle());
            System.out.println("Autor: " + newLibro.get(i).getAutor());
            System.out.println("Genero: " + newLibro.get(i).getGenero());
            System.out.println("Edad minima: " + newLibro.get(i).getEdad());
            System.out.println();

        }

    }

    public static ArrayList<Libros> Eliminar(int index) {

        newLibro.remove(index);

        return newLibro;

    }

    public static void buscarTitulo(String titulo) {

        for (int i = 0; i < newLibro.size(); i++) {

            if (titulo.equalsIgnoreCase(newLibro.get(i).getTitle())) {

                System.out.println("Libro " + (i + 1));
//            Libros la = newLibro.get(i);
                System.out.println("Titulo: " + newLibro.get(i).getTitle());
                System.out.println("Autor: " + newLibro.get(i).getAutor());
                System.out.println("Genero: " + newLibro.get(i).getGenero());
                System.out.println("Edad minima: " + newLibro.get(i).getEdad());
                System.out.println();

            } else{
                System.out.println("No hay libros con ese titulo");
            }

        }

    }

    public static void buscarAutor(String autor) {

        for (int i = 0; i < newLibro.size(); i++) {

            if (autor.equalsIgnoreCase(newLibro.get(i).getAutor())) {

                System.out.println("Libro " + (i + 1));
//            Libros la = newLibro.get(i);
                System.out.println("Titulo: " + newLibro.get(i).getTitle());
                System.out.println("Autor: " + newLibro.get(i).getAutor());
                System.out.println("Genero: " + newLibro.get(i).getGenero());
                System.out.println("Edad minima: " + newLibro.get(i).getEdad());
                System.out.println();

            } else{
                System.out.println("No hay libros con ese autor");
            }

        }

    }

    public static void buscarGenero(String genero) {

        for (int i = 0; i < newLibro.size(); i++) {

            if (genero.equalsIgnoreCase(newLibro.get(i).getGenero())) {

                System.out.println("Libro " + (i + 1));
//            Libros la = newLibro.get(i);
                System.out.println("Titulo: " + newLibro.get(i).getTitle());
                System.out.println("Autor: " + newLibro.get(i).getAutor());
                System.out.println("Genero: " + newLibro.get(i).getGenero());
                System.out.println("Edad minima: " + newLibro.get(i).getEdad());
                System.out.println();

            } else{
                System.out.println("No hay libros con ese genero");
            }

        }

    }
}

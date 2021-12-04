package com.example.getmore;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Usuario implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private float temaCursado;
    private float calificaciones[];

    //sobrecarga de constructores
    Usuario() {
    }

    Usuario(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    //metodos

    public static void guardarUsuario(String nombre, String apellido, int edad) {

        try {
            Usuario usuario = new Usuario(nombre, apellido, edad);

            String nombreArchivo = nombre + apellido;

            Path path = Paths.get("");
            String directoryName = path.toAbsolutePath().toString();
            OutputStream os = new FileOutputStream(directoryName+nombreArchivo);
            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(usuario);
            oos.close();

            System.out.println("La escritura se a completado");


        } catch (FileNotFoundException e) {
            System.out.println("Error --> FileNotFountException" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error --> IOException" + e.getMessage());
        }

    }

    public static Usuario buscarUsuario(String nombre, String apellido) throws IOException, ClassNotFoundException {
        String nombreArchivo = nombre + apellido;
        Usuario usuario;


        InputStream is = new FileInputStream(nombreArchivo);
        ObjectInputStream ois = new ObjectInputStream(is);

        usuario = (Usuario) ois.readObject();

        ois.close();

        return usuario;
    }
}
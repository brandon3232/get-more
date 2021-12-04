package com.example.getmore;


import java.io.*;

public class Usuario implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private float temaCursado;
    private float calificaciones[];

    //sobrecarga de constructores
    Usuario(){}

    Usuario(String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
    }

    //metodos

    public static void guardarUsuario(String nombre, String apellido){

        try{
            Usuario usuario = new Usuario(nombre, apellido);

            String nombreArchivo = nombre + apellido;

            OutputStream os = new FileOutputStream(nombreArchivo);
            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(usuario);
            oos.close();

            System.out.println("La escritura se a completado");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Usuario buscarUsuario(String nombre, String apellido) throws IOException {
        Usuario usuario = new Usuario();
        String nombreArchivo = nombre + apellido;

        try {
            InputStream is = new FileInputStream(nombreArchivo);
            ObjectInputStream ois = new ObjectInputStream(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

        }

        return usuario;
    }


    //setters
    public void setTemaCursado(float temaCursado) {
        this.temaCursado = temaCursado;
    }

    public void setCalificaciones(float[] calificaciones) {
        this.calificaciones = calificaciones;
    }

}

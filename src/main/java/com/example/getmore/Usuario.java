package com.example.getmore;


public class Usuario {
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private float temaCursado;
    private float calificaciones[];

    //sobrecarga de constructores
    Usuario(){}

    Usuario(String nombre, String apellido, int edad, String sexo, float temaCursado, float calificaciones){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.sexo=sexo;
        this.temaCursado=temaCursado;


    }

    //metodos

    public Usuario guardarUsuario(String nombre, String apellido, int edad, String sexo, float temaCursado, float calificaciones){
        Usuario usuario = new Usuario(nombre, apellido, edad,sexo, temaCursado, calificaciones);

        //TODO: implementar el guardado de datos de usuario en archivo de texto


        return usuario;
    }

    public Usuario buscarUsuario(String nombre, String apellido){
        Usuario usuario = new Usuario();

        //TODO: implementar la busqueda del archivo con el nombre de usuario con su respectivo try catch(manejo de errores)

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

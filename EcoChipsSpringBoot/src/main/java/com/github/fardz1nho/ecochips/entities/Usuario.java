package com.github.fardz1nho.ecochips.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private int idRol;


    @Column(name="Nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name="contrasena", length = 50, nullable = false)
    private String contrasena;

    @Column(name="edad", length = 3, nullable = false)
    private int edad;

    @Column(name="genero", length = 50, nullable = false)
    private String genero;

    public Usuario(){}

    public Usuario(int idUsuario, String nombre, String contrasena, int edad, String genero) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.edad = edad;
        this.genero = genero;
    }

    public int getIdUsuario() {return idUsuario;}

    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getContrasena() {return contrasena;}

    public void setContrasena(String contrasena) {this.contrasena = contrasena;}

    public int getEdad() {return edad;}

    public void setEdad(int edad) {this.edad = edad;}

    public String getGenero() {return genero;}

    public void setGenero(String genero) {this.genero = genero;}
}


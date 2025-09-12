package com.github.fardz1nho.ecochips.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserDTO {
    private int idUsuario;
    private String nombre;
    private String contrasena;
    private int edad;
    private String genero;

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

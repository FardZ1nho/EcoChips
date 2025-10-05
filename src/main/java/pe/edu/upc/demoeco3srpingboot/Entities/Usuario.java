package pe.edu.upc.demoeco3srpingboot.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name="Nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "correo", length = 100, nullable = false)
    private String correo;

    @Column(name="contrasena", length = 100, nullable = false)
    private String contrasena;

    @Column(name="edad", length = 3, nullable = false)
    private int edad;

    @Column(name="genero", length = 50, nullable = false)
    private String genero;

    private Boolean enabled;

    @Column(name = "nivel", nullable = false)
    private int nivel = 1;

    @Column(name = "canjesDisponibles", nullable = false)
    private int canjesDisponibles = 0;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private List<Rol> roles;

    public Usuario(){}

    public Usuario(int idUsuario, int canjesDisponibles, int nivel, Boolean enabled, String genero, int edad, String contrasena, String correo, String nombre) {
        this.idUsuario = idUsuario;
        this.canjesDisponibles = canjesDisponibles;
        this.nivel = nivel;
        this.enabled = enabled;
        this.genero = genero;
        this.edad = edad;
        this.contrasena = contrasena;
        this.correo = correo;
        this.nombre = nombre;
    }

    public int getCanjesDisponibles() {return canjesDisponibles;}

    public void setCanjesDisponibles(int canjesDisponibles) {this.canjesDisponibles = canjesDisponibles;}

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}

package pe.edu.upc.demoeco3srpingboot.DTOs;

import java.io.Serializable;

public class JwtRequestDTO implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String username;
    private String password;
    public JwtRequestDTO() {
        super();
        // TODO Auto-generated constructor stub
    }
    public JwtRequestDTO(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

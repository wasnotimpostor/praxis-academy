package kasus.toko.vapor.message.request;

import java.util.Set;

import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;

public class SignUpForm {
    @NotBlank
    //@Size(min = 3, max = 50)
    private String nama;
 
    @NotBlank
    //@Size(min = 3, max = 50)
    private String username;
    
    private Set<String> role;
    
    @NotBlank
    //@Size(min = 5, max = 30)
    private String password;
 
    public String getNama() {
        return nama;
    }
 
    public void setNama(String nama) {
        this.nama = nama;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}
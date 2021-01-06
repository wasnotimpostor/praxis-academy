package kasus.toko.vapor.security.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import kasus.toko.vapor.model.User;

public class UserPrinciple implements UserDetails {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nama;

    private String username;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrinciple(Long id, String nama, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
            new SimpleGrantedAuthority(role.getNama().name())).collect(Collectors.toList());
            return new UserPrinciple(
                user.getId(),
                user.getNama(),
                user.getPassword(),
                user.getUsername(),
                authorities
            );
    }

    public Long getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
   
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
   
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
   
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
   
    @Override
    public boolean isEnabled() {
        return true;
    }
   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
          
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}

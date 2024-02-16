package com.todo_ec.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.todo_ec.model.entity.TodoUsuario;
import jakarta.persistence.Column;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private TodoUsuario todoUsuario;

    private String correo;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    public UserDetailsImpl(TodoUsuario todoUsuario) {
        this.todoUsuario = todoUsuario;
    }

    public String getCorreo() {
        return todoUsuario.getCorreo();
    }

    @Override
    public String getPassword() {
        return todoUsuario.getContrasena();
    }

    @Override
    public String getUsername() {
        return todoUsuario.getUsuario();
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
}

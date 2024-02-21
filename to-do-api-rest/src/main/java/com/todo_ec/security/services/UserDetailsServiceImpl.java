package com.todo_ec.security.services;

import com.todo_ec.model.entity.TodoUsuario;
import com.todo_ec.model.repository.TodoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TodoUsuarioRepository todoUsuarioRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TodoUsuario usuario = todoUsuarioRepository.findByUsuario(username)
                .orElseGet(() -> todoUsuarioRepository.findByCorreo(username)
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found with username: " + username)));
        System.out.println(username);
        return new UserDetailsImpl(usuario);
    }





}

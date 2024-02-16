package com.todo_ec.controller;

import com.todo_ec.model.DTOs.TodoLoginDTO;
import com.todo_ec.model.DTOs.TodoUsuarioDTO;
import com.todo_ec.model.entity.TodoUsuario;
import com.todo_ec.model.repository.TodoUsuarioRepository;
import com.todo_ec.security.jwt.JwtUtils;
import com.todo_ec.security.response.JwtResponse;
import com.todo_ec.security.services.TokenBlacklist;
import com.todo_ec.security.services.UserDetailsImpl;
import com.todo_ec.service.TodoUsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController  //Para indicar que es un controlador
@RequestMapping("/api/auth") //Para indicar que este controlador va ser usado como recurso
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TodoUsuarioRepository todoUsuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private TodoUsuarioService usuarioService ;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final TokenBlacklist tokenBlacklist;

    public AuthController(TokenBlacklist tokenBlacklist) {
        this.tokenBlacklist = tokenBlacklist;
    }

    @PostMapping("login")
    public ResponseEntity<?> Login( @Validated @RequestBody TodoLoginDTO todoLoginDTO){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(todoLoginDTO.getTodoUsuario(),todoLoginDTO.getTodoContrasena()));
          SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);
              UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

               return ResponseEntity.ok(new JwtResponse(jwt));

    }

    @PostMapping("/user")
    public ResponseEntity<?> create(@RequestBody TodoUsuarioDTO usuarioDTO) {
        TodoUsuario savedUser = usuarioService.save(usuarioDTO);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioDTO.getUsuario(),usuarioDTO.getContrasena()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt));


    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        // Extraer el token de la solicitud (puedes ajustar este método según tu implementación)
        String token = jwtUtils.extractTokenFromHeaderOrWherever(request);

        tokenBlacklist.addToBlacklist(token);

        // Borra cualquier dato relacionado con la sesión si es necesario

        return ResponseEntity.ok("Cerré sesión correctamente");
    }






}

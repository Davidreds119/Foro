package com.aluracursos.foro.controllers;

import com.aluracursos.foro.models.Roles;
import com.aluracursos.foro.seguridad.DatosJWTToken;
import com.aluracursos.foro.models.DatosLoginUsuario;
import com.aluracursos.foro.models.Usuario;
import com.aluracursos.foro.seguridad.TokenService;
import com.aluracursos.foro.validaciones.ValidacionExcepcion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forohub")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity autenticacionUsuario(@RequestBody @Valid DatosLoginUsuario datosLoginUsuario){
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(datosLoginUsuario.correoElectronico(),datosLoginUsuario.contrasenia());
        var rol =datosLoginUsuario.rol().toString();
        var usuarioAutenticado=authenticationManager.authenticate(authenticationToken);
        var JwtToken=tokenService.generarToken((Usuario)usuarioAutenticado.getPrincipal(),rol);
        System.out.println(JwtToken);
        return ResponseEntity.ok(new DatosJWTToken(JwtToken));
    }
}
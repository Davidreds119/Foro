package com.aluracursos.foro.seguridad;

import com.aluracursos.foro.repositorios.UsuarioRepository;
import com.aluracursos.foro.repositorios.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;


@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("filtro activado");

        var tokenRequest=request.getHeader("Authorization");
        if (tokenRequest!=null){
            tokenRequest=tokenRequest.replace("Bearer ","");
            var subject=tokenService.getSubject(tokenRequest);
            if(subject!=null){
                var usuario=usuarioRepository.findUsuarioByCorreoElectronico(subject);
                var rol=tokenService.getClaim(tokenRequest,"ROL");
                System.out.println("El ROL ingresado es de " + rol);
                System.out.println("El rol de ADMIN es el unico con acceso a rutas de PUT o DELETE");
                var authorities = List.of(new SimpleGrantedAuthority("ROLE_" + rol));
                var authentication=new UsernamePasswordAuthenticationToken(usuario,null,authorities);
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        }
        filterChain.doFilter(request,response);
    }
}

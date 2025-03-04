package com.jarida.server.jaridaserver.spring_security_2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilterTwos extends OncePerRequestFilter {

    // inject dependencies
    @Autowired
    private JwtTokenProviderTwos tokenProviderTwos;

    @Autowired
    private CustomUserDetailsServiceTwos customUserDetailsServiceTwos;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        // get JWT (token) from http request
        String token = getJWTfromRequest(request);

        // validate token
   /*     if(StringUtils.hasText(token) && tokenProviderTwos.validateToken(token)){
            // get username from token
           // String username = tokenProviderTwos.getUsernameFromJWT(token);

            // load user associated with token
            //UserDetails userDetails = customUserDetailsServiceTwos.loadUserByUsername(username);


           *//* UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()*//*
            );
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            // set spring security
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }*/
        filterChain.doFilter(request, response);
    }


    // Bearer <accessToken>
    private String getJWTfromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}

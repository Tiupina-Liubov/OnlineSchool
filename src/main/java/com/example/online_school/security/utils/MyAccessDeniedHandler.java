package com.example.online_school.security.utils;

import com.example.online_school.exception.errorMessage.ErrorMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Custom implementation of {@link AccessDeniedHandler} to handle access denied scenarios.
 * This handler will respond with a JSON message when a user attempts to access a resource without sufficient permissions.
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * Handles the access denied error by setting the response status to HTTP 403 Forbidden,
     * and writing a JSON response with the error message and details.
     *
     * @param request the {@link HttpServletRequest} object that contains the request the client made of the servlet
     * @param response the {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @param accessDeniedException the {@link AccessDeniedException} that was thrown when the user tried to access a resource without the necessary permissions
     * @throws IOException if an input or output error is detected when the servlet handles the request
     * @throws ServletException if the request could not be handled
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \"" + ErrorMessage.NO_ACCESS_RIGHTS + "\", \"details\": \"" + accessDeniedException.getMessage() + "\"}");
    }
}

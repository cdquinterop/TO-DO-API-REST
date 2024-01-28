package com.todo_ec.controller.advice;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;
@ControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Map<String, Object>> handleDataAccessException(DataAccessException e) {
        return new ResponseEntity<>(generarMensajeError("Acceso a datos fallido", HttpStatus.INTERNAL_SERVER_ERROR, e), HttpStatus.INTERNAL_SERVER_ERROR);
    }

      private Map<String, Object> generarMensajeError(String mensaje, HttpStatus status, Exception e) {
        Map<String, Object> errorAttributes = new HashMap<>();
        errorAttributes.put("timestamp", System.currentTimeMillis());
        errorAttributes.put("status", status.value());
        errorAttributes.put("error", status.getReasonPhrase());
        errorAttributes.put("message", mensaje);
        errorAttributes.put("path", e.getMessage()); // Asegúrate de proporcionar una ruta significativa o mensaje de excepción
        return errorAttributes;
    }
}

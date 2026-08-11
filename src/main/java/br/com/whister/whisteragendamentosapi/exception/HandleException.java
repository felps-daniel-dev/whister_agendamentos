package br.com.whister.whisteragendamentosapi.exception;

import br.com.whister.whisteragendamentosapi.exception.custom.*;
import br.com.whister.whisteragendamentosapi.exception.dto.ApiErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandleException {

    @ExceptionHandler(ConsultaNaoEncontrada.class)
    public ResponseEntity<ApiErrorResponseDTO> handleConsultaNaoEncontrada(
            ConsultaNaoEncontrada ex,
            HttpServletRequest request
    ){
        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                "Recurso não encontrado!",
                ex.getMessage(),
                request.getRequestURI()
        );
    }

    @ExceptionHandler(SalaNaoEncontrada.class)
    public ResponseEntity<ApiErrorResponseDTO> handleSalaNaoEncontrada(
            SalaNaoEncontrada ex,
            HttpServletRequest request
    ){
        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                "Recurso não encontrado!",
                ex.getMessage(),
                request.getRequestURI()
        );
    }

    @ExceptionHandler(PlanoNaoEncontrado.class)
    public ResponseEntity<ApiErrorResponseDTO> handlePlanoNaoEncontrado(
            PlanoNaoEncontrado ex,
            HttpServletRequest request
    ){
        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                "Recurso não encontrado!",
                ex.getMessage(),
                request.getRequestURI()
        );
    }


    @ExceptionHandler(EspecialidadeNaoEncontrada.class)
    public ResponseEntity<ApiErrorResponseDTO> handleEspecialidadeNaoEncontrada(
            EspecialidadeNaoEncontrada ex,
            HttpServletRequest request
    ){
        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                "Recurso não encontrado!",
                ex.getMessage(),
                request.getRequestURI()
        );
    }

    @ExceptionHandler(MedicoNaoEncontrado.class)
    public ResponseEntity<ApiErrorResponseDTO> handleMedicoNaoEncontrado(
            MedicoNaoEncontrado ex,
            HttpServletRequest request
    ){
        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                "Recurso não encontrado!",
                ex.getMessage(),
                request.getRequestURI()
        );
    }

    @ExceptionHandler(NenhumPacienteEncontrado.class)
    public ResponseEntity<ApiErrorResponseDTO> handleNenhumPacienteEncontrado(
            NenhumPacienteEncontrado ex,
            HttpServletRequest request
    ){
        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                "Recurso não encontrado!",
                ex.getMessage(),
                request.getRequestURI()
        );
    }


    @ExceptionHandler(PacienteNaoEncontrado.class)
    public ResponseEntity<ApiErrorResponseDTO> handlePacienteNaoEncontrado(
            PacienteNaoEncontrado ex,
            HttpServletRequest request
    ){
        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                "Recurso não encontrado!",
                ex.getMessage(),
                request.getRequestURI()
        );
    }





    private ResponseEntity<ApiErrorResponseDTO> buildErrorResponse(
            HttpStatus status,
            String error,
            String message,
            String path
    ) {
        ApiErrorResponseDTO erroResponse = new ApiErrorResponseDTO(
                LocalDateTime.now(),
                status.value(),
                error,
                message,
                path
        );
        return ResponseEntity.status(status).body(erroResponse);
    }
}

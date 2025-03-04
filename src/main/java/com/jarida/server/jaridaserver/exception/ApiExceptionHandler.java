package com.jarida.server.jaridaserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    /*@ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<Object> handleApiRequestException(CustomException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiExceptionResponse apiException = new ApiExceptionResponse(
                e.getMessage(),
                e.getLocalizedMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return  new ResponseEntity<>(apiException, badRequest);
    }*/

    @ExceptionHandler(ResourceSuccessfulException.class)
    public ResponseEntity<ApiExceptionResponse> resourceSuccessfulFound(ResourceSuccessfulException ex) {
        HttpStatus successful = HttpStatus.OK;
        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setHttpStatus(successful);
        response.setMessage(ex.getMessage());
        response.setStatusCode(successful.value());
        response.setLocalizedMessage(ex.getLocalizedMessage());
        response.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(response, successful);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setHttpStatus(notFound);
        response.setMessage(ex.getMessage());
        response.setStatusCode(notFound.value());
        response.setLocalizedMessage(ex.getLocalizedMessage());
        response.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(response, notFound);
    }

    @ExceptionHandler(ResourceNoContentFoundException.class)
    public ResponseEntity<ApiExceptionResponse> resourceNoContentFound(ResourceNoContentFoundException ex) {
        HttpStatus noContent = HttpStatus.NO_CONTENT;
        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setHttpStatus(noContent);
        response.setMessage(ex.getMessage());
        response.setStatusCode(noContent.value());
        response.setLocalizedMessage(ex.getLocalizedMessage());
        response.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(response, noContent);
    }

    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<ApiExceptionResponse> resourceAlreadyExist(ResourceAlreadyExists ex) {
        HttpStatus alreadyExist = HttpStatus.CONFLICT;
        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setHttpStatus(alreadyExist);
        response.setMessage(ex.getMessage());
        response.setStatusCode(alreadyExist.value());
        response.setLocalizedMessage(ex.getLocalizedMessage());
        response.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(response, alreadyExist);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ApiExceptionResponse> badRequestException(ResourceBadRequestException ex) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setHttpStatus(badRequest);
        response.setMessage(ex.getMessage());
        response.setStatusCode(badRequest.value());
        response.setLocalizedMessage(ex.getLocalizedMessage());
        response.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(response, badRequest);
    }

    @ExceptionHandler(ResourceUnauthorizedException.class)
    public ResponseEntity<ApiExceptionResponse> unauthorizedException(ResourceUnauthorizedException ex) {
        HttpStatus unauthorizedRequest = HttpStatus.UNAUTHORIZED;
        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setHttpStatus(unauthorizedRequest);
        response.setMessage(ex.getMessage());
        response.setStatusCode(unauthorizedRequest.value());
        response.setLocalizedMessage(ex.getLocalizedMessage());
        response.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(response, unauthorizedRequest);
    }

    @ExceptionHandler(ResourceForbiddenException.class)
    public ResponseEntity<ApiExceptionResponse> forbiddenException(ResourceForbiddenException ex) {
        HttpStatus forbiddenRequest = HttpStatus.FORBIDDEN;
        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setHttpStatus(forbiddenRequest);
        response.setMessage(ex.getMessage());
        response.setStatusCode(forbiddenRequest.value());
        response.setLocalizedMessage(ex.getLocalizedMessage());
        response.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(response, forbiddenRequest);
    }

    @ExceptionHandler(ResourceUnsupportedMediaTypeException.class)
    public ResponseEntity<ApiExceptionResponse> forbiddenException(ResourceUnsupportedMediaTypeException ex) {
        HttpStatus unsupportedMediaTypeRequest = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setHttpStatus(unsupportedMediaTypeRequest );
        response.setMessage(ex.getMessage());
        response.setStatusCode(unsupportedMediaTypeRequest .value());
        response.setLocalizedMessage(ex.getLocalizedMessage());
        response.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(response, unsupportedMediaTypeRequest );
    }

    @ExceptionHandler(ResourceInternalServerException.class)
    public ResponseEntity<ApiExceptionResponse> forbiddenException(ResourceInternalServerException ex) {
        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setHttpStatus(internalServerError );
        response.setMessage(ex.getMessage());
        response.setStatusCode(internalServerError .value());
        response.setLocalizedMessage(ex.getLocalizedMessage());
        response.setTimeStamp(ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(response, internalServerError );
    }



}

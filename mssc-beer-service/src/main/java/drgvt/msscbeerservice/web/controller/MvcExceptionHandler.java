package drgvt.msscbeerservice.web.controller;/*
 Created by KonstantinAndrievski on 10/21/2026.
 */

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {

    ResponseEntity<List> validationErrorHandler(ConstraintViolationException e ) {
        List<String> errorList = new ArrayList<>(e.getConstraintViolations().size());
        e.getConstraintViolations().forEach(error -> errorList.add(error.toString()));

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);

    }
}


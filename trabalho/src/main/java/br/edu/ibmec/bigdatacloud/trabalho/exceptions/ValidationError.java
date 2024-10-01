package br.edu.ibmec.bigdatacloud.trabalho.exceptions;

import lombok.Data;

@Data
public class ValidationError {
    private String field;
    private String message;
}
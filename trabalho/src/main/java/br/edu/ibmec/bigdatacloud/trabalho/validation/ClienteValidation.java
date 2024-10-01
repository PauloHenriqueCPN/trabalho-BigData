package br.edu.ibmec.bigdatacloud.trabalho.validation;

import java.time.LocalDate;
import java.time.Period;

import br.edu.ibmec.bigdatacloud.trabalho.model.Cliente;

public class ClienteValidation {

    public static boolean isMaiorDeIdade(Cliente cliente) {
        LocalDate dataNascimento = cliente.getDtNascimento().toLocalDate();
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        return idade >= 18;
    }

}

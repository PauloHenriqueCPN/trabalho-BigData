package br.edu.ibmec.bigdatacloud.trabalho.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.NumberFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s ]+$", message = "O nome deve ser válido")
    @NotBlank(message = "Campo nome obrigatório")
    private String nome;

    @Column
    @NotBlank(message = "Campo CPF obrigatório")
    @Pattern(regexp = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$", message = "Insira um CPF válido, no formato XXX.XXX.XXX-XX")
    @CPF(message = "CPF inválido")
    private String cpf;

    @Column
    @NotBlank(message = "Campo e-mail obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @Column
    @NotBlank(message = "Campo data de nascimento obrigatório")
    @Past(message = "Insira uma data válida")
    private LocalDateTime dtNascimento;

    @Column
    @Pattern(regexp = "^\\d{7}-\\d{4}$", message = "Número inválido")
    private int telefone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos = new ArrayList<>();

}

package br.edu.ibmec.bigdatacloud.trabalho.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotBlank(message = "Campo rua obrigatório")
    @Size(min = 3, max = 255, message = "A Rua deve ter entre 3 e 255 caracteres")
    private String rua;

    @Column
    @NotBlank(message = "Campo número obrigatório")
    @Pattern(regexp = "^(?=.*\\d)[a-zA-Z0-9 ]+$", message = "Insira um número válido")
    private String numero;

    @Column
    @NotBlank(message = "Campo bairro obrigatório")
    @Size(min = 3, max = 100, message = "O Bairro deve ter entre 3 e 100 caracteres")
    private String bairro;

    @Column
    @NotBlank(message = "Campo cidade obrigatório")
    @Size(min = 2, max = 100, message = "A Cidade deve ter entre 3 e 100 caracteres")
    private String cidade;

    @Column
    @NotBlank(message = "Campo estado obrigatório")
    @Pattern(regexp = "^(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)$",
    message = "Insira um estado válido em formato de sigla, exemplo: RJ")
    private String estado;

    @Column
    @NotBlank(message = "Campo CEP obrigatório")
    @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "Insira um CEP válido, no formato XXXXX-XXX")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}

package br.edu.ibmec.bigdatacloud.trabalho.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class Comment {

    @Id
    private int id;

    @Column
    private String username;

    @Column
    private String description;

    @Column
    private LocalDateTime dtComment;
}

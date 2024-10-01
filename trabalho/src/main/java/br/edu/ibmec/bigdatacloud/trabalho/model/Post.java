package br.edu.ibmec.bigdatacloud.trabalho.model;

import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;
import br.edu.ibmec.bigdatacloud.trabalho.model.Comment;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String article;

    @Column
    private LocalDate dtCreateDate;

    @OneToMany
    @JoinColumn(referencedColumnName = "id", name = "post_id")
    private ArrayList<Comment> comments;
}

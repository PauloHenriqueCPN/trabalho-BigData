package br.edu.ibmec.bigdatacloud.trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.bigdatacloud.trabalho.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}

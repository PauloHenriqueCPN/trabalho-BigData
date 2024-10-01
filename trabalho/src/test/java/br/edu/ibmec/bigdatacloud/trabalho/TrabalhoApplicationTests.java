package br.edu.ibmec.bigdatacloud.trabalho;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@EnableJpaRepositories("br.edu.ibmec.bigdatacloud.trabalho.repository")
class TrabalhoApplicationTests {

	@Test
	void contextLoads() {
	}

}

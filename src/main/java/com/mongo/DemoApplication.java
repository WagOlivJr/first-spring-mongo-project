package com.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication //Indica ao spring onde está a classe que pssoui p metodo main e o spring context da aplicação
//@EnableMongoRepositories("com.mongo.repository") //Esta anotação e a debaixo são subsituidas pela de cima
//@ComponentScan("com.mongo.*") // indica onde spring deve escanear componentes da aplicação.
// Quando não especificado, spring busca comonentes dentro do pacote e a que a classe pertence e subspacotes dele
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args); // dentro da classe que possui main, StringApplication.run recebe a propria classe como argumento.
		// Isso é suficiente para Spring iniciar a aplicação
	}

}

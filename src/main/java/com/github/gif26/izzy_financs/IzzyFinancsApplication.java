package com.github.gif26.izzy_financs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IzzyFinancsApplication {
	
	//******************TODO CLASSE CATEGORIA******************
	//TODO: Fazer validação se categoria existe

	//TODO: Descobrir o que é mais viavel :
	// * deixar deletar a categoria mesmo atrelada a alguma transação
	// * ou fazer o usuario apagar todas as transaçoes

	//******************TODO CLASSE TRANSACAO******************
	//TODO: Refazer fluxo

	public static void main(String[] args) {
		SpringApplication.run(IzzyFinancsApplication.class, args);
	}

}

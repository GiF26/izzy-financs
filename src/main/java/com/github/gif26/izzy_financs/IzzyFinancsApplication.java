package com.github.gif26.izzy_financs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IzzyFinancsApplication {
	/*TODO :
		* APAGAR AS COLUNAS SEQUENCE_ID
		* TROCAR O NOME DAS COLUNAS "VISIBLE" PARA ACTIVE
		* TROCAR O NOME DAS COLUNAS "DESCRIPTION" PARA TITULO
	 */
	public static void main(String[] args) {
		SpringApplication.run(IzzyFinancsApplication.class, args);
	}
}

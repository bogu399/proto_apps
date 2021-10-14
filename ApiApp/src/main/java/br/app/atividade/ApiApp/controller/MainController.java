package br.app.atividade.ApiApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller básico para a raiz da aplicação.
 * 
 * @author Paulo Alessander
 * @since 02/10/2021
 */

@RestController
@RequestMapping("/")
public class MainController {
	
	@GetMapping
	public String hello() {
		return "Verificar atual estado acesse <b>/actuator/health</b>, acesso ao banco de dados em <b>/h2-console</b> \n acesso a lista no link <b>/curso</b>";
	}
	
}

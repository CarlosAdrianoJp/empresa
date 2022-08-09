package com.livmall.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.livmall.entities.CheckIn;
import com.livmall.entities.Encomenda;
import com.livmall.entities.Funcionario;
import com.livmall.entities.enums.Funcao;
import com.livmall.entities.enums.Turno;
import com.livmall.repositories.CheckInRepositorio;
import com.livmall.repositories.EncomendaRepositorio;
import com.livmall.repositories.FuncionarioRepositorio;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private FuncionarioRepositorio funcionarioRepositorio;

	@Autowired
	private EncomendaRepositorio encomendaRepositorio;
	
	@Autowired
	private CheckInRepositorio checkInRepositorio;

	@Override
	public void run(String... args) throws Exception {

		Funcionario f1 = new Funcionario(null, "Adriano", "988544561", "123456", Turno.NOITE, Funcao.PORTARIA);
		Funcionario f2 = new Funcionario(null, "rafael", "911111111", "987654", Turno.NOITE, Funcao.PORTARIA);
		Funcionario f3 = new Funcionario(null, "talita", "922222222", "111222", Turno.MANHA, Funcao.ADMINISTRACAO);
		Funcionario f4 = new Funcionario(null, "ramos", "933333333", "333444", Turno.MANHA, Funcao.LIMPEZA);

		funcionarioRepositorio.saveAll(Arrays.asList(f1, f2, f3, f4));

		Encomenda e1 = new Encomenda(null, "dr wilmar", 1, 401, "pacote com instrumentos dentais",Instant.parse("2019-06-20T19:53:07Z"), f1);
		Encomenda e2 = new Encomenda(null, "Elektra", 1, 203, "pacote eletronico",Instant.parse("2019-06-20T19:53:07Z"), f1);
		Encomenda e3 = new Encomenda(null, "Ricardo Arruda", 1, 301, "pacote simples",Instant.parse("2019-06-20T19:53:07Z"), f1);
		Encomenda e4 = new Encomenda(null, "Kamila", 1, 523, "pacote grande", Instant.parse("2019-06-20T19:53:07Z"),f3);
		Encomenda e5 = new Encomenda(null, "Henrique", 1, 939, "pacote pequeno", Instant.parse("2019-06-20T19:53:07Z"),f3);
		Encomenda e6 = new Encomenda(null, "Josinaldo", 1, 707, "livros", Instant.parse("2019-06-20T19:53:07Z"), f2);

		encomendaRepositorio.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6));
		
		
		CheckIn c1 = new CheckIn(null, "bob", "101", "marcenaria", "83988706674", "3303123",Instant.parse("2021-11-20T24:00:00Z") , f2);
		CheckIn c2 = new CheckIn(null, "maria", "203", "pintura", "83111111111", "1111111",Instant.parse("2021-11-20T24:00:00Z") , f2);
		CheckIn c3 = new CheckIn(null, "bruno", "304", "moveis", "83222222222", "2222222",Instant.parse("2021-11-20T24:00:00Z") , f2);
		CheckIn c4 = new CheckIn(null, "carlos", "505", "drywalll", "84333333333", "3333333",Instant.parse("2021-11-20T24:00:00Z") , f4);
		CheckIn c5 = new CheckIn(null, "arimateia", "607", "piso", "83444444444", "4444444",Instant.parse("2021-11-20T24:00:00Z") , f4);
	
		checkInRepositorio.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
	}
	

}

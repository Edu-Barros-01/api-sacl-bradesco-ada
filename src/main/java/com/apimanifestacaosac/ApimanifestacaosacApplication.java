package com.apimanifestacaosac;

import com.apimanifestacaosac.entidades.Cliente;
import com.apimanifestacaosac.entidades.Funcionario;
import com.apimanifestacaosac.entidades.Telefone;
import com.apimanifestacaosac.enums.Cargo;
import com.apimanifestacaosac.enums.Departamento;
import com.apimanifestacaosac.enums.Tipo_Pessoa;
import com.apimanifestacaosac.enums.Tipo_Telefone;
import com.apimanifestacaosac.repository.ClienteRepository;
import com.apimanifestacaosac.repository.FuncionaRepository;
import com.apimanifestacaosac.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
@SpringBootApplication
public class ApimanifestacaosacApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private FuncionaRepository funcionaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApimanifestacaosacApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


/*		repository.save(criaCliente(Cliente.builder()
				.cpf("07685903962")
				.email("marcosaugusto@gmail.com")
				.nome("Marcus Augusto")
				.tipo_pessoa(Tipo_Pessoa.FISICA)
				.build(), null, 41, 995787237L, Tipo_Telefone.COMERCIAL));

		repository.save(criaCliente(Cliente.builder()
				.cpf("086598121")
				.email("guitschumi@gmail.com")
				.nome("Guilherme Tschumi LTDA")
				.tipo_pessoa(Tipo_Pessoa.JURIDICA)
				.build(), null, 41, 996523578L, Tipo_Telefone.CELULAR));

		funcionaRepository.save(Funcionario.builder().nome("Felipe Adriano")
				.email("felipe.adriano@bradesco.com.br")
				.departamento(Departamento.AOC)
				.cargo(Cargo.ANALISTA)
				.ativo(true)
				.build());

		funcionaRepository.save(Funcionario.builder().nome("Lucas Fernando")
				.email("lucas.fernando@bradesco.com.br")
				.departamento(Departamento.AOC)
				.cargo(Cargo.ANALISTA)
				.ativo(true)
				.build());

		funcionaRepository.save(Funcionario.builder().nome("Jose Ananias")
				.email("jose.ananias@bradesco.com.br")
				.departamento(Departamento.AOC)
				.cargo(Cargo.GERENTE)
				.ativo(true)
				.build());*/
	}

	private Cliente criaCliente(Cliente cliente, Integer id ,
								Integer ddd,
								Long numTelefone, Tipo_Telefone tipo){
		List<Telefone> telefones = new ArrayList<>();
		telefones.add(new Telefone(null, ddd, numTelefone, tipo));
		telefones.forEach(t -> telefoneRepository.save(t));

		return cliente.toBuilder().telefone(telefones).build();



	}
}

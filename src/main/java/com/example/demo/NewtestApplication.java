package com.example.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cidade;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Produto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.repositories.EstadoRepository;
import com.example.demo.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.example.demo" })
@EntityScan(basePackages = "com.example.demo.domain")
@EnableTransactionManagement
@EnableJpaRepositories
@SpringBootApplication
public class NewtestApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepo;

	@Autowired
	private ProdutoRepository produtoRepo;

	@Autowired
	private EstadoRepository estadoRepo;

	@Autowired
	private CidadeRepository cidadeRepo;

	public static void main(String[] args) {
		SpringApplication.run(NewtestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Limpeza");
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Sabão", 5.0);

		Estado est1 = new Estado(null, "Paraná");
		Cidade cid1 = new Cidade(null, "Curitiba", est1);

		cat1.getProdutos().add(p1);
		cat1.getProdutos().add(p2);
		cat2.getProdutos().add(p2);

		p1.getCategorias().add(cat1);
		p2.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);

		ArrayList<Categoria> list = new ArrayList<>();
		ArrayList<Produto> list2 = new ArrayList<>();

		list.add(cat1);
		list.add(cat2);

		list2.add(p1);
		list2.add(p2);

		categoriaRepo.saveAll(list);
		produtoRepo.saveAll(list2);
		estadoRepo.save(est1);
		cidadeRepo.save(cid1);

	}

}

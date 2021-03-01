package com.produto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.produto.model.Produto;
import com.produto.service.ProdutoService;

@RestController
@RequestMapping("/api")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value={ "/", "/home"})
	public @ResponseBody String home() {
		return "bem vindo a nossa api";
	}
	
	@GetMapping("/produtos")
	public @ResponseBody List<Produto> getProdutos(){
		return produtoService.listarProduto();
	}
	
	@PostMapping("/produtos")
	public @ResponseBody Produto postProdutos(@RequestBody Produto produto) {
		return produtoService.cadastrarProduto(produto);
	}
	
	@GetMapping("/produtos/{cod}")
	public @ResponseBody Optional<Produto> getIdProdutos(@PathVariable Long cod) {
		return produtoService.listarIdProduto(cod);
	}
	
	@PutMapping("/produtos")
	public @ResponseBody Produto updateProdutos(@RequestBody Produto produto) {
		return produtoService.cadastrarProduto(produto);
	}
		
	@DeleteMapping("/produtos/{cod}")
	public @ResponseBody Produto deleteProdutos(@PathVariable Long cod) {
		Optional<Produto> produto = getIdProdutos(cod);
		return produtoService.deletarProduto(produto);
	}

}

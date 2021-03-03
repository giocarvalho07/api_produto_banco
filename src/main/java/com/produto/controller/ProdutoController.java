package com.produto.controller;

import java.util.List;
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
import com.produto.model.StatusProduto;
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
	public @ResponseBody Produto getIdProdutos(@PathVariable Long cod) {
		return produtoService.listarIdProduto(cod);
	}
	
	@PutMapping("/produtos")
	public @ResponseBody Produto updateProdutos(@RequestBody Produto produto) {
		return produtoService.cadastrarProduto(produto);
	}
		
	@DeleteMapping("/produtos/{cod}")
	public @ResponseBody StatusProduto deleteProduto(@PathVariable Long cod) {
		StatusProduto statusProduto = new StatusProduto();
		
		try {
			Produto produto = getIdProdutos(cod);
			this.produtoService.deletarProduto(produto);
			statusProduto.setStatus("pacote removido com sucesso");
		} catch (Exception erro) {
			statusProduto.setStatus("falha na remoção do pacote - "+erro.getMessage() );
		}
		return statusProduto;
	}


}

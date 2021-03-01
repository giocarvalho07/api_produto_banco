package com.produto.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.produto.model.Produto;
import com.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> listarProduto(){
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> listarIdProduto(Long cod) {
		return produtoRepository.findById(cod);
	}
	
	public void deletarProduto(Produto produto) {
		produtoRepository.delete(produto);
	}
	
	public Produto cadastrarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
}

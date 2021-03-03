package com.produto.service;

import java.util.List;
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
	
	public Produto listarIdProduto(Long cod) {
		return produtoRepository.findById(cod).get();
	}
	
	public void deletarProduto(Produto produto) {
		produtoRepository.delete(produto);
	}
	
	public Produto cadastrarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
}

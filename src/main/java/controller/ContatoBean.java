package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Contato;
import model.Endereco;
import service.ContatoService;

@Named("contatoBean")
@ViewScoped
public class ContatoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ContatoService service;

	private List<Contato> contatos;
	private Contato novoContato;

	@PostConstruct
	public void init() {
		this.contatos = service.listAll();
		this.novoContato = new Contato();
		novoContato.setEnderecos(new ArrayList<>());
		novoContato.getEnderecos().add(new Endereco());
	}

	public void salvarOuAtualizarContato() {
		for (Endereco e : novoContato.getEnderecos()) {
			e.setContato(novoContato);
		}

		if (novoContato.getCpfCnpj() == null) {

			service.save(novoContato);
			contatos.add(novoContato);
		} else {

			service.update(novoContato);
			
		}

		novoContato = new Contato();
		novoContato.setEnderecos(new ArrayList<>());
		novoContato.getEnderecos().add(new Endereco());
	}
	
	public void remove(Contato contato) {
		service.remove(contato);
		contatos=service.listAll();
      
    }

	public List<Contato> getContatos() {
		return contatos;
	}

	public Contato getNovoContato() {
		return novoContato;
	}

	public void setNovoContato(Contato novoContato) {
		this.novoContato = novoContato;
	}
	
	public void prepararEdicao(Contato contato) {
	    this.novoContato = contato;
	}
}

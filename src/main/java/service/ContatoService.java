package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;


import model.Contato;
import repository.ContatoRepository;

@Stateless
@LocalBean
public class ContatoService {

    @EJB
    private ContatoRepository repository;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(Contato contato) {
        repository.save(contato);
    }

    public List<Contato> listAll() {
        return repository.listAll();
    }
}
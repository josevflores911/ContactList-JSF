package repository;

import model.Contato;
import model.Endereco;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ContatoRepository {

    @PersistenceContext(unitName = "sm-teste")
    private EntityManager em;

    public void save(Contato contato) {
       
        if (contato.getEnderecos() != null) {
            for (Endereco endereco : contato.getEnderecos()) {
                endereco.setContato(contato);
            }
        }

       
        em.merge(contato);
    }


    public List<Contato> listAll() {
        return em.createQuery("SELECT DISTINCT c FROM Contato c LEFT JOIN FETCH c.enderecos", Contato.class)
                 .getResultList();
        
    }
    
    
}
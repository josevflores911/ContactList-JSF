package repository;

import model.Contato;
import model.Endereco;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ContatoRepository {
	
	public static final String H2_DB="sm-teste";

    @PersistenceContext(unitName = H2_DB)
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
    
    public void update(Contato contato) {
    	em.merge(contato);
    }
    
    public void remove(Contato contato) {
    	Contato managedContato = em.merge(contato); 
        em.remove(managedContato);
    }
    
    
}
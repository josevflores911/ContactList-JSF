package bootstrap;

import service.ContatoService;
import model.Contato;
import model.Endereco;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Startup
@Singleton
public class ContatoLoader {

    @EJB
    private ContatoService contatoService;

    @PostConstruct
    public void init() {
        try {
        	//warning security check txt size 
        	 InputStream input = getClass().getClassLoader().getResourceAsStream("contatos.txt");
            
            if (input == null) {
                System.err.println("Arquivo contatos.txt não encontrado!");
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            reader.readLine(); 
            reader.readLine(); 

            Map<String, Contato> contatosMap = new HashMap<>();

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                if (line.startsWith("CpfCnpjSacado") || line.startsWith("-------")) continue; 

                
                String[] parts = line.split("\\s*\\|\\s*");

                
                if (parts.length < 7) {
                    
                    continue;
                }

                String cpfCnpj = parts[0].trim();
                String nome = parts[1].trim();
                String enderecoStr = parts[2].trim();
                String bairro = parts[3].trim();
                String cep = parts[4].trim();
                String cidade = parts[5].trim();
                String uf = parts[6].trim();

                Contato contato = contatosMap.computeIfAbsent(cpfCnpj, k -> {
                    Contato c = new Contato();
                    c.setCpfCnpj(k);
                    c.setNome(nome);
                    c.setEnderecos(new ArrayList<>());
                    return c;
                });

                Endereco endereco = new Endereco();
                endereco.setId(UUID.randomUUID().toString());
                endereco.setContato(contato);
                endereco.setEndereco(enderecoStr);
                endereco.setBairro(bairro);
                endereco.setCep(cep);
                endereco.setCidade(cidade);
                endereco.setUf(uf);

                contato.getEnderecos().add(endereco);
            }


            for (Contato contato : contatosMap.values()) {
                contatoService.save(contato);
            }

            System.out.println("Contatos importados com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
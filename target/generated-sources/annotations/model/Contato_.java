package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contato.class)
public abstract class Contato_ {

	public static volatile ListAttribute<Contato, Endereco> enderecos;
	public static volatile SingularAttribute<Contato, String> nome;
	public static volatile SingularAttribute<Contato, String> cpfCnpj;

	public static final String ENDERECOS = "enderecos";
	public static final String NOME = "nome";
	public static final String CPF_CNPJ = "cpfCnpj";

}


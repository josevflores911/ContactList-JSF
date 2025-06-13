package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Endereco.class)
public abstract class Endereco_ {

	public static volatile SingularAttribute<Endereco, String> uf;
	public static volatile SingularAttribute<Endereco, String> cidade;
	public static volatile SingularAttribute<Endereco, String> endereco;
	public static volatile SingularAttribute<Endereco, String> bairro;
	public static volatile SingularAttribute<Endereco, String> id;
	public static volatile SingularAttribute<Endereco, Contato> contato;
	public static volatile SingularAttribute<Endereco, String> cep;

	public static final String UF = "uf";
	public static final String CIDADE = "cidade";
	public static final String ENDERECO = "endereco";
	public static final String BAIRRO = "bairro";
	public static final String ID = "id";
	public static final String CONTATO = "contato";
	public static final String CEP = "cep";

}


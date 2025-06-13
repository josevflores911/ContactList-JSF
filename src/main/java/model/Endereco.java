package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private String id;

  @ManyToOne
  @JoinColumn(name="cpfCnpj", nullable=false)
  private Contato contato;

  @Column(nullable=false, length=150)
  private String endereco;

  @Column(nullable=false, length=150)
  private String bairro;

  @Column(nullable=false, length=100)
  private String cidade;

  @Column(nullable=false, length=4)
  private String uf;

  @Column(nullable=false, length=10)
  private String cep;

  public String getCep() {
    return this.cep;
  }
  
  public void setCep(final String cep) {
	    this.cep = cep;
	  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public Contato getContato() {
    return this.contato;
  }

  public void setContato(final Contato contato) {
    this.contato = contato;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(final String endereco) {
    this.endereco = endereco;
  }

  public String getBairro() {
    return this.bairro;
  }

  public void setBairro(final String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return this.cidade;
  }

  public void setCidade(final String cidade) {
    this.cidade = cidade;
  }

  public String getUf() {
    return this.uf;
  }

  public void setUf(final String uf) {
    this.uf = uf;
  }

}

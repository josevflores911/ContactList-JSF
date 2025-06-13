package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="contato")
public class Contato {

  @Id
  @Column(nullable=false, length=13)
  private String cpfCnpj;

  @Column(nullable=false, length=80)
  private String nome;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "contato")
  private List<Endereco> enderecos;

  public String getCpfCnpj() {
    return this.cpfCnpj;
  }

  public void setCpfCnpj(final String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }

  public List<Endereco> getEnderecos() {
    return this.enderecos;
  }

  public void setEnderecos(final List<Endereco> enderecos) {
    this.enderecos = enderecos;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (this.cpfCnpj == null ? 0 : this.cpfCnpj.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    final Contato other = (Contato) obj;
    if (this.cpfCnpj == null) {
      if (other.cpfCnpj != null) {
        return false;
      }
    } else if (!this.cpfCnpj.equals(other.cpfCnpj)) {
      return false;
    }
    return true;
  }

}

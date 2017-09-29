package br.com.joaops.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author João Paulo
 */
@Entity
public class Pessoa implements Serializable {
    
    @Id
    @Column(name = "id_pessoa", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "nascimento", nullable = false)
    private LocalDate nascimento;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="id_pessoa")
    private List<Contato> contatos;
    
    public Pessoa() {
        this(0L, "", LocalDate.MIN, new ArrayList<>());
    }
    
    public Pessoa(Long id, String nome, LocalDate nascimento, List<Contato> contatos) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.contatos = contatos;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public LocalDate getNascimento() {
        return nascimento;
    }
    
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    
    public List<Contato> getContatos() {
        return contatos;
    }
    
    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", contatos=" + contatos + '}';
    }
    
}
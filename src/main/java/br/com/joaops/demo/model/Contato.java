package br.com.joaops.demo.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author João Paulo
 */
@Entity
public class Contato implements Serializable {
    
    @Id
    @Column(name = "id_contato", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "label", nullable = false)
    private String label;
    
    @Column(name = "valor", nullable = false)
    private String valor;
    
    @ManyToOne
    private Pessoa pessoa;
    
    public Contato() {
        this(0L, "", "", new Pessoa());
    }
    
    public Contato(Long id, String label, String valor, Pessoa pessoa) {
        this.id = id;
        this.label = label;
        this.valor = valor;
        this.pessoa = this.pessoa;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getLabel() {
        return label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    
    public String getValor() {
        return valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Contato other = (Contato) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", label=" + label + ", valor=" + valor + '}';
    }
    
}
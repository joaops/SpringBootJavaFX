package br.com.joaops.demo.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author João Paulo
 */
public class ContatoDto implements Serializable {
    
    private Long id;
    private String label;
    private String valor;
    private PessoaDto pessoa;
    
    public ContatoDto() {
        this(0L, "", "", new PessoaDto());
    }
    
    public ContatoDto(Long id, String label, String valor, PessoaDto pessoa) {
        this.id = id;
        this.label = label;
        this.valor = valor;
        this.pessoa = pessoa;
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
    
    public PessoaDto getPessoa() {
        return pessoa;
    }
    
    public void setPessoa(PessoaDto pessoa) {
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
        final ContatoDto other = (ContatoDto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "ContatoDto{" + "id=" + id + ", label=" + label + ", valor=" + valor + '}';
    }
    
}
package br.com.joaops.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author João Paulo
 */
public class PessoaDto implements Serializable {
    
    private Long id;
    private String nome;
    private LocalDate nascimento;
    private List<ContatoDto> contatos;
    
    public PessoaDto() {
        this(0L, "", LocalDate.MIN, new ArrayList<>());
    }
    
    public PessoaDto(Long id, String nome, LocalDate nascimento, List<ContatoDto> contatos) {
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
    
    public List<ContatoDto> getContatos() {
        return contatos;
    }
    
    public void setContatos(List<ContatoDto> contatos) {
        this.contatos = contatos;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final PessoaDto other = (PessoaDto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "PessoaDto{" + "id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", contatos=" + contatos + '}';
    }
    
}
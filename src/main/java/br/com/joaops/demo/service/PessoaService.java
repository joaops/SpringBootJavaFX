/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaops.demo.service;

import br.com.joaops.demo.dto.PessoaDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author João Paulo
 */
public interface PessoaService {
    
    public long count();
    
    public void delete(Long id);
    
    public boolean exists(Long id);
    
    public List<PessoaDto> findAll();
    
    public Page<PessoaDto> findAll(Pageable p);
    
    public PessoaDto findOne(Long id);
    
    public PessoaDto save(PessoaDto pessoaDto);
    
    public PessoaDto newDto();
    
}
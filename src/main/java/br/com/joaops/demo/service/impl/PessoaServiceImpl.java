package br.com.joaops.demo.service.impl;

import br.com.joaops.demo.dto.PessoaDto;
import br.com.joaops.demo.model.Pessoa;
import br.com.joaops.demo.repository.PessoaRepository;
import br.com.joaops.demo.service.PessoaService;
import java.util.ArrayList;
import java.util.List;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author João Paulo
 */
@Service("PessoaService")
public class PessoaServiceImpl implements PessoaService {
    
    @Autowired
    private MapperFacade mapper;
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    @Override
    public long count() {
        return pessoaRepository.count();
    }
    
    @Override
    public void delete(Long id) {
        pessoaRepository.delete(id);
    }
    
    @Override
    public boolean exists(Long id) {
        return pessoaRepository.exists(id);
    }
    
    @Override
    public List<PessoaDto> findAll() {
        Iterable<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaDto> dtos = mapper.mapAsList(pessoas, PessoaDto.class);
        return dtos;
    }
    
    @Override
    public Page<PessoaDto> findAll(Pageable p) {
        List<PessoaDto> listDto = new ArrayList<>();
        Page<Pessoa> list = pessoaRepository.findAll(p);
        for (Pessoa model : list) {
            PessoaDto dto = new PessoaDto();
            mapper.map(model, dto);
            listDto.add(dto);
        }
        Page<PessoaDto> page;
        if (!listDto.isEmpty()) {
            page = new PageImpl<>(listDto, p, list.getTotalElements());
        } else {
            page = new PageImpl<>(new ArrayList<>(), p, 0);
        }
        return page;
    }
    
    @Override
    public PessoaDto findOne(Long id) {
        Pessoa pessoa = pessoaRepository.findOne(id);
        PessoaDto pessoaDto = null;
        if (pessoa != null) {
            pessoaDto = new PessoaDto();
            mapper.map(pessoa, pessoaDto);
        }
        return pessoaDto;
    }
    
    @Override
    public PessoaDto save(PessoaDto pessoaDto) {
        PessoaDto dto = null;
        Pessoa pessoa = null;
        if (pessoaDto != null) {
            pessoa = new Pessoa();
            mapper.map(pessoaDto, pessoa);
            pessoa = pessoaRepository.save(pessoa);
        }
        if (pessoa != null) {
            dto = new PessoaDto();
            mapper.map(pessoa, dto);
        }
        return dto;
    }
    
    @Override
    public PessoaDto newDto() {
        PessoaDto dto = new PessoaDto();
        return dto;
    }
    
}
package br.com.joaops.demo.repository;

import br.com.joaops.demo.model.Pessoa;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author João Paulo
 */
@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {
    
}
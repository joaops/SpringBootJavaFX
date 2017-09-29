package br.com.joaops.demo.repository;

import br.com.joaops.demo.model.Contato;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author João Paulo
 */
@Repository
public interface ContatoRepository extends PagingAndSortingRepository<Contato, Long> {
    
}
package one.digitalinnovation.gof.model;

import org.springframework.data.repository.CrudRepository;
//strategy
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}

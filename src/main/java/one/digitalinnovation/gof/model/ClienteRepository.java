package one.digitalinnovation.gof.model;

import org.springframework.data.repository.CrudRepository;
//strategy
public interface ClienteRepository  extends CrudRepository <Cliente, Long> {
}

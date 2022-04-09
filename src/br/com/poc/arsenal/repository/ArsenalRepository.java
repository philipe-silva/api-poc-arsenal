package br.com.poc.arsenal.repository;

import br.com.poc.arsenal.model.ArsenalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArsenalRepository extends JpaRepository<ArsenalModel, Long> {

}

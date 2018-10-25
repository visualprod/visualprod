package br.com.visualprodi.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.visualprodi.domain.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}

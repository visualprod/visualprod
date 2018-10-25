package br.com.visualprodi.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.visualprodi.domain.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {

}

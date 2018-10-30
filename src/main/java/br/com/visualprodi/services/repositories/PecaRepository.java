package br.com.visualprodi.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.visualprodi.domain.Peca;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Integer> {

}

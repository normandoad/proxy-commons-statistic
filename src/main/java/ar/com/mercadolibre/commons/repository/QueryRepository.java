package ar.com.mercadolibre.commons.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.mercadolibre.commons.model.Query;


public interface QueryRepository extends JpaRepository<Query, UUID> {

}

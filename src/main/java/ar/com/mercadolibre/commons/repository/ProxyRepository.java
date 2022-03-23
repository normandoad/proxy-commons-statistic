package ar.com.mercadolibre.commons.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.mercadolibre.commons.model.Proxy;


public interface ProxyRepository extends JpaRepository<Proxy, UUID> {
	
	List<Proxy> findByPort(Integer port);
	
	List<Proxy> findByEndDateIsNull();

}

package ar.com.mercadolibre.commons.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ar.com.mercadolibre.commons.model.Client;


public interface ClientRepository extends JpaRepository<Client, UUID> {
	
	
	@Query(value = "SELECT cl FROM Client cl WHERE cl.ip=:ip AND cl.id=(SELECT co.idClient FROM Query co WHERE co.queryPath=:queryPath)")
	Client findByIpAndQueryPath(@Param("ip")final String ip,@Param("queryPath")final String queryPath);
	
	Client findByIpAndIdProxy(final String ip,final UUID idProxy);
	


}

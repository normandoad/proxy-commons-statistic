package ar.com.mercadolibre.commons.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.com.mercadolibre.commons.model.Client;
import ar.com.mercadolibre.commons.model.Proxy;
import ar.com.mercadolibre.commons.model.Query;
import ar.com.mercadolibre.commons.repository.ClientRepository;
import ar.com.mercadolibre.commons.repository.ProxyRepository;
import ar.com.mercadolibre.commons.repository.QueryRepository;


@Component
@Qualifier("DataBaseService")
public class DataBaseService {
	
	private static final Logger log = LogManager.getLogger(DataBaseService.class);
	
	@Autowired(required=true)
	private ClientRepository clientRepository;
	@Autowired(required=true)
	private QueryRepository QueryRepository;
	@Autowired(required=true)
	private ProxyRepository proxyRepository;

	@Transactional(rollbackFor = java.lang.Exception.class, propagation = Propagation.REQUIRED)
	public List<Proxy> findByPort(final Integer port) {
		log.debug("start execute");
		return this.proxyRepository.findByPort(port);
	}

	@Transactional(rollbackFor = java.lang.Exception.class, propagation = Propagation.REQUIRED)
	public List<Proxy> findByEndDateIsNull() {

		return proxyRepository.findByEndDateIsNull();
	}
	
	@Transactional(rollbackFor = java.lang.Exception.class, propagation = Propagation.REQUIRED)
	public Optional<Proxy> findProxyById(final UUID id) {
		log.debug("start execute");
		return this.proxyRepository.findById(id);
	}
	
	@Transactional(rollbackFor = java.lang.Exception.class, propagation = Propagation.REQUIRED)
	public List<Proxy> findAll() {
		log.debug("start execute");
		return this.proxyRepository.findAll();
	}
	
	@Transactional(rollbackFor = java.lang.Exception.class, propagation = Propagation.REQUIRED)
	public Optional<Client> findClientById(final UUID id) {
		log.debug("start execute");
		return this.clientRepository.findById(id);
	}

	@Transactional(rollbackFor = java.lang.Exception.class, propagation = Propagation.REQUIRED)
	public void saveProxy(final Proxy proxy) {
		log.debug("start execute");
		this.proxyRepository.saveAndFlush(proxy);
	}

	@Transactional(rollbackFor = java.lang.Exception.class, propagation = Propagation.REQUIRED)
	public void saveAllProxy(List<Proxy> proxys) {
		log.debug("start execute");
		this.proxyRepository.saveAll(proxys);
	}

	@Transactional(rollbackFor = java.lang.Exception.class, propagation = Propagation.REQUIRED)
	public Client findByIpAndQueryPath(final String ip, final String queryPath) {
		log.debug("start execute");
		return this.clientRepository.findByIpAndQueryPath(ip, queryPath);
	}

	@Transactional(rollbackFor = java.lang.Exception.class, propagation = Propagation.REQUIRED)
	public Client findClienteByIpAndIdProxy(final String ip, final UUID idProxy) {
		log.debug("start execute");
		return this.clientRepository.findByIpAndIdProxy(ip, idProxy);
	}

	@Transactional(rollbackFor = java.lang.Exception.class, propagation = Propagation.REQUIRED)
	public void saveClient(final Client client) {
		log.debug("start execute");
		this.clientRepository.save(client);
	}

	@Transactional(rollbackFor = java.lang.Exception.class, propagation = Propagation.REQUIRED)
	public void saveQuery(final Query queryPath) {
		log.debug("start execute");
		this.QueryRepository.save(queryPath);
	}
}

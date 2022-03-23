package ar.com.mercadolibre.commons.locators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.mercadolibre.commons.services.DataBaseService;


@Component
public class ServiceLocator {

	private static ServiceLocator instance;
	
	@Autowired(required=true)
	DataBaseService dataBaseService;
	
	protected ServiceLocator() {
		ServiceLocator.instance = this;
	}
	
	public static DataBaseService getDataBaseService() {
		return ServiceLocator.instance.dataBaseService;
	}

}

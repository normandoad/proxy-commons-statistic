package ar.com.mercadolibre.commons.model.statistics;

import java.io.Serializable;

import org.joda.time.Period;

import lombok.Data;
import ar.com.mercadolibre.commons.model.Proxy;

@SuppressWarnings("serial")
@Data
public class ProxyStatistics implements Serializable{
	
	
	private Integer clientAttended;
	private Integer querysAttended;
	private Proxy proxy;
	private Period upTime;
}

package ar.com.mercadolibre.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="PROXY")
public class Proxy implements Serializable{
	
	@Id
    @Column(name = "id", columnDefinition = "UUID")
	private UUID id=UUID.randomUUID();
	@NotNull
    @Min(1L)
	private Integer port;
	@NotNull
    private Date initDate;
    private Date endDate;
    private String exception;
    @OneToMany(mappedBy = "idProxy", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Client> clients;

}

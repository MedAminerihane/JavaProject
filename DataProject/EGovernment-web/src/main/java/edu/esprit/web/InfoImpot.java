package edu.esprit.web;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.esprit.domain.ImpotInfo;
import edu.esprit.services.gestion.impotinfo.ImpotInfoServiceLocal;


@ManagedBean
@ViewScoped
public class InfoImpot {

	@EJB
	ImpotInfoServiceLocal impotInfoService;
		
	private ImpotInfo impotInfo;
		
	public InfoImpot() {
			
	}
		
	@PostConstruct
	public void init() {
		impotInfo = impotInfoService.findAllImpot();
		impotInfo = new ImpotInfo();
	}

	public ImpotInfo getImpotInfo() {
		return impotInfo;
	}

	public void setImpotInfo(ImpotInfo impotInfo) {
		this.impotInfo = impotInfo;
	}

}

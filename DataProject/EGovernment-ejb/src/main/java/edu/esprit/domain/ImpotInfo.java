package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ImpotInfo
 *
 */
@Entity

public class ImpotInfo implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idImpoInfo;
	private String BIC;
	private String BNC;
	private String BNCResultat;
	private String Imposition;
	private String BeneficeAgri;
	private static final long serialVersionUID = 1L;

	public ImpotInfo() {
		super();
	}   
	public Integer getIdImpoInfo() {
		return this.idImpoInfo;
	}

	public void setIdImpoInfo(Integer idImpoInfo) {
		this.idImpoInfo = idImpoInfo;
	}   
	public String getBIC() {
		return this.BIC;
	}

	public void setBIC(String BIC) {
		this.BIC = BIC;
	}   
	public String getBNC() {
		return this.BNC;
	}

	public void setBNC(String BNC) {
		this.BNC = BNC;
	}   
	public String getBNCResultat() {
		return this.BNCResultat;
	}

	public void setBNCResultat(String BNCResultat) {
		this.BNCResultat = BNCResultat;
	}   
	public String getImposition() {
		return this.Imposition;
	}

	public void setImposition(String Imposition) {
		this.Imposition = Imposition;
	}   
	public String getBeneficeAgri() {
		return this.BeneficeAgri;
	}

	public void setBeneficeAgri(String BeneficeAgri) {
		this.BeneficeAgri = BeneficeAgri;
	}
   
}

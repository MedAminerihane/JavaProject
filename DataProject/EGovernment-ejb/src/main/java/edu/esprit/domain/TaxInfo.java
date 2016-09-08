package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TaxInfo
 *
 */
@Entity

public class TaxInfo implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTaxInfo;
	private String regimeReel;
	private String regimeSimplifie;
	private String regimeSimplifierAgri;
	private static final long serialVersionUID = 1L;

	public TaxInfo() {
		super();
	}   
	public Integer getIdTaxInfo() {
		return this.idTaxInfo;
	}

	public void setIdTaxInfo(Integer idTaxInfo) {
		this.idTaxInfo = idTaxInfo;
	}   
	public String getRegimeReel() {
		return this.regimeReel;
	}

	public void setRegimeReel(String regimeReel) {
		this.regimeReel = regimeReel;
	}   
	public String getRegimeSimplifie() {
		return this.regimeSimplifie;
	}

	public void setRegimeSimplifie(String regimeSimplifie) {
		this.regimeSimplifie = regimeSimplifie;
	}   
	public String getRegimeSimplifierAgri() {
		return this.regimeSimplifierAgri;
	}

	public void setRegimeSimplifierAgri(String regimeSimplifierAgri) {
		this.regimeSimplifierAgri = regimeSimplifierAgri;
	}
   
}

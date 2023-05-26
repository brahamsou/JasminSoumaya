package fr.jasmin.enums;

public enum ProfilUserEnum {

	CLIENT ("Client"),
	MAGASINIER ("Magasinier"),
	ADMIN ("Admin");
	
	
	private String profilUser;

	private ProfilUserEnum(String profilUserr) {
		this.profilUser = profilUserr;
	}

	public String getValue() {
		return profilUser;
	}
}

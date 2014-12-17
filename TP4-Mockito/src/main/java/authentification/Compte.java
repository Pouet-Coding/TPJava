package authentification;

/**
 * Compte utilisateur permettant d'acceder au système.
 * 
 */
public class Compte {

	/**
	 * Identifiant du compte utilisateur.
	 */
	protected String identifiant;

	/**
	 * Le compte est actif (ou non).
	 */
	protected boolean actif;

	/**
	 * Créé un Compte avec un identifiant et un mot de passe donné.
	 * 
	 * @param identifiant
	 *            l'identifiant du compte
	 * @param motDePasse
	 *            le mot de passe du compte
	 */
	public Compte(String identifiant) {
		this.identifiant = identifiant;
		this.actif = true;
	}

	/**
	 * Retourne l'identifiant du compte.
	 * 
	 * @return l'identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * Modifie l'identifiant du compte.
	 * 
	 * @param identifiant
	 *            l'identifant du compte
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * Retourne un booléen spécifiant l'activité du compte.
	 * 
	 * @return <code>true</code> si le compte est actif; <br>
	 *         <code>false<code> sinon
	 */
	public boolean isActif() {
		return actif;
	}

	/**
	 * Place le compte à "actif" (true), ou "inactif" (false).
	 * 
	 * @param actif
	 *            le booléen spécifiant l'activité du compte
	 */
	public void setActif(boolean actif) {
		this.actif = actif;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + (actif ? 1231 : 1237);
		result = prime * result
				+ ((identifiant == null) ? 0 : identifiant.hashCode());

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj instanceof Compte) {
			if (identifiant == ((Compte) obj).identifiant)
				return true;
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Compte [identifiant=" + identifiant + ", actif=" + actif + "]";
	}

}

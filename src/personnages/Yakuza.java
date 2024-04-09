package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
	}

	public void extorquer(Commercant commercant) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(commercant.getNom() + ", si tu tiens à la vie donne-moi ta bourse!");
		int argentPris = commercant.seFaireExtorquer();
		gagnerArgent(argentPris);
		reputation++;
		parler("J’ai piqué les " + argentPris + " sous de Marco, ce qui me fait " + getArgent()
				+ " sous dans ma poche. Hi ! Hi !");
	}

	public String getClan() {
		return clan;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}
	
	public void perdre() {
		parler("J’ai perdu mon duel et mes "+getArgent()+" sous, snif... J'ai déshonoré le clan de "+ getClan()+".");
		perdreArgent(argent);
	}
	public void gagner(int argentGagne) {
		parler("Ce ronin pensait vraiment battre "+ getNom()+" du clan de "+clan +" ? Je l'ai dépouillé de ses " +argentGagne+" sous.");
	}
}

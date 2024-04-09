package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}

	public void donner(Commercant commercant) {
		int tenPercent = getArgent() / 10;
		perdreArgent(tenPercent);
		parler(commercant.getNom() + " prend ces " + tenPercent + " sous.");
		commercant.recevoir(tenPercent);
	}

	public void provoquer(Yakuza adversaire) {
		int force = honneur * 2;
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if (force >= adversaire.getReputation()) {
			honneur++;
			parler("Je t’ai eu petit yakusa");
			gagnerArgent(adversaire.getArgent());
			adversaire.perdre();

		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			honneur--;
			adversaire.gagner(getArgent());
			perdreArgent(argent);
		}

	}
}

package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	protected int argent;
	private int tailleMemoire = 30;
	private String[] memoire = new String[tailleMemoire];
	private int indiceMemoire = 0;
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	protected void parler(String texte) {
		System.out.println("(" + getNom() + ")" + " - " + texte);
	}

	public void direBonjour() {
		parler("Bonjour ! Je m’appelle " + nom + " et j’aime boire du " + boissonFavorite);

	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS ! ");
	}

	public void acheter(String bien, int prix) {

		if (prix <= argent) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix
					+ " sous.");
		}
		;
	}

	protected void gagnerArgent(int gain) {
		argent = argent + gain;
	}

	protected void perdreArgent(int perte) {
		argent = argent - perte;
	}
	
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(humain);
		memoriser(humain);
	}

	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}

	private void memoriser(Humain humain) {
		if (indiceMemoire == tailleMemoire-1) {
			indiceMemoire--;
			for(int i =1;i<tailleMemoire;i++) {
				memoire[i] = memoire[i-1];
			}
		}
		memoire[indiceMemoire] = humain.getNom(); 
		indiceMemoire++;
		
	}
	
	public void  listerConnaissance() {
		System.out.println("(" + getNom() + ")" + " - " + "Je connais beaucoup de monde dont: ");
		
		for (int i = 0; i < indiceMemoire; i++) {
			System.out.println(memoire[i]+", ");
		}
		System.out.println(memoire[indiceMemoire]);
	}
}

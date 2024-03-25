public class Circulation {

    public static void main(String[] args) {
        Automobile a = new Automobile(0, 50);
        Velo v = new Velo(0, "VTT");
        Vehicule vh = new Automobile(0, 0); // Corrected initialization to avoid ClassCastException
        Conducteur c = new Conducteur("Karim", "1234567");
        v.tombe();
        c.conduit(a);
        c.conduit(v);
        ((Automobile) vh).faitLePlein(10); // Corrected type casting
    }


public class Conducteur {
    private String nom;
    private String numeroPermis;
    private int acceleration;

    public Conducteur(String nom, String numeroPermis) {
        this.nom = nom;
        this.numeroPermis = numeroPermis;
        this.acceleration = 5; // Added default acceleration
    }

    public void conduit(Vehicule v) {
        System.out.println("Je suis " + nom + " et je conduis un véhicule");
        v.accelere(acceleration);
    }
}

public class Vehicule {
    protected int nbDeRoues;
    protected int vitesse; // Added vitesse attribute

    public Vehicule(int nbDeRoues, int vitesse) {
        this.nbDeRoues = nbDeRoues;
        this.vitesse = vitesse;
    }

    public void accelere(int dv) {
        vitesse += dv;
        System.out.println("Je bouge! Ma vitesse est maintenant " + vitesse);
    }
}

public class Automobile extends Vehicule {
    private int reservoir;

    public Automobile(int vitesseInitiale, int reservoir) {
        super(4, vitesseInitiale);
        this.reservoir = reservoir;
    }

    public void faitLePlein(int quantite) {
        reservoir += quantite;
        System.out.println("Il me reste " + reservoir + " litres de carburant");
    }
}

public class Velo extends Vehicule {
    private String type;

    public Velo(int vitesseInitiale, String type) {
        super(2, vitesseInitiale);
        this.type = type;
    }

    public void tombe() {
        vitesse = 0;
        System.out.println("Je suis tombé!");
    }
}
}
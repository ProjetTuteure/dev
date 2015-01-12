package gpi.metier;

/**
 * Created by thibault on 22/11/14.
 */
public class Utilise {
    private Utilisateur utilisateurUtilise;
    private Materiel materielUtilise;

    public Utilise(Utilisateur utilisateurUtilise, Materiel materielUtilise) {
        this.utilisateurUtilise = utilisateurUtilise;
        this.materielUtilise = materielUtilise;
    }

    public Utilisateur getUtilisateurUtilise() {
        return utilisateurUtilise;
    }

    public void setUtilisateurUtilise(Utilisateur utilisateurUtilise) {
        this.utilisateurUtilise = utilisateurUtilise;
    }

    public Materiel getMaterielUtilise() {
        return materielUtilise;
    }

    public void setMaterielUtilise(Materiel materielUtilise) {
        this.materielUtilise = materielUtilise;
    }
}

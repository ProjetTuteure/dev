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

    public Utilisateur getutilisateurUtilise() {
        return utilisateurUtilise;
    }

    public void setutilisateurUtilise(Utilisateur utilisateurUtilise) {
        this.utilisateurUtilise = utilisateurUtilise;
    }

    public Materiel getmaterielUtilise() {
        return materielUtilise;
    }

    public void setmaterielUtilise(Materiel materielUtilise) {
        this.materielUtilise = materielUtilise;
    }
}

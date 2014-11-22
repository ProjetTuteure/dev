package gpi.metier;

/**
 * Created by thibault on 22/11/14.
 */
public class Utilise {
    private Utilisateur utilisateur;
    private Materiel materiel;

    public Utilise(Utilisateur utilisateur, Materiel materiel) {
        this.utilisateur = utilisateur;
        this.materiel = materiel;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }
}

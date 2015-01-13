package gpi.metier;

/**
 * Created by thibault on 22/11/14.
 */
public class Utilise {
    private Utilisateur utilisateurUtilise;
    private Materiel materielUtilise;
    /**
     * Constructeur de la classe
     * @param utilisateurUtilise
     * @param materielUtilise
     */
    public Utilise(Utilisateur utilisateurUtilise, Materiel materielUtilise) {
        this.utilisateurUtilise = utilisateurUtilise;	
        this.materielUtilise = materielUtilise;
    }
    
    /**
     * Getter de UtilisateurUtilise
     * @return
     */
    public Utilisateur getUtilisateurUtilise() {
        return utilisateurUtilise;
    }

    /**
     * Setter de UtilisateurUtilise
     * @param utilisateurUtilise
     */
    public void setUtilisateurUtilise(Utilisateur utilisateurUtilise) {
        this.utilisateurUtilise = utilisateurUtilise;
    }
    
    /**
     * Getter de Materielutilise
     * @return
     */
    public Materiel getMaterielUtilise() {
        return materielUtilise;
    }

    /**
     * Setter de MaterielUtilise
     * @param materielUtilise
     */
    public void setMaterielUtilise(Materiel materielUtilise) {
        this.materielUtilise = materielUtilise;
    }
}

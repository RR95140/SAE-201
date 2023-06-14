package main;

import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

import java.util.ArrayList;

public class quadrilatere extends Forme {
    private PointPlan PSG;
    private PointPlan PID;
    private String Nom;

    // Définition des constructeurs
    
    // Constructeur par défaut
    public quadrilatere() {
        super();
        this.PSG = null;
        this.PID = null;
        this.Nom = null;
    }

    // Constructeur avec paramètres
    public quadrilatere(String unNom, PointPlan PSG, PointPlan PID) {
        this.PSG = PSG;
        this.PID = PID;
        this.Nom = unNom;
    }

    // Constructeur par copie
    public quadrilatere(quadrilatere newQuadrilatere) {
        this.Nom = newQuadrilatere.getNom();
        this.PSG = new PointPlan(newQuadrilatere.getPSG().getAbscisse(), newQuadrilatere.getPSG().getOrdonnee());
        this.PID = new PointPlan(newQuadrilatere.getPID().getAbscisse(), newQuadrilatere.getPID().getOrdonnee());
    }

    
    // Défnition des getters pour retourner les valeurs.
    public String getNom() {
        return Nom;
    }

    public PointPlan getPSG() {
        return PSG;
    }

    public PointPlan getPID() {
        return PID;
    }

    @Override
    public String getNomForme() {
        return super.getNomForme();
    }

    // Définition des setters pour modifier une valeur.
    @Override
    public void setNomForme(String nom) {
        super.setNomForme(nom);
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPID(PointPlan PID) {
        this.PID = PID;
    }

    public void setPSG(PointPlan PSG) {
        this.PSG = PSG;
    }

    
    // Définition des méthodes
    
    // Cette méthode permet de tracer une figure.
    @Override
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> segs = new ArrayList<Segment>();

        // On relie les points.
        try {
            PointPlan PD = new PointPlan(PID.getAbscisse(), PSG.getOrdonnee());
            PointPlan PG = new PointPlan(PSG.getAbscisse(), PID.getOrdonnee());

            Segment s1 = new Segment(PSG, PD);
            Segment s2 = new Segment(PD, PID);
            Segment s3 = new Segment(PID, PG);
            Segment s4 = new Segment(PG, PSG);

            segs.add(s1);
            segs.add(s2);
            segs.add(s3);
            segs.add(s4);
        } catch (Exception e) {
            System.out.println("Une exception a été détecté lors de la création des segments du quadrilatère.");
            e.printStackTrace();
        }

        return segs;
    }

    // Cette méthode permet de deplacer une figure
    @Override
    public void deplacer(int deplacementX, int deplacementY) {
        try {
            int newAbscissePSG = PSG.getAbscisse() + deplacementX; // On stocke la nouvelle abscisse du point
            int newOrdonneePSG = PSG.getOrdonnee() + deplacementY; // On stocke la nouvelle ordonnee du point
            PSG.setAbscisse(newAbscissePSG); // On modifie l'abscisse du point
            PSG.setOrdonnee(newOrdonneePSG); // On modifie l'ordonnne du point
            
            // On fait pareil avec l'autre point.
            int newAbscissePID = PID.getAbscisse() + deplacementX;
            int newOrdonneePID = PID.getOrdonnee() + deplacementY;
            PID.setAbscisse(newAbscissePID);
            PID.setOrdonnee(newOrdonneePID);
        } catch (Exception e) {
            System.out.println("Une exception a été détecté lors du déplacement du quadrilatère.");
            e.printStackTrace();
        }
    }

    // Cette méthode permet de définir le type de figure
    @Override
    public String typeForme() {
        try {
            return "Q";
        } catch (Exception e) {
            System.out.println("Une erreur a été détecté lors de la récupération du type de forme : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}

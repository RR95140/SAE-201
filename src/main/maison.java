package main;

import ardoise.*;
import main.*;
import java.util.ArrayList;

public class maison extends Forme {

    private String Nom;
    //Variables permettant de construire la maison
    private quadrilatere rectangle;
    private quadrilatere porte;
    private chapeaux toit;
    //
    private PointPlan PSG;
    private PointPlan PID;
    private PointPlan PSD;
    //variables pour la porte et le toit
    private int hauteurToit;
    private int hauteurPorte;
    private int largeurPorte;


    // Définition des constructeurs.

    // Constructeur par défaut
    public maison() {
        // Paramètres de bases
        this.Nom = "";
        this.rectangle = new quadrilatere();
        this.porte = new quadrilatere();
        this.toit = new chapeaux();
        this.PSG = new PointPlan(0,0);
        this.PID = new PointPlan(0,0);
        this.PSD = new PointPlan(0,0);
        this.hauteurToit = 0;
        this.hauteurPorte = 0;
        this.largeurPorte = 0;
    }

    // Constructeur avec paramètres.
    public maison(String unNom,PointPlan PSG, PointPlan PID,int uneHauteurToit,int uneHauteurPorte,int uneLargeurPorte){

        // On initialise les paramètres de base.
        int millieuLongueur = 0;
        PointPlan p2Chapeau = null;


        this.Nom = unNom;
        this.PID=PID;
        this.PSG=PSG;

        if(PID!= null && PSG!=null){
            this.PSD= new PointPlan(PID.getAbscisse(), PSG.getOrdonnee());
        }
        else{
            this.PSD = null;
        }

        this.hauteurToit = uneHauteurToit;
        this.hauteurPorte = uneHauteurPorte;
        this.largeurPorte=uneLargeurPorte;

        //On construit le toit
        if(PID!= null && PSG!=null) {
            millieuLongueur = PSG.getAbscisse() + ((PSD.getAbscisse() - PSG.getAbscisse()) / 2);
        }
        if(millieuLongueur != 0 && PSG!=null) {
            p2Chapeau = new PointPlan(millieuLongueur, PSG.getOrdonnee() - hauteurToit);
        }

        // On construit la porte
        PointPlan p1Porte = new PointPlan(millieuLongueur-(largeurPorte/2),PID.getOrdonnee()-hauteurPorte);
        PointPlan p2Porte = new PointPlan(millieuLongueur+(largeurPorte/2),PID.getOrdonnee());



        //Définition des autres formes.
        this.rectangle = new quadrilatere(unNom,PSG,PID);
        this.toit = new chapeaux(unNom,PSG,p2Chapeau,PSD);
        this.porte = new quadrilatere(unNom,p1Porte,p2Porte);
    }

    // Constructeur par copie
    public maison(maison autreMaison) {
        try {
            this.Nom = autreMaison.getNom();
            this.rectangle = new quadrilatere(autreMaison.getRectangle());
            this.porte = new quadrilatere(autreMaison.getPorte());
            this.toit = new chapeaux(autreMaison.getToit());
            this.PSG = new PointPlan(autreMaison.PSG.getAbscisse(), autreMaison.getPSG().getOrdonnee());
            this.PID = new PointPlan(autreMaison.getPID().getAbscisse(), autreMaison.getPID().getOrdonnee());
            this.PSD = new PointPlan(autreMaison.getPSD().getAbscisse(), autreMaison.getPSD().getOrdonnee());
            this.hauteurToit = autreMaison.getHauteurToit();
            this.hauteurPorte = autreMaison.getHauteurPorte();
            this.largeurPorte = autreMaison.getLargeurPorte();
        } catch (Exception e) {
            // Message permettant la gestion des exceptions
            System.out.println("Une erreur a été détectée lors de la création de la maison : " + e.getMessage());
        }
    }




    // Défnition des getters pour retourner les valeurs.
    @Override
    public String getNomForme() {
        return super.getNomForme();
    }
    public String getNom(){
        return this.Nom;
    }

    public chapeaux getToit() {
        return this.toit;
    }

    public int getHauteurPorte() {
        return this.hauteurPorte;
    }

    public int getHauteurToit() {
        return this.hauteurToit;
    }

    public int getLargeurPorte() {
        return this.largeurPorte;
    }

    public PointPlan getPID() {
        return this.PID;
    }

    public quadrilatere getPorte() {
        return this.porte;
    }

    public quadrilatere getRectangle() {
        return this.rectangle;
    }

    public PointPlan getPSG() {
        return this.PSG;
    }

    public PointPlan getPSD() {
        return this.PSD;
    }




    // Définition des setters pour modifier une valeur.
    public void setHauteurToit(int hauteurToit) {

        this.hauteurToit = hauteurToit;
    }

    public void setHauteurPorte(int hauteurPorte) {

        this.hauteurPorte = hauteurPorte;
    }
    public void setLargeurPorte(int largeurPorte) {
        this.largeurPorte = largeurPorte;
    }
    public void setPID(PointPlan PID) {
        this.PID = PID;
    }
    public void setPorte(quadrilatere porte) {
        this.porte = porte;
    }
    public void setPSD(PointPlan PSD) {
        this.PSD = PSD;
    }
    public void setPSG(PointPlan PSG) {
        this.PSG = PSG;
    }
    public void setRectangle(quadrilatere rectangle) {
        this.rectangle = rectangle;
    }

    public void setToit(chapeaux toit) {
        this.toit = toit;
    }

    @Override
    public void setNomForme(String nom) {
        super.setNomForme(nom);
    }

    // Définition des méthodes
    
    // Cette méthode permet de tracer une figure.
    
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> points = new ArrayList<Segment>();
        
        // On relie les points.
        try {
            for (int i = 0; i < this.rectangle.dessiner().size(); i++) {
                points.add(this.rectangle.dessiner().get(i));
            }
            for (int i = 0; i < this.toit.dessiner().size(); i++) {
                points.add(this.toit.dessiner().get(i));
            }
            for (int i = 0; i < this.porte.dessiner().size(); i++) {
                points.add(this.porte.dessiner().get(i));
            }
        } catch (Exception e) {
            System.out.println("Une erreur a été détectée lors du dessin de la maison : " + e.getMessage());
        }

        return points;
    }

    // Cette méthode permet de deplacer une figure
    public void deplacer(int x, int y) {
        try {
            rectangle.deplacer(x, y);
            toit.deplacer(x, y);
            porte.deplacer(x, y);
        } catch (Exception e) {
            System.out.println("Une erreur a été détectée lors du déplacement de la maison : " + e.getMessage());
        }
    }

    // Cette méthode permet de définir le type de figure
    public String typeForme() {
        try {
            return "GF";
        } catch (Exception e) {
            System.out.println("Une erreur a été détectée lors de la récupération du type de forme : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}

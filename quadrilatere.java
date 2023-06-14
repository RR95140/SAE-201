import ardoise.Ardoise;
import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

import java.util.ArrayList;

public class quadrilatere extends Forme {
        private PointPlan pointSuperieurGauche;
        private PointPlan pointInferieurDroit;
        private PointPlan pointPlanSuperieurDroit;
        private String Nom;

        public quadrilatere(String unNom,PointPlan pointSuperieurGauche, PointPlan pointInferieurDroit) {
            this.pointSuperieurGauche = pointSuperieurGauche;
            this.pointInferieurDroit = pointInferieurDroit;
            this.Nom = unNom;

    }



    public String getNom() {
        return Nom;
    }
    public PointPlan getPointSuperieurGauche(){
            return pointSuperieurGauche;
    }
    public PointPlan getPointInferieurDroit(){
            return pointInferieurDroit;
    }
    
    public PointPlan getPointPlanSuperieurDroit() {
        return pointPlanSuperieurDroit;
    }

    @Override
    public String getNomForme() {
        return super.getNomForme();
    }
    //setters
    @Override
    public void setNomForme(String nom) {
        super.setNomForme(nom);
    }
    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPointInferieurDroit(PointPlan pointInferieurDroit) {
        this.pointInferieurDroit = pointInferieurDroit;
    }
    public void setPointSuperieurGauche(PointPlan pointSuperieurGauche) {
        this.pointSuperieurGauche = pointSuperieurGauche;
    }

    //methodes
    @Override
    public ArrayList<Segment> dessiner() {



        ArrayList<Segment> segments = new ArrayList<Segment>();

        PointPlan pointSuperieurDroit = new PointPlan(pointInferieurDroit.getAbscisse(), pointSuperieurGauche.getOrdonnee());
        PointPlan pointInferieurGauche = new PointPlan(pointSuperieurGauche.getAbscisse(), pointInferieurDroit.getOrdonnee());

        Segment s1 = new Segment(pointSuperieurGauche, pointSuperieurDroit);
        Segment s2 = new Segment(pointSuperieurDroit, pointInferieurDroit);
        Segment s3 = new Segment(pointInferieurDroit, pointInferieurGauche);
        Segment s4 = new Segment(pointInferieurGauche, pointSuperieurGauche);

        segments.add(s1);
        segments.add(s2);
        segments.add(s3);
        segments.add(s4);
        System.out.println("segments quadrilatere ajoutées");

        return segments;

    }

    @Override
    public void deplacer(int deplacementX, int deplacementY) {

        int nouvelleAbscissePointSuperieurGauche = pointSuperieurGauche.getAbscisse() + deplacementX;
        int nouvelleOrdonneePointSuperieurGauche = pointSuperieurGauche.getOrdonnee() + deplacementY;
        pointSuperieurGauche.setAbscisse(nouvelleAbscissePointSuperieurGauche);
        pointSuperieurGauche.setOrdonnee(nouvelleOrdonneePointSuperieurGauche);

        int nouvelleAbscissePointInferieurDroit = pointInferieurDroit.getAbscisse() + deplacementX;
        int nouvelleOrdonneePointInferieurDroit = pointInferieurDroit.getOrdonnee() + deplacementY;
        pointInferieurDroit.setAbscisse(nouvelleAbscissePointInferieurDroit);
        pointInferieurDroit.setOrdonnee(nouvelleOrdonneePointInferieurDroit);
        }




    @Override
    public String typeForme() {
        return "Q";
    }
}

package main;

import ardoise.*;

import java.util.ArrayList;

public class triangles extends Forme {
    private PointPlan point1;
    private PointPlan point2;
    private PointPlan point3;
    private String Nom;

    // Définition des constructeurs

    // Constructeur par défaut
    public triangles() {
        super();
        this.point1 = null;
        this.point2 = null;
        this.point3 = null;
        this.Nom = null;
    }

    // Constructeur avec paramètres
    public triangles(String unNom, PointPlan p1, PointPlan p2, PointPlan p3) {
        this.point1 = p1;
        this.point2 = p2;
        this.point3 = p3;
        this.Nom = unNom;
    }

    // Constructeur par copie
    public triangles(triangles autreTriangle) {
        try {
            this.Nom = autreTriangle.getNom();
            this.point1 = new PointPlan(autreTriangle.getPoint1().getAbscisse(), autreTriangle.getPoint1().getOrdonnee());
            this.point2 = new PointPlan(autreTriangle.getPoint2().getAbscisse(), autreTriangle.getPoint2().getOrdonnee());
            this.point3 = new PointPlan(autreTriangle.getPoint3().getAbscisse(), autreTriangle.getPoint3().getOrdonnee());
        } catch (NullPointerException e) {
            System.out.println("Une exception a été détectée lors de la création du triangle à partir du constructeur par copie.");
            e.printStackTrace();
        }
    }

    // Défnition des getters pour retourner les valeurs.

    @Override
    public String getNomForme() {
        return super.getNomForme();
    }

    public String getNom() {
        return this.Nom;
    }

    public PointPlan getPoint1() {
        return this.point1;
    }

    public PointPlan getPoint2() {
        return this.point2;
    }

    public PointPlan getPoint3() {
        return this.point3;
    }

    // Définition des setters pour modifier une valeur.

    @Override
    public void setNomForme(String nom) {
        super.setNomForme(nom);
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPoint1(PointPlan point1) {
        this.point1 = point1;
    }

    public void setPoint2(PointPlan point2) {
        this.point2 = point2;
    }

    public void setPoint3(PointPlan point3) {
        this.point3 = point3;
    }

    // Définition des méthodes

    // Cette méthode permet de tracer une figure.
    @Override
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> points = new ArrayList<Segment>();

        // On relie les points.
        try {
            Segment s1 = new Segment(this.point1, this.point2);
            Segment s2 = new Segment(this.point1, this.point3);
            Segment s3 = new Segment(this.point2, this.point3);

            points.add(s1);
            points.add(s2);
            points.add(s3);
        } catch (NullPointerException e) {
            System.out.println("Une exception a été détectée lors du dessin du triangle.");
            e.printStackTrace();
        }

        return points;
    }

    // Cette méthode permet de deplacer une figure
    @Override
    public void deplacer(int deplacementX, int deplacementY) {
        try {
            int newAbscisseP1 = point1.getAbscisse() + deplacementX; // On stocke la nouvelle abscisse du point
            int newOrdonneeP1 = point1.getOrdonnee() + deplacementY; // On stocke la nouvelle ordonnee du point
            point1.setAbscisse(newAbscisseP1); // On modifie l'abscisse du point
            point1.setOrdonnee(newOrdonneeP1); // On modifie l'ordonnne du point

            // On fait pareil avec les autres points
            int newAbscisseP2 = point2.getAbscisse() + deplacementX;
            int newOrdonneeP2 = point2.getOrdonnee() + deplacementY;
            point2.setAbscisse(newAbscisseP2);
            point2.setOrdonnee(newOrdonneeP2);

            int newAbscisseP3 = point3.getAbscisse() + deplacementX;
            int newOrdonneeP3 = point3.getOrdonnee() + deplacementY;
            point3.setAbscisse(newAbscisseP3);
            point3.setOrdonnee(newOrdonneeP3);
        } catch (NullPointerException e) {
            System.out.println("Une exception a été détecté lors du déplacement du triangle.");
            e.printStackTrace();
        }
    }

    // Cette méthode permet de définir le type de figure
    @Override
    public String typeForme() {
        try {
            return "T";
        } catch (Exception e) {
            System.out.println("une erreur a été détecté lors de la récupération du type de la forme : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}

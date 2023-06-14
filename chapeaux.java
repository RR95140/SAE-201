package main;

import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

import java.util.ArrayList;

public class chapeaux extends Forme {

    private PointPlan point1;
    private PointPlan point2;
    private PointPlan point3;
    private String Nom;

    // Définition des constructeurs
    
    // Constructeur par défaut
    public chapeaux() {
        super("");
        this.point1 = null;
        this.point2 = null;
        this.point3 = null;
    }

    // Constructeur avec paramètres
    public chapeaux(String unNom, PointPlan p1, PointPlan p2, PointPlan p3) {
        try {
            this.Nom = unNom;
            this.point1 = p1;
            this.point2 = p2;
            this.point3 = p3;
        } catch (Exception e) {
            System.out.println("Une exception a été détectée lors de la création du chapeau.");
            e.printStackTrace();
        }
    }

    // Constructeur par copie
    public chapeaux(chapeaux newChapeau) {
        try {
            this.Nom = newChapeau.getNom();
            this.point1 = new PointPlan(newChapeau.getPoint1().getAbscisse(), newChapeau.getPoint1().getOrdonnee());
            this.point2 = new PointPlan(newChapeau.getPoint2().getAbscisse(), newChapeau.getPoint2().getOrdonnee());
            this.point3 = new PointPlan(newChapeau.getPoint3().getAbscisse(), newChapeau.getPoint3().getOrdonnee());
        } catch (Exception e) {
            System.out.println("Une exception a été détectée lors de la création du chapeau à partir d'un autre chapeau.");
            e.printStackTrace();
        }
    }

    // Définition des getters
    public PointPlan getPoint1() {
        return this.point1;
    }

    public PointPlan getPoint2() {
        return this.point2;
    }

    public PointPlan getPoint3() {
        return this.point3;
    }

    public String getNom() {
        return this.Nom;
    }

    @Override
    public String getNomForme() {
        return super.getNomForme();
    }

    // Définition des setters
    @Override
    public void setNomForme(String nom) {
        super.setNomForme(nom);
    }

    public void setPoint1(PointPlan Point1) {
        this.point1 = Point1;
    }

    public void setPoint2(PointPlan Point2) {
        this.point2 = Point2;
    }

    public void setPoint3(PointPlan Point3) {
        this.point3 = Point3;
    }

    public void setNom(String nom) {
        this.Nom = nom;
    }

    // Définition des méthodes
    
    // Cette méthode permet de dessiner un chapeau
    @Override
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> segments = new ArrayList<>();

        // On relie les points
        try {
            Segment s1 = new Segment(this.point1, this.point2);
            Segment s2 = new Segment(this.point2, this.point3);

            segments.add(s1);
            segments.add(s2);
        } catch (Exception e) {
            System.out.println("Une exception a été détectée lors de la création des segments du chapeau.");
            e.printStackTrace();
        }

        return segments;
    }

    // Cette méthode permet de déplacer un chapeau.
    @Override
    public void deplacer(int deplacementX, int deplacementY) {
        try {
            int newAbscisseP1 = point1.getAbscisse() + deplacementX; // On stocke la nouvelle abscisse du point
            int newOrdonneeP1 = point1.getOrdonnee() + deplacementY; // On stocke la nouvelle ordonnée du point
            point1.setAbscisse(newAbscisseP1); // On modifie l'abscisse du point
            point1.setOrdonnee(newOrdonneeP1); // On modifie l'ordonnée du point
            
            // On fait pareil avec les autres points
            
            int newAbscisseP2 = point2.getAbscisse() + deplacementX;
            int newOrdonneeP2 = point2.getOrdonnee() + deplacementY;
            point2.setAbscisse(newAbscisseP2);
            point2.setOrdonnee(newOrdonneeP2);

            int newAbscisseP3 = point3.getAbscisse() + deplacementX;
            int newOrdonneeP3 = point3.getOrdonnee() + deplacementY;
            point3.setAbscisse(newAbscisseP3);
            point3.setOrdonnee(newOrdonneeP3);
        } catch (Exception e) {
            System.out.println("Une exception a été détectée lors du déplacement du chapeau.");
            e.printStackTrace();
        }
    }

    // Cette méthode permet de définir le type de figure.
    @Override
    public String typeForme() {
        try {
            return "C";
        } catch (Exception e) {
            System.out.println("Une erreur a été détectée lors de la récupération du type de forme : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}

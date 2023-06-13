import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

import java.awt.*;
import java.util.ArrayList;

public class chapeaux extends Forme {

    private PointPlan point1;
    private PointPlan point2;
    private PointPlan point3;
    private String Nom;

    // Constructeur des 3 points
    public chapeaux(String unNom, PointPlan p1, PointPlan p2, PointPlan p3) {
        super(unNom);
        this.point1 = p1;
        this.point2 = p2;
        this.point3 = p3;

    }

    //Les différents Getters qui retournent les différents points ainsi que le nom de la forme
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

    // Setters
    @Override
    public void setNomForme(String nom) {
        super.setNomForme(nom);
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

    public void setNom(String nom) {
        this.Nom = nom;
    }

   // définition des méthodes.
    
    
    // permet de déplacer la figure en d&plaçant les 3 points.
    @Override
    public void deplacer(int deplacementX, int deplacementY) {
        int newAbscisseP1 = point1.getAbscisse() + deplacementX;
        int newOrdonneeP1 = point1.getOrdonnee() + deplacementY;
        point1.setAbscisse(newAbscisseP1);
        point1.setOrdonnee(newOrdonneeP1);

        int newAbscisseP2 = point2.getAbscisse() + deplacementX;
        int newOrdonneeP2 = point2.getOrdonnee() + deplacementY;
        point2.setAbscisse(newAbscisseP2);
        point2.setOrdonnee(newOrdonneeP2);

        int newAbscisseP3 = point3.getAbscisse() + deplacementX;
        int newOrdonneeP3 = point3.getOrdonnee() + deplacementY;
        point3.setAbscisse(newAbscisseP3);
        point3.setOrdonnee(newOrdonneeP3);
    }

    
    
    // Permet de dessiner le chapeau en reliant les points
    @Override
    public ArrayList<Segment> dessiner() {
        Segment s1 = new Segment(this.point1, this.point2);
        Segment s2 = new Segment(this.point2, this.point3);
        ArrayList<Segment> points = new ArrayList<Segment>();

        points.add(s1);
        points.add(s2);

        System.out.println("Les segments ont été tracés");
        return points;
    }
    
    
    @Override
    public String type() {
        return "C";
    }
}

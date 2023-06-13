import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

import java.util.ArrayList;

public class etoile extends Forme {
    private chapeaux c1;
    private chapeaux c2;
    private chapeaux c3;
    private chapeaux c4;
    private PointPlan point1;
    private PointPlan point2;
    private PointPlan point3;
    private PointPlan point4;
    private PointPlan point5;
    private PointPlan point6;
    private PointPlan point7;
    private PointPlan point8;

    //Constructeur d'étoiles
    public etoile(PointPlan p1, PointPlan p2, PointPlan p3, PointPlan p4, PointPlan p5, PointPlan p6, PointPlan p7, PointPlan p8) {
        this.point1 = p1;
        this.point2 = p2;
        this.point3 = p3;
        this.point4 = p4;
        this.point5 = p5;
        this.point6 = p6;
        this.point7 = p7;
        this.point8 = p8;

        this.c1 = new chapeaux("branche n°1", this.point1, this.point2, this.point3);
        this.c2 = new chapeaux("branche n°2", this.point3, this.point4, this.point5);
        this.c3 = new chapeaux("branche n°3", this.point5, this.point6, this.point7);
        this.c4 = new chapeaux("branche n°4", this.point7, this.point8, this.point1);
    }


    
    //Définition des méthodes
    
    //Permet de déplacer les points de la figure
    public void deplacer(int x, int y) {
        point1.deplacer(x, y);
        point2.deplacer(x, y);
        point3.deplacer(x, y);
        point4.deplacer(x, y);
        point5.deplacer(x, y);
        point6.deplacer(x, y);
        point7.deplacer(x, y);
        point8.deplacer(x, y);
    }
    
    
    // Permet de dessiner la figure
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> segs = new ArrayList<Segment>();

        segs.addAll(c1.dessiner());
        segs.addAll(c2.dessiner());
        segs.addAll(c3.dessiner());
        segs.addAll(c4.dessiner());

        System.out.println("Les segments des étoiles ont été tracés.");

        return segs;
    }


    public String type() {
        return "GF";
    }
}

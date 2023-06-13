import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

import java.util.ArrayList;

public class etoile extends Forme {
        private chapeaux chapeau1;
        private chapeaux chapeau2;
        private chapeaux chapeau3;
        private chapeaux chapeau4;
        private PointPlan etoilePoint1;
        private PointPlan etoilePoint2;
        private PointPlan etoilePoint3;
        private PointPlan etoilePoint4;
        private PointPlan etoilePoint5;
        private PointPlan etoilePoint6;
        private PointPlan etoilePoint7;
        private PointPlan etoilePoint8;


        public etoile(PointPlan p1, PointPlan p2, PointPlan p3, PointPlan p4,PointPlan p5, PointPlan p6, PointPlan p7, PointPlan p8) {
            this.etoilePoint1 = p1;
            this.etoilePoint2 = p2;
            this.etoilePoint3 = p3;
            this.etoilePoint4 = p4;
            this.etoilePoint5 = p5;
            this.etoilePoint6 = p6;
            this.etoilePoint7 = p7;
            this.etoilePoint8 = p8;

            this.chapeau1 = new chapeaux("branche n°1", this.etoilePoint1, this.etoilePoint2, this.etoilePoint3);
            this.chapeau2 = new chapeaux("branche n°2", this.etoilePoint3, this.etoilePoint4, this.etoilePoint5);
            this.chapeau3 = new chapeaux("branche n°3", this.etoilePoint5, this.etoilePoint6, this.etoilePoint7);
            this.chapeau4 = new chapeaux("branche n°4", this.etoilePoint7, this.etoilePoint8, this.etoilePoint1);

        }

        public ArrayList<Segment> dessiner() {
            ArrayList<Segment> points = new ArrayList<Segment>();

            points.addAll(chapeau1.dessiner());
            points.addAll(chapeau2.dessiner());
            points.addAll(chapeau3.dessiner());
            points.addAll(chapeau4.dessiner());

            System.out.println("les segments des etoiles ont étés tracés");

            return points;
        }
    public void deplacer(int x, int y) {
        etoilePoint1.deplacer(x, y);
        etoilePoint2.deplacer(x, y);
        etoilePoint3.deplacer(x, y);
        etoilePoint4.deplacer(x, y);
        etoilePoint5.deplacer(x, y);
        etoilePoint6.deplacer(x, y);
        etoilePoint7.deplacer(x, y);
        etoilePoint8.deplacer(x, y);
    }



    public String typeForme() {
            return "GF";
        }
}

import ardoise.*;
import java.text.Format;
import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class triangles extends Forme {

    private PointPlan point1;
    private PointPlan point2;
    private PointPlan point3;
    private String nom;

    public triangles(String unNom, PointPlan p1, PointPlan p2, PointPlan p3) {
        this.point1 = p1;
        this.point2 = p2;
        this.point3 = p3;
        this.nom = unNom;
    }

    //getter

    @Override
    public String getNomForme() {
        return super.getNomForme();
    }

    public String getNom() {
        return this.nom;
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
}

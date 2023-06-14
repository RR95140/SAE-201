package test;

import ardoise.*;
import main.chapeaux;
import org.junit.*;
import java.util.ArrayList;



public class chapeauTest {
    @Test
    public void testConstructeurParDefaut() {
        chapeaux c = new chapeaux();
        Assert.assertNull(c.getChapeauPoint1());
        Assert.assertNull(c.getChapeauPoint2());
        Assert.assertNull(c.getChapeauPoint3());
    }

    @Test
    public void testConstructeurAvecParametres() {
        PointPlan p1 = new PointPlan(1, 2);
        PointPlan p2 = new PointPlan(3, 4);
        PointPlan p3 = new PointPlan(5, 6);
        String nom = "Chapeau1";
        chapeaux c = new chapeaux(nom, p1, p2, p3);
        Assert.assertEquals(p1, c.getChapeauPoint1());
        Assert.assertEquals(p2, c.getChapeauPoint2());
        Assert.assertEquals(p3, c.getChapeauPoint3());
        Assert.assertEquals(nom, c.getNom());
    }

    @Test
    public void testConstructeurParCopie() {
        PointPlan p1 = new PointPlan(1, 2);
        PointPlan p2 = new PointPlan(3, 4);
        PointPlan p3 = new PointPlan(5, 6);
        String nom = "Chapeau1";
        chapeaux original = new chapeaux(nom, p1, p2, p3);
        chapeaux copie = new chapeaux(original);


        // objet distinct?
        Assert.assertNotSame(original, copie);
        Assert.assertNotSame(original.getChapeauPoint1(), copie.getChapeauPoint1());
        Assert.assertNotSame(original.getChapeauPoint2(), copie.getChapeauPoint2());
        Assert.assertNotSame(original.getChapeauPoint3(), copie.getChapeauPoint3());
    }

    @Test
    public void testDessiner() {
        PointPlan p1 = new PointPlan(1, 2);
        PointPlan p2 = new PointPlan(3, 4);
        PointPlan p3 = new PointPlan(5, 6);
        String nom = "Chapeau1";
        chapeaux c = new chapeaux(nom, p1, p2, p3);
        ArrayList<Segment> segments = c.dessiner();

        // Vérification du nombre de segments
        Assert.assertEquals(2, segments.size());

    }

    @Test
    public void testDeplacer() {
        PointPlan p1 = new PointPlan(1, 2);
        PointPlan p2 = new PointPlan(3, 4);
        PointPlan p3 = new PointPlan(5, 6);
        String nom = "Chapeau1";
        chapeaux c = new chapeaux(nom, p1, p2, p3);

        // Déplacement de 10 en x et 20 en y
        c.deplacer(10, 20);

        // check nouvelles coordonnées des points
        Assert.assertEquals(11, c.getChapeauPoint1().getAbscisse());
        Assert.assertEquals(22, c.getChapeauPoint1().getOrdonnee());

        Assert.assertEquals(13, c.getChapeauPoint2().getAbscisse());
        Assert.assertEquals(24, c.getChapeauPoint2().getOrdonnee());

        Assert.assertEquals(15, c.getChapeauPoint3().getAbscisse());
        Assert.assertEquals(26, c.getChapeauPoint3().getOrdonnee());
    }

    @Test
    public void testTypeForme() {
        chapeaux c = new chapeaux();
        Assert.assertEquals("C", c.typeForme());
    }
}

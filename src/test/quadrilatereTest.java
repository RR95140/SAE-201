package test;

import ardoise.*;
import main.etoile;
import org.junit.*;
import java.util.ArrayList;
import main.*;



public class quadrilatereTest {
    @Test
    public void testConstructeurParDefaut() {
        quadrilatere quad = new quadrilatere();
        Assert.assertNull(quad.getPointSuperieurGauche());
        Assert.assertNull(quad.getPointInferieurDroit());
        Assert.assertNull(quad.getNom());
    }

    @Test
    public void testConstructeurAvecParametres() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(1, 1);
        quadrilatere quad = new quadrilatere("un", p1, p2);
        Assert.assertEquals(p1, quad.getPointSuperieurGauche());
        Assert.assertEquals(p2, quad.getPointInferieurDroit());
        Assert.assertEquals("un", quad.getNom());
    }

    @Test
    public void testConstructeurParCopie() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(1, 1);
        quadrilatere quad1 = new quadrilatere("un", p1, p2);
        quadrilatere quad2 = new quadrilatere(quad1);
        Assert.assertNotEquals(quad1.getPointSuperieurGauche(), quad2.getPointSuperieurGauche());
        Assert.assertNotEquals(quad1.getPointInferieurDroit(), quad2.getPointInferieurDroit());
        Assert.assertEquals(quad1.getNom(), quad2.getNom());
    }
    @Test
    public void testDessiner() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(2, 2);
        quadrilatere quad = new quadrilatere("Quad", p1, p2);
        ArrayList<Segment> segments = quad.dessiner();
        Assert.assertEquals(4, segments.size());
    }

    @Test
    public void testDeplacer() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(2, 2);
        quadrilatere quad = new quadrilatere("Quad", p1, p2);
        quad.deplacer(1, 1);
        Assert.assertEquals(1, quad.getPointSuperieurGauche().getAbscisse());
        Assert.assertEquals(1, quad.getPointSuperieurGauche().getOrdonnee());
        Assert.assertEquals(3, quad.getPointInferieurDroit().getAbscisse());
        Assert.assertEquals(3, quad.getPointInferieurDroit().getOrdonnee());
    }

}

package test;

import ardoise.*;
import main.etoile;
import org.junit.*;
import java.util.ArrayList;
import main.*;



public class quadrilatereTest {
    @Test
    public void testConstructeurParDefaut() {
        quadrilatere q= new quadrilatere();
        Assert.assertNull(q.getPSG());
        Assert.assertNull(q.getPID());
        Assert.assertNull(q.getNom());
    }

    @Test
    public void testConstructeurAvecParametres() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(1, 1);
        quadrilatere q = new quadrilatere("un", p1, p2);
        Assert.assertEquals(p1, q.getPSG());
        Assert.assertEquals(p2, q.getPID());
        Assert.assertEquals("un", q.getNom());
    }

    @Test
    public void testConstructeurParCopie() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(1, 1);
        quadrilatere q1 = new quadrilatere("un", p1, p2);
        quadrilatere q2 = new quadrilatere(q1);
        Assert.assertNotEquals(q1.getPSG(), q2.getPSG());
        Assert.assertNotEquals(q1.getPID(), q2.getPID());
        Assert.assertEquals(q1.getNom(), q2.getNom());
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
        Assert.assertEquals(1, quad.getPSG().getAbscisse());
        Assert.assertEquals(1, quad.getPSG().getOrdonnee());
        Assert.assertEquals(3, quad.getPID().getAbscisse());
        Assert.assertEquals(3, quad.getPID().getOrdonnee());
    }

}

package test;

import ardoise.*;
import main.etoile;
import org.junit.*;
import java.util.ArrayList;
import main.*;

public class etoileTest {
    
    @Test
    public void testConstructeurParDefaut() {
        etoile etoile = new etoile();
        Assert.assertNull(etoile.getNom());
        Assert.assertNull(etoile.getChapeau1());
        Assert.assertNull(etoile.getChapeau2());
        Assert.assertNull(etoile.getChapeau3());
        Assert.assertNull(etoile.getChapeau4());
    }

    @Test
    public void testConstructeurAvecParametres() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(1, 1);
        PointPlan p3 = new PointPlan(2, 0);
        PointPlan p4 = new PointPlan(1, -1);
        PointPlan p5 = new PointPlan(2, -2);
        PointPlan p6 = new PointPlan(1, -3);
        PointPlan p7 = new PointPlan(0, -2);
        PointPlan p8 = new PointPlan(-1, -3);

        etoile etoile = new etoile("Etoile", p1, p2, p3, p4, p5, p6, p7, p8);

        Assert.assertEquals("Etoile", etoile.getNom());
        Assert.assertEquals(p2, etoile.getEtoilePoint2());
        Assert.assertEquals(p3, etoile.getEtoilePoint3());
        Assert.assertEquals(p6, etoile.getEtoilePoint6());
    }

    @Test
    public void testConstructeurParCopie() {
        etoile etoileRef = new etoile("EtoileRef", new PointPlan(0, 0), new PointPlan(1, 1), new PointPlan(2, 0),
                new PointPlan(1, -1), new PointPlan(2, -2), new PointPlan(1, -3), new PointPlan(0, -2),
                new PointPlan(-1, -3));

        etoile etoileCopie = new etoile(etoileRef);

        Assert.assertEquals(etoileRef.getNom(), etoileCopie.getNom());

        Assert.assertNotSame(etoileRef.getChapeau1(), etoileCopie.getChapeau1());
        Assert.assertNotSame(etoileRef.getChapeau2(), etoileCopie.getChapeau2());
        Assert.assertNotSame(etoileRef.getChapeau3(), etoileCopie.getChapeau3());
        Assert.assertNotSame(etoileRef.getChapeau4(), etoileCopie.getChapeau4());
    }

    @Test
    public void testDessiner() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(1, 1);
        PointPlan p3 = new PointPlan(2, 0);
        PointPlan p4 = new PointPlan(1, -1);
        PointPlan p5 = new PointPlan(2, -2);
        PointPlan p6 = new PointPlan(1, -3);
        PointPlan p7 = new PointPlan(0, -2);
        PointPlan p8 = new PointPlan(-1, -3);

        etoile etoile = new etoile("Etoile", p1, p2, p3, p4, p5, p6, p7, p8);

        ArrayList<Segment> segments = etoile.dessiner();

        Assert.assertEquals(8, segments.size());
    }

    @Test
    public void testDeplacer() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(1, 1);
        PointPlan p3 = new PointPlan(2, 0);
        PointPlan p4 = new PointPlan(1, -1);
        PointPlan p5 = new PointPlan(2, -2);
        PointPlan p6 = new PointPlan(1, -3);
        PointPlan p7 = new PointPlan(0, -2);
        PointPlan p8 = new PointPlan(-1, -3);

        etoile etoile = new etoile("Etoile", p1, p2, p3, p4, p5, p6, p7, p8);

        etoile.deplacer(5, 5);

        Assert.assertEquals(5, p1.getAbscisse());
        Assert.assertEquals(5, p1.getOrdonnee());

        Assert.assertEquals(6, p2.getAbscisse());
        Assert.assertEquals(6, p2.getOrdonnee());

        Assert.assertEquals(7, p3.getAbscisse());
        Assert.assertEquals(5, p3.getOrdonnee());

        Assert.assertEquals(6, p4.getAbscisse());
        Assert.assertEquals(4, p4.getOrdonnee());
    }

    @Test
    public void testTypeForme() {
        etoile etoile = new etoile();
        Assert.assertEquals("GF", etoile.typeForme());
    }
}
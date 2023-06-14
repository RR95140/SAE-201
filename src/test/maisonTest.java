package test;

import ardoise.*;
import main.maison;
import org.junit.*;
import java.util.ArrayList;

public class maisonTest {
    @Test
    public void testConstructeurAvecParametres() {
        PointPlan PSG = new PointPlan(0, 0);
        PointPlan PID = new PointPlan(4, 4);

        maison maMaison = new maison("Ma Maison", PSG, PID, 2, 2, 2);

        Assert.assertEquals("Ma Maison", maMaison.getNom());
        Assert.assertNotNull(maMaison.getRectangle());
        Assert.assertNotNull(maMaison.getPorte());
        Assert.assertNotNull(maMaison.getToit());
        Assert.assertEquals(PSG, maMaison.getPSG());
        Assert.assertEquals(PID, maMaison.getPID());
        Assert.assertNotNull(maMaison.getPSD());
        Assert.assertEquals(2, maMaison.getHauteurToit());
        Assert.assertEquals(2, maMaison.getHauteurPorte());
        Assert.assertEquals(2, maMaison.getLargeurPorte());
    }

    @Test
    public void testConstructeurParCopie() {
        maison maisonRef = new maison("MaisonRef", new PointPlan(0, 0), new PointPlan(4, 4), 2, 2, 2);

        maison maisonCopie = new maison(maisonRef);

        Assert.assertEquals(maisonRef.getNom(), maisonCopie.getNom());
        Assert.assertNotSame(maisonRef.getRectangle(), maisonCopie.getRectangle());
        Assert.assertNotSame(maisonRef.getPorte(), maisonCopie.getPorte());
        Assert.assertNotSame(maisonRef.getToit(), maisonCopie.getToit());
        Assert.assertNotSame(maisonRef.getPSG(), maisonCopie.getPSG());
        Assert.assertNotSame(maisonRef.getPID(), maisonCopie.getPID());
        Assert.assertNotSame(maisonRef.getPSD(), maisonCopie.getPSD());
        Assert.assertEquals(maisonRef.getHauteurToit(), maisonCopie.getHauteurToit());
        Assert.assertEquals(maisonRef.getHauteurPorte(), maisonCopie.getHauteurPorte());
        Assert.assertEquals(maisonRef.getLargeurPorte(), maisonCopie.getLargeurPorte());
    }

    @Test
    public void testDessiner() {
        maison maMaison = new maison("Ma Maison", new PointPlan(0, 0), new PointPlan(4, 4), 2, 2, 2);

        ArrayList<Segment> segments = maMaison.dessiner();

        Assert.assertEquals(10, segments.size());
    }

    @Test
    public void testDeplacer() {
        maison maMaison = new maison("Ma Maison", new PointPlan(0, 0), new PointPlan(4, 4), 2, 2, 2);

        maMaison.deplacer(2, 2);

        Assert.assertEquals(4, maMaison.getRectangle().getPSG().getAbscisse());
        Assert.assertEquals(4, maMaison.getRectangle().getPSG().getOrdonnee());
    }

    @Test
    public void testTypeForme() {
        maison maMaison = new maison("Ma Maison", new PointPlan(0, 0), new PointPlan(4, 4), 2, 2, 2);

        String type = maMaison.typeForme();

        Assert.assertEquals("GF", type);
    }
}

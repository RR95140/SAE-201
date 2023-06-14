package test;

import ardoise.*;
import main.etoile;
import org.junit.*;
import java.util.ArrayList;
import main.*;

public class etoileTest {
    public void testConstructeurParDefaut() {
        // Création d'une étoile par défaut
        etoile etoile = new etoile();

        // Vérification des valeurs de quelques attributs
        Assert.assertNull(etoile.getNom());
        Assert.assertNull(etoile.getChapeau1());
        Assert.assertNull(etoile.getChapeau2());
        Assert.assertNull(etoile.getChapeau3());
        Assert.assertNull(etoile.getChapeau4());
    }

    @Test
    public void testConstructeurAvecParametres() {
        // Création des points de l'étoile
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(1, 1);
        PointPlan p3 = new PointPlan(2, 0);
        PointPlan p4 = new PointPlan(1, -1);
        PointPlan p5 = new PointPlan(2, -2);
        PointPlan p6 = new PointPlan(1, -3);
        PointPlan p7 = new PointPlan(0, -2);
        PointPlan p8 = new PointPlan(-1, -3);

        // Création de l'étoile avec des paramètres
        etoile etoile = new etoile("Etoile", p1, p2, p3, p4, p5, p6, p7, p8);

        // Vérification des valeurs des attributs
        Assert.assertEquals("Etoile", etoile.getNom());
        Assert.assertEquals(p2,etoile.getEtoilePoint2());
        Assert.assertEquals(p3,etoile.getEtoilePoint3());
        Assert.assertEquals(p6,etoile.getEtoilePoint6());
    }

    @Test
    public void testConstructeurParCopie() {
        // Création d'une étoile de référence pour differencier la copie de l'original
        etoile etoileRef = new etoile("EtoileRef", new PointPlan(0, 0), new PointPlan(1, 1), new PointPlan(2, 0),
                new PointPlan(1, -1), new PointPlan(2, -2), new PointPlan(1, -3), new PointPlan(0, -2),
                new PointPlan(-1, -3));

        // Création d'une étoile en utilisant le constructeur par copie
        etoile etoileCopie = new etoile(etoileRef);

        Assert.assertEquals(etoileRef.getNom(), etoileCopie.getNom());

        Assert.assertNotSame(etoileRef.getChapeau1(), etoileCopie.getChapeau1());
        Assert.assertNotSame(etoileRef.getChapeau2(), etoileCopie.getChapeau2());
        Assert.assertNotSame(etoileRef.getChapeau3(), etoileCopie.getChapeau3());
        Assert.assertNotSame(etoileRef.getChapeau4(), etoileCopie.getChapeau4());
    }

    public void testDessiner() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(1, 1);
        PointPlan p3 = new PointPlan(2, 0);
        PointPlan p4 = new PointPlan(1, -1);
        PointPlan p5 = new PointPlan(2, -2);
        PointPlan p6 = new PointPlan(1, -3);
        PointPlan p7 = new PointPlan(0, -2);
        PointPlan p8 = new PointPlan(-1, -3);

        // Création de l'étoile
        etoile etoile = new etoile("Etoile", p1, p2, p3, p4, p5, p6, p7, p8);

        ArrayList<Segment> segments = etoile.dessiner();

        // Vérification du nombre de segments
        Assert.assertEquals(8, segments.size());


    }

    @Test
    public void testDeplacer() {
        // Création des points de l'étoile
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(1, 1);
        PointPlan p3 = new PointPlan(2, 0);
        PointPlan p4 = new PointPlan(1, -1);
        PointPlan p5 = new PointPlan(2, -2);
        PointPlan p6 = new PointPlan(1, -3);
        PointPlan p7 = new PointPlan(0, -2);
        PointPlan p8 = new PointPlan(-1, -3);

        // Création de l'étoile
        etoile etoile = new etoile("Etoile", p1, p2, p3, p4, p5, p6, p7, p8);

        // Déplacement de l'étoile
        etoile.deplacer(5, 5);

        // Vérification des nouvelles coordonnées des points
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
        // Création de l'étoile
        etoile etoile = new etoile();

        // Vérification du type de forme
        Assert.assertEquals("GF", etoile.typeForme());
    }




}

package test;

import main.maison;

import ardoise.*;
import org.junit.*;
import java.util.ArrayList;


public class maisonTest {
    @Test


    public void testConstructeurAvecParametres() {
        // Création des points de la maison
        PointPlan PSG = new PointPlan(0, 0);
        PointPlan PID = new PointPlan(4, 4);

        // Création d'une maison avec des paramètres
        maison maMaison = new maison("Ma Maison", PSG, PID, 2, 2, 2);

        // Vérification des valeurs des attributs
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
        // Création d'une maison de référence
        maison maisonRef = new maison("MaisonRef", new PointPlan(0, 0), new PointPlan(4, 4), 2, 2, 2);

        // Création d'une maison en utilisant le constructeur par copie
        maison maisonCopie = new maison(maisonRef);

        // Vérification des valeurs des attributs de la maison copiée
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
        // Création d'une maison avec des paramètres
        maison maMaison = new maison("Ma Maison", new PointPlan(0, 0), new PointPlan(4, 4), 2, 2, 2);

        // Appel de la méthode dessiner()
        ArrayList<Segment> segments = maMaison.dessiner();

        // Vérification du résultat
        Assert.assertEquals(10, segments.size()); // Vérifier le nombre de segments retournés
        // Vérifier les valeurs des segments individuels...

    }

    @Test
    public void testDeplacer() {
        // Création d'une maison avec des paramètres
        maison maMaison = new maison("Ma Maison", new PointPlan(0, 0), new PointPlan(4, 4), 2, 2, 2);

        // Déplacement de la maison
        maMaison.deplacer(2, 2);

        // Vérification du déplacement des points
        Assert.assertEquals(4, maMaison.getRectangle().getPSG().getAbscisse());
        Assert.assertEquals(4, maMaison.getRectangle().getPSG().getOrdonnee());
        // Vérification du déplacement des autres points...
    }

    @Test
    public void testTypeForme() {
        // Création d'une maison avec des paramètres
        maison maMaison = new maison("Ma Maison", new PointPlan(0, 0), new PointPlan(4, 4), 2, 2, 2);

        // Appel de la méthode typeForme()
        String type = maMaison.typeForme();

        // Vérification du résultat
        Assert.assertEquals("GF", type);
    }
}
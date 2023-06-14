package test;

import main.maison;

import ardoise.*;
import org.junit.*;
import java.util.ArrayList;


public class maisonTest {
    @Test


    public void testConstructeurAvecParametres() {
        // Création des points de la maison
        PointPlan pSuperieurGauche = new PointPlan(0, 0);
        PointPlan pInferieurDroit = new PointPlan(4, 4);

        // Création d'une maison avec des paramètres
        maison maison = new maison("Ma Maison", pSuperieurGauche, pInferieurDroit, 2, 2, 2);

        // Vérification des valeurs des attributs
        Assert.assertEquals("Ma Maison", maison.getNom());
        Assert.assertNotNull(maison.getRectangle());
        Assert.assertNotNull(maison.getPorte());
        Assert.assertNotNull(maison.getToit());
        Assert.assertEquals(pSuperieurGauche, maison.getpSuperieurGauche());
        Assert.assertEquals(pInferieurDroit, maison.getpInferieurDroit());
        Assert.assertNotNull(maison.getpSuperieurDroit());
        Assert.assertEquals(2, maison.getHauteurToit());
        Assert.assertEquals(2, maison.getHauteurPorte());
        Assert.assertEquals(2, maison.getLargeurPorte());
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
        Assert.assertNotSame(maisonRef.getpSuperieurGauche(), maisonCopie.getpSuperieurGauche());
        Assert.assertNotSame(maisonRef.getpInferieurDroit(), maisonCopie.getpInferieurDroit());
        Assert.assertNotSame(maisonRef.getpSuperieurDroit(), maisonCopie.getpSuperieurDroit());
        Assert.assertEquals(maisonRef.getHauteurToit(), maisonCopie.getHauteurToit());
        Assert.assertEquals(maisonRef.getHauteurPorte(), maisonCopie.getHauteurPorte());
        Assert.assertEquals(maisonRef.getLargeurPorte(), maisonCopie.getLargeurPorte());
    }

    @Test
    public void testDessiner() {
        // Création d'une maison avec des paramètres
        maison maison = new maison("Ma Maison", new PointPlan(0, 0), new PointPlan(4, 4), 2, 2, 2);

        // Appel de la méthode dessiner()
        ArrayList<Segment> segments = maison.dessiner();

        // Vérification du résultat
        Assert.assertEquals(10, segments.size()); // Vérifier le nombre de segments retournés
        // Vérifier les valeurs des segments individuels...

    }

    @Test
    public void testDeplacer() {
        // Création d'une maison avec des paramètres
        maison maison = new maison("Ma Maison", new PointPlan(0, 0), new PointPlan(4, 4), 2, 2, 2);

        // Déplacement de la maison
        maison.deplacer(2, 2);

        // Vérification du déplacement des points
        Assert.assertEquals(4, maison.getRectangle().getPointSuperieurGauche().getAbscisse());
        Assert.assertEquals(4, maison.getRectangle().getPointSuperieurGauche().getOrdonnee());
        // Vérification du déplacement des autres points...
    }

    @Test
    public void testTypeForme() {
        // Création d'une maison avec des paramètres
        maison maison = new maison("Ma Maison", new PointPlan(0, 0), new PointPlan(4, 4), 2, 2, 2);

        // Appel de la méthode typeForme()
        String type = maison.typeForme();

        // Vérification du résultat
        Assert.assertEquals("GF", type);
    }
}

package test;

import ardoise.*;
import main.chapeaux;
import org.junit.*;
import java.util.ArrayList;



public class chapeauxTest {
    
	// Définition des tests de constructeurs.
	
	@Test
    public void testChapeaux() {
        PointPlan p1 = new PointPlan(1, 2);
        PointPlan p2 = new PointPlan(3, 4);
        PointPlan p3 = new PointPlan(5, 6);
        String nom = "Chapeau1";
        chapeaux c = new chapeaux(nom, p1, p2, p3);
        Assert.assertEquals(p1, c.getPoint1());
        Assert.assertEquals(p2, c.getPoint2());
        Assert.assertEquals(p3, c.getPoint3());
        Assert.assertEquals(nom, c.getNom());
    }
	
	// test du Constructeur par défaut.
	
	@Test
    public void testChapeaux() {
        chapeaux c = new chapeaux();
        Assert.assertNull(c.getPoint1());
        Assert.assertNull(c.getPoint2());
        Assert.assertNull(c.getPoint3());
    }

	// Définition des tests de méthodes.
    
	// Cette méthode permet de tester la méthode déplacer.
    @Test
    public void testDeplacer() {
        PointPlan p1 = new PointPlan(1, 2);
        PointPlan p2 = new PointPlan(3, 4);
        PointPlan p3 = new PointPlan(5, 6);
        String nom = "Chapeau1";
        chapeaux c = new chapeaux(nom, p1, p2, p3);

        // On déplace les chapeaux de 10 en x et 20 en y.
        c.deplacer(10, 20);

        // On vérifie les nouvelles coordonnées des points.
        Assert.assertEquals(11, c.getPoint1().getAbscisse());
        Assert.assertEquals(22, c.getPoint1().getOrdonnee());

        Assert.assertEquals(13, c.getPoint2().getAbscisse());
        Assert.assertEquals(24, c.getPoint2().getOrdonnee());

        Assert.assertEquals(15, c.getPoint3().getAbscisse());
        Assert.assertEquals(26, c.getPoint3().getOrdonnee());
    }
    
    // Cette méthode permet de tester la méthode dessiner.
    @Test
    public void testDessiner() {
        PointPlan p1 = new PointPlan(1, 2);
        PointPlan p2 = new PointPlan(3, 4);
        PointPlan p3 = new PointPlan(5, 6);
        String nom = "Chapeau1";
        chapeaux c = new chapeaux(nom, p1, p2, p3);
        ArrayList<Segment> segments = c.dessiner();

        // On vérifie le nombre de segments.
        Assert.assertEquals(2, segments.size());

    }

    // On vérifie que la forme est bien un chapeau.
    @Test
    public void testTypeForme() {
        chapeaux c = new chapeaux();
        Assert.assertEquals("C", c.typeForme());
    }
}

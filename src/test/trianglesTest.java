package test;
import ardoise.*;
import main.*;
import org.junit.*;
import java.util.ArrayList;



public class trianglesTest {
    
	// Définition des test des constructeurs
	
	// Test du constructeur par défaut
	@Test
    public void trianglesTest() {
        triangles triangle = new triangles();
        Assert.assertNull(triangle.getPoint1());
        Assert.assertNull(triangle.getPoint2());
        Assert.assertNull(triangle.getPoint3());
        Assert.assertNull(triangle.getNom());
    }

	// Test du constructeur avec paramètres
	@Test
    public void trianglesTest() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(5, 0);
        PointPlan p3 = new PointPlan(0, 5);

        triangles triangle = new triangles("MonTriangle", p1, p2, p3);

        Assert.assertEquals(p1, triangle.getPoint1());
        Assert.assertEquals(p2, triangle.getPoint2());
        Assert.assertEquals(p3, triangle.getPoint3());
        Assert.assertEquals("MonTriangle", triangle.getNom());
    }
	
	// Test du constructeur par copie
    @Test
    public void trianglesTest() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(5, 0);
        PointPlan p3 = new PointPlan(0, 5);

        triangles originalTriangle = new triangles("MonTriangle", p1, p2, p3);
        triangles copiedTriangle = new triangles(originalTriangle);

        Assert.assertNotEquals(originalTriangle.getPoint1(), copiedTriangle.getPoint1());
        Assert.assertNotEquals(originalTriangle.getPoint2(), copiedTriangle.getPoint2());
        Assert.assertNotEquals(originalTriangle.getPoint3(), copiedTriangle.getPoint3());
        Assert.assertEquals(originalTriangle.getNom(), copiedTriangle.getNom());
    }
    
	// Définition des tests de fonctions
    
    // Test de la fonction dessiner
    @Test
    public void testDessiner() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(5, 0);
        PointPlan p3 = new PointPlan(0, 5);

        triangles triangle = new triangles("MonTriangle", p1, p2, p3);

        ArrayList<Segment> segments = triangle.dessiner();

        Assert.assertEquals(3, segments.size());

    }

    // Test de la fonction déplacer
    @Test
    public void testDeplacer() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(5, 0);
        PointPlan p3 = new PointPlan(0, 5);

        triangles triangle = new triangles("MonTriangle", p1, p2, p3);

        triangle.deplacer(10, 10);

        PointPlan p4 = new PointPlan(10, 10);
        PointPlan p5 = new PointPlan(15, 10);
        PointPlan p6 = new PointPlan(10, 15);


    }

    // Test de la fonction pour récupérer le nom de la forme
    @Test
    public void testGetNomForme() {
        triangles triangle = new triangles();
        triangle.setNomForme("TriangleForme");
        triangle.setNom("TriangleForme");

        Assert.assertEquals("TriangleForme", triangle.getNomForme());
        Assert.assertEquals("TriangleForme", triangle.getNom());
    }
}

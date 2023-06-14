package test;
import ardoise.*;
import main.*;
import org.junit.*;
import java.util.ArrayList;



public class trianglesTest {
    @Test
    public void testDefaultConstructor() {
        triangles triangle = new triangles();
        Assert.assertNull(triangle.getTrianglePoint1());
        Assert.assertNull(triangle.getTrianglePoint2());
        Assert.assertNull(triangle.getTrianglePoint3());
        Assert.assertNull(triangle.getNom());
    }

    @Test
    public void testParameterizedConstructor() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(5, 0);
        PointPlan p3 = new PointPlan(0, 5);

        triangles triangle = new triangles("MonTriangle", p1, p2, p3);

        Assert.assertEquals(p1, triangle.getTrianglePoint1());
        Assert.assertEquals(p2, triangle.getTrianglePoint2());
        Assert.assertEquals(p3, triangle.getTrianglePoint3());
        Assert.assertEquals("MonTriangle", triangle.getNom());
    }

    @Test
    public void testCopyConstructor() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(5, 0);
        PointPlan p3 = new PointPlan(0, 5);

        triangles originalTriangle = new triangles("MonTriangle", p1, p2, p3);
        triangles copiedTriangle = new triangles(originalTriangle);

        Assert.assertNotEquals(originalTriangle.getTrianglePoint1(), copiedTriangle.getTrianglePoint1());
        Assert.assertNotEquals(originalTriangle.getTrianglePoint2(), copiedTriangle.getTrianglePoint2());
        Assert.assertNotEquals(originalTriangle.getTrianglePoint3(), copiedTriangle.getTrianglePoint3());
        Assert.assertEquals(originalTriangle.getNom(), copiedTriangle.getNom());
    }
    @Test
    public void testDessiner() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(5, 0);
        PointPlan p3 = new PointPlan(0, 5);

        triangles triangle = new triangles("MonTriangle", p1, p2, p3);

        ArrayList<Segment> segments = triangle.dessiner();

        Assert.assertEquals(3, segments.size());

    }

    @Test
    public void testDeplacer() {
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(5, 0);
        PointPlan p3 = new PointPlan(0, 5);

        triangles triangle = new triangles("MonTriangle", p1, p2, p3);

        triangle.deplacer(10, 10);

        PointPlan newP1 = new PointPlan(10, 10);
        PointPlan newP2 = new PointPlan(15, 10);
        PointPlan newP3 = new PointPlan(10, 15);


    }

    @Test
    public void testGetNomForme() {
        triangles triangle = new triangles();
        triangle.setNomForme("TriangleForme");
        triangle.setNom("TriangleForme");

        Assert.assertEquals("TriangleForme", triangle.getNomForme());
        Assert.assertEquals("TriangleForme", triangle.getNom());
    }
}

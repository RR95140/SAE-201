public void testDessiner() {
        // Création des points pour le chapeau
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(2, 0);
        PointPlan p3 = new PointPlan(1, 1);

        // Création du chapeau
        Chapeaux chapeau = new Chapeaux("Chapeau", p1, p2, p3);

        // Appel de la méthode dessiner()
        ArrayList<Segment> segments = chapeau.dessiner();

        // Vérification du nombre de segments
        assertEquals(2, segments.size());

        // Vérification des coordonnées des segments
        Segment segment1 = segments.get(0);
        assertEquals(p1, segment1.getPointDepart());
        assertEquals(p2, segment1.getPointArrivee());

        Segment segment2 = segments.get(1);
        assertEquals(p2, segment2.getPointDepart());
        assertEquals(p3, segment2.getPointArrivee());
    }

    @Test
    public void testDeplacer() {
        // Création des points pour le chapeau
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(2, 0);
        PointPlan p3 = new PointPlan(1, 1);

        // Création du chapeau
        Chapeaux chapeau = new Chapeaux("Chapeau", p1, p2, p3);

        // Déplacement du chapeau
        chapeau.deplacer(5, 10);

        // Vérification des nouvelles coordonnées des points
        assertEquals(5, chapeau.getChapeauPoint1().getX());
        assertEquals(10, chapeau.getChapeauPoint1().getY());

        assertEquals(7, chapeau.getChapeauPoint2().getX());
        assertEquals(10, chapeau.getChapeauPoint2().getY());

        assertEquals(6, chapeau.getChapeauPoint3().getX());
        assertEquals(11, chapeau.getChapeauPoint3().getY());
    }

    @Test
    public void testTypeForme() {
        // Création des points pour le chapeau
        PointPlan p1 = new PointPlan(0, 0);
        PointPlan p2 = new PointPlan(2, 0);
        PointPlan p3 = new PointPlan(1, 1);

        // Création du chapeau
        Chapeaux chapeau = new Chapeaux("Chapeau", p1, p2, p3);

        // Vérification du type de forme
        assertEquals("C", chapeau.typeForme());
    }
}

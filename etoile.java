package main;
import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;
import main.chapeaux;

import java.util.ArrayList;

public class etoile extends Forme {
    private chapeaux c1;
    private chapeaux c2;
    private chapeaux c3;
    private chapeaux c4;
    private String nom;
    private PointPlan point1;
    private PointPlan point2;
    private PointPlan point3;
    private PointPlan point4;
    private PointPlan point5;
    private PointPlan point6;
    private PointPlan point7;
    private PointPlan point8;

    //Définition des constructeurs
    
    //Constructeur par défaut
    public etoile() {
        super("");
        this.c1 = null;
        this.c2 = null;
        this.c3 = null;
        this.c4 = null;
        this.nom = null;
        this.point1 = null;
        this.point2 = null;
        this.point3 = null;
        this.point4 = null;
        this.point5 = null;
        this.point6 = null;
        this.point7 = null;
        this.point8 = null;
    }

    //Constructeur avec paramètres
    public etoile(String unNom, PointPlan p1, PointPlan p2, PointPlan p3, PointPlan p4, PointPlan p5, PointPlan p6, PointPlan p7, PointPlan p8) {
        this.nom = unNom;
        this.point1 = p1;
        this.point2 = p2;
        this.point3 = p3;
        this.point4 = p4;
        this.point5 = p5;
        this.point6 = p6;
        this.point7 = p7;
        this.point8 = p8;

        try {
            this.c1 = new chapeaux("branche n°1", this.point1, this.point2, this.point3);
            this.c2 = new chapeaux("branche n°2", this.point3, this.point4, this.point5);
            this.c3 = new chapeaux("branche n°3", this.point5, this.point6, this.point7);
            this.c4 = new chapeaux("branche n°4", this.point7, this.point8, this.point1);
        } catch (NullPointerException e) {
            System.out.println("Une erreur a été détectée : Les points de l'étoile sont nuls.");
        }
    }

    //Constructeur par copie
    public etoile(etoile autreEtoile) {
        this.nom = new String(autreEtoile.getNom());

        try {
            this.c1 = new chapeaux(autreEtoile.getChapeau1());
            this.c2 = new chapeaux(autreEtoile.getChapeau2());
            this.c3 = new chapeaux(autreEtoile.getChapeau3());
            this.c4 = new chapeaux(autreEtoile.getChapeau4());
        } catch (NullPointerException e) {
            System.out.println("Une erreur a été détectée : Le chapeau est nul.");
        }
    }

    
    //Définition des getters et setters 
    public chapeaux getChapeau1() {
        return this.c1;
    }

    public void setChapeau1(chapeaux chapeau1) {
        this.c1 = chapeau1;
    }

    public chapeaux getChapeau2() {
        return this.c2;
    }

    public void setChapeau2(chapeaux chapeau2) {
        this.c2 = chapeau2;
    }

    public chapeaux getChapeau3() {
        return this.c3;
    }

    public void setChapeau3(chapeaux chapeau3) {
        this.c3 = chapeau3;
    }

    public chapeaux getChapeau4() {
        return this.c4;
    }

    public void setChapeau4(chapeaux chapeau4) {
        this.c4 = chapeau4;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public PointPlan getEtoilePoint1() {
        return this.point1;
    }

    public void setEtoilePoint1(PointPlan etoilePoint1) {
        this.point1 = etoilePoint1;
    }

    public PointPlan getEtoilePoint2() {
        return this.point2;
    }

    public void setEtoilePoint2(PointPlan etoilePoint2) {
        this.point2 = etoilePoint2;
    }

    public PointPlan getEtoilePoint3() {
        return this.point3;
    }

    public void setEtoilePoint3(PointPlan etoilePoint3) {
        this.point3 = etoilePoint3;
    }

    public PointPlan getEtoilePoint4() {
        return this.point4;
    }

    public void setEtoilePoint4(PointPlan etoilePoint4) {
        this.point4 = etoilePoint4;
    }

    public PointPlan getEtoilePoint5() {
        return this.point5;
    }

    public void setEtoilePoint5(PointPlan etoilePoint5) {
        this.point5 = etoilePoint5;
    }

    public PointPlan getEtoilePoint6() {
        return this.point6;
    }

    public void setEtoilePoint6(PointPlan etoilePoint6) {
        this.point6 = etoilePoint6;
    }

    public PointPlan getEtoilePoint7() {
        return this.point7;
    }

    public void setEtoilePoint7(PointPlan etoilePoint7) {
        this.point7 = etoilePoint7;
    }

    public PointPlan getEtoilePoint8() {
        return this.point8;
    }

    public void setEtoilePoint8(PointPlan etoilePoint8) {
        this.point8 = etoilePoint8;
    }

    
    // Définition des méthodes
    
    // Cette méthode permet de dessiner les étoiles 
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> segments = new ArrayList<Segment>();

        // On relie les points pour tracer l'étoile
        try {
            segments.addAll(c1.dessiner());
            segments.addAll(c2.dessiner());
            segments.addAll(c3.dessiner());
            segments.addAll(c4.dessiner());
        } catch (NullPointerException e) {
            System.out.println("Une erreur a été détectée : L'étoile ou ses chapeaux sont nuls.");
        }

        System.out.println("Les étoiles ont bien été tracées.");

        return segments;
    }

    // Cette méthode permet de déplacer une étoile
    public void deplacer(int x, int y) {
        try {
            point1.deplacer(x, y);
            point2.deplacer(x, y);
            point3.deplacer(x, y);
            point4.deplacer(x, y);
            point5.deplacer(x, y);
            point6.deplacer(x, y);
            point7.deplacer(x, y);
            point8.deplacer(x, y);
        } catch (NullPointerException e) {
            System.out.println("Une erreur a été détectée : Les points de l'étoile sont nuls.");
        }
    }

    // Cette méthode permet de définir le type de figure
    public String typeForme() {
        try {
            return "GF";
        } catch (Exception e) {
            System.out.println("Une erreur a été détectée lors de la récupération du type de forme : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}

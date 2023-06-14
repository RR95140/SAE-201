package test;
import ardoise.Ardoise;
import ardoise.PointPlan;
import main.*;


import java.lang.*;
public class TestArdoise {

    public static void main(String []args ) throws InterruptedException {

        Ardoise ardoise = new Ardoise();
        ardoise.dessinerGraphique();

        //Tour
        PointPlan p1 = new PointPlan(9, 100);
        PointPlan p2 = new PointPlan(20, 198);
        quadrilatere q1 = new quadrilatere("tour",p1,p2);
        ardoise.ajouterForme(q1);

        //Oiseaux
        PointPlan p3 = new PointPlan(118,13);
        PointPlan p4 = new PointPlan(123,20);
        PointPlan p5 = new PointPlan(128,13);
        chapeaux c1 = new chapeaux("oiseau 1",p3,p4,p5);
        ardoise.ajouterForme(c1);

        PointPlan p6 = new PointPlan(133,30);
        PointPlan p7 = new PointPlan(136,32);
        PointPlan p8 = new PointPlan(138,30);
        chapeaux c2 = new chapeaux("oiseau 2",p6,p7,p8);
        ardoise.ajouterForme(c2);

        PointPlan p9 = new PointPlan(142,14);
        PointPlan p10 = new PointPlan(144,17);
        PointPlan p11 = new PointPlan(146,14);
        chapeaux c3 = new chapeaux("oiseau 3",p9,p10,p11);
        ardoise.ajouterForme(c3);

        //Maison
        PointPlan p12 = new PointPlan(80,140);
        PointPlan p13 = new PointPlan(180,198);
        maison maison1=new maison ("e",p12,p13,30,28,20);
        ardoise.ajouterForme(maison1);
        maison1.dessiner();

        //Montagnes
        PointPlan p14 = new PointPlan(3,14);
        PointPlan p15 = new PointPlan(43,3);
        PointPlan p16 = new PointPlan(112,14);
        triangles t1 = new triangles("montagne 1",p14,p15,p16);
        ardoise.ajouterForme(t1);

        PointPlan p17 = new PointPlan(152,7);
        PointPlan p18 = new PointPlan(166,3);
        PointPlan p19 = new PointPlan(172,7);
        triangles t2 =  new triangles("montagne 2",p17,p18,p19);
        ardoise.ajouterForme(t2);

        //Etoile
        PointPlan p20 = new PointPlan(170, 52);
        PointPlan p21 = new PointPlan(173, 45);
        PointPlan p22 = new PointPlan(177, 52);
        PointPlan p23 = new PointPlan(184, 57);
        PointPlan p24 = new PointPlan(177, 60);
        PointPlan p25 = new PointPlan(174, 66);
        PointPlan p26 = new PointPlan(170, 60);
        PointPlan p27 = new PointPlan(164, 57);
        etoile e1 = new etoile("Etoile 1",p20, p21, p22, p23, p24, p25, p26, p27);
        ardoise.ajouterForme(e1);
        e1.dessiner();

        //Move oiseaux
        Thread.sleep(1000);
        System.out.println("sleep end");
        ardoise.deplacer("C",10,20);
        
    }
}

/*
Copyright (c) Xerox Corporation 1998-2002.  All rights reserved.

Use and copying of this software and preparation of derivative works based
upon this software are permitted.  Any distribution of this software or
derivative works must comply with all applicable United States export control
laws.

This software is made available AS IS, and Xerox Corporation makes no warranty
about the software, its performance or its conformity to any specification.
*/

package observer;

import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Container;
import java.util.Vector;



public class Demo {
	
    public static void main(String[] args) {
   	  Vector<Publisher> toutLesPublisher = new Vector<Publisher>();;
   	  Vector<Subscriber> toutLesSubscriber = new Vector<Subscriber>();
   	 
        Display display = new Display("Publish and Subscribe");
        
        /**
         * Ajouter un bouton pour ajouter un Publisher 
         * et un autre pour ajouter des Subscriber
        **/
        
        Publisher p1 = new Publisher(display,"1er éditeur",1);
        toutLesPublisher.add(p1);
        Publisher p2 = new Publisher(display,"2nd éditeur",5);
        toutLesPublisher.add(p2);

        /**
         * Liste, du moins des vector contenant le numéro de l'abonnement
         */
        
	        Vector v1 = new Vector<Integer>();
	        v1.add(1);
	        v1.add(2);
	        Vector v2 = new Vector<Integer>();
	        v2.add(4);
	        v2.add(5);
        
        
        Subscriber s1 = new Subscriber(display,"Adrien",v1);
        toutLesSubscriber.add(s1);
        Subscriber s2 = new Subscriber(display,"Anthony",v2);
        toutLesSubscriber.add(s2);
        
        
        /**
         * Juste pour tester en attendant
         */

        p1.b.addObserver(s1);
        p2.b.addObserver(s2);
        /**
         * juste pour avoir une interface en colonne, j'ai pas regardé comment
         * les mettre les un en dessous des autres
        **/
        
        display.setPrefSize(new Dimension(250, 300));
        
        /*
        
        Button b1 = new Button(display);
        Button b2 = new Button(display);
        ColorLabel c1 = new ColorLabel(display);
        ColorLabel c2 = new ColorLabel(display);
        ColorLabel c3 = new ColorLabel(display);

        b1.addObserver(c1);
        b1.addObserver(c2);
        b2.addObserver(c3);
        */
        
    }
}

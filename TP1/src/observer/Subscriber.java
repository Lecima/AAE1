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

import java.util.Vector;

class Subscriber{

	
	 private String name, textAboRecu;
    public TextName t;
    private Vector<Integer> abonnements;
    


    public Subscriber(Display d,String n,Vector<Integer> a) {
   	 super();
   	 name = n;   	 
   	 abonnements = a;
   	 t = new TextName(d,n);
    }
    
    public Subscriber(Display d){
   	 this(d,"null",new Vector<Integer>());
    }
    
    void changeString(){
   	 if(t.getText().compareTo("")==0){
   		 t.setText("toto");
   	 }else{
   		 t.setText("");
   	 }
    }
    
}

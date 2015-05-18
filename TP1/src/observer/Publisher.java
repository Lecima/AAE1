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

import java.awt.Component;



class Publisher{

	
	 private String name;
    private TextName t;
    private TextAEnvoyer e;
    private Button b;

    public Publisher(Display d,String n) {
   	 super();
   	 name = n;
   	 
   	 t = new TextName(d,n);
   	 b = new Button(d);
   	 e = new TextAEnvoyer(d);
    }
    public Publisher(Display d){
   	 this(d,"null");
    }
    
}

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
import java.awt.Label;

class TextName extends Label {

    TextName(Display d, String s) {
        super();
        this.setText(s);
        d.addToFrame(this);
    }
    public TextName(Display d) {
   	 this(d, "Null");
	}
}

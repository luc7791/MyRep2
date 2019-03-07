package com.sda.java.coffeemachine

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TestGenerator

class ExTest {

    @TestG
   Ex ExConstr = new Ex();

   void testCenturyFromYear() {
        ExConstr.centuryFromYear(1700);

    }
}

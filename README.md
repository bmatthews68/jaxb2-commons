JAXB2 Commons
=============

JAXB2 Commons Lang3 Plugin
--------------------------

This plugin causes JAXB RI 2.2 XJC to automatically generate methods for:
 [toString()](http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Object.html#toString())
 [equals()](http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Object.html#equals(java.lang.Object))
 [hashCode()](http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Object.html#hashCode())
using [Apache Commons Lang 3](http://commons.apache.org/proper/commons-lang/). The code that uses this plugin can still run with any JAXB2 implementation.

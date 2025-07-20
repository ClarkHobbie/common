# Introduction

Commons is a library about providing a convenient way of performing common tasks.  For example,
providing a Bag data structure.

# Details

The various classes and their functions are
* com.ltsllc.commons.application 
  * Application - an abstract class that knows how to deal with command lines
  * CommandLine - an abstract class that knows how to deal with switches
* com.ltsllc.commons.io
    * ImprovedFile - provides some useful methods like copyTo
    * TextFile - a convenient way of dealing with text files
* com.ltsllc.commons.Test - useful classes when dealing with unit tests
* com.ltsllc.commons.util
  * Bag - the bag data structure
  * BagIterator - an iterator for a bag
  * ImprovedArrays - a class that improves on the Array class by adding methods like restOf 
  * ImprovedPaths - an improved version of the Paths class with methods like toPath(File) and
    appendToPath
  * ImprovedProperties - a properties that provides methods like getIntProperty and setIfNull
  * ImprovedRandom - an improved version of the Random class with methods like nextInt and 
    choose(Class, []candidates)
  * PropertiesUtils - a Class for dealing with Properties objects with methods like 
    buildFrom(String[][]) and toString
  * Property - a class for representing a property
  * UtilsClass - a collection of generally useful methods like toList([])
* LtsllcException - a class that inherits from Exception and shows that the source is ltsllc.
* UncheckedLtsllcException - a RuntimeException that comes from ltsllc.
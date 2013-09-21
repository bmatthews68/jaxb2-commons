JAXB2 Commons
=============

Commons Lang3 Plugin
--------------------

This plugin causes JAXB RI 2.2 XJC to automatically generate methods for:
* [toString()](http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Object.html#toString(\))
* [equals()](http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Object.html#equals(java.lang.Object\))
* [hashCode()](http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Object.html#hashCode(\))
using [Apache Commons Lang 3](http://commons.apache.org/proper/commons-lang/). The code that uses this plugin can still run with any JAXB2 implementation.

This plugin
```java
@Override
public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
}

@Override
public boolean equals(final Object that) {
    return EqualsBuilder.reflectionEquals(this, that);
}

@Override
public void int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
}
```
Usage
Ant
```xml
<taskdef name="xjc" classname="com.sun.tools.xjc.XJCTask">
    <classpath>
        <pathelement path="/path/to/jaxb-xjc.jar"/>
        <pathelement path="/path/to/jaxb2-commons-lang3.jar" />
        <pathelement path="/path/to/commons-lang3.jar" />
    </classpath>
</taskdef>
<xjc>
    <arg value="-Xcommons-lang3" />
    <arg value="-Xcommons-lang3:ToStringStyle=SHORT_PREFIX_STYLE" />
    <!-- ... -->
</xjc>
```
Maven
```xml
<plugin>
    <groupId>org.jvnet.jaxb2.maven2</groupId>
    <artifactId>maven-jaxb22-plugin</artifactId>
    <version>0.8.3</version>
    <executions>
        <execution>
            <goals>
                <goal>generate</goal>
            </goals>
            <configuration>
                <extension>true</extension>
                <args>
                    <arg>-Xcommons-lang3</arg>
                    <arg>-Xcommons-lang3:ToStringStyle=SHORT_PREFIX_STYLE</arg>
                </args>
                <plugins>
                    <plugin>
                        <groupId>com.btmatthews.jaxb2_commons</groupId>
                        <artifactId>jaxb2-commons-lang3</artifactId>
                        <version>1.0.0</version>
                    </plugin>
                </plugins>
            </configuration>
        </execution>
    </executions>
</plugin>
```
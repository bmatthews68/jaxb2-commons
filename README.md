JAXB2 Commons
=============

Commons Lang3 Plugin
--------------------

This is a port of the [commons-lang](https://java.net/projects/jaxb2-commons/pages/Commons-lang) for XJC
that generates [toString()](http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Object.html#toString(\)),
[equals()](http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Object.html#equals(java.lang.Object\)),
and [hashCode()](http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Object.html#hashCode(\)) using
[Apache Commons Lang 3](http://commons.apache.org/proper/commons-lang/).

This plugin generates the following additional methods using
[ToStringBuilder](http://commons.apache.org/proper/commons-lang/javadocs/api-3.1/org/apache/commons/lang3/builder/ToStringBuilder.html),
[EqualsBuilder](http://commons.apache.org/proper/commons-lang/javadocs/api-3.1/org/apache/commons/lang3/builder/EqualsBuilder.html),
and [HashCodeBuilder](http://commons.apache.org/proper/commons-lang/javadocs/api-3.1/org/apache/commons/lang3/builder/HashCodeBuilder.html):

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

### Usage

#### Ant

The plugin can be used in an Ant build.xml project file using the following
configuration:

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

#### Maven

The plugin can be used in a Maven pom.xml project file using the following
configuration:

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
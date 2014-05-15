javacro 2014
==========================

This is the official repository for my conference talk from the Java Cro 2014 ( http://javacro.org/ ), Porec, Croatia.
See my talk details on the program schedule http://javacro.org/monday-2014-05-12/

The original title was *Scala and Java EE 7 Development Experiences*

Peter Pilgrim – Java Champion, Independent Contractor



Installation
--------------

Download and install Gradle 1.12 or better http://gradle.org/

Download GlassFish 4.0.1 from https://glassfish.java.net/


Install Scala

> gzip -dc scala-2.10.tgz | (cd /Library/opt; tar xvf - )

Install Gradle

> unzip gradle-all-1.11.zip -d /Library/opt

Install WildFly

> gzip -dc glassfish-4.0.1-b05.tar.gz | (cd /Library/opt; tar xvf - )


Set up your login shell script (BASH ~/.bash_profile) and your PATH environment variable


> export SCALA_HOME=/Library/opt/scala/scala-2.10.4
>
> export GRADLE_HOME=/Library/opt/gradle-1.12
>
> export GLASSFISH_HOME=/Library/opt/wildfly-8.0.0.Final
>
> export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_51.jdk/Contents/Home/bin/java
>
> PATH=${SCALA_HOME}/bin:${GRADLE_HOME}/bin:${WILDFLY_HOME}/bin:${JAVA_HOME_HOME}/bin:${PATH}



Building The Project
----------------------

Use Gradle to compile the project. In order to build the entire project as it now stand, issue the command:

> gradle build

To clean the project and reset it, issue the command:

> gradle clean

To generate the WAR file for deployment, isse the command:

> gradle war

If you want to work in an IDE (IntelliJ IDEA or Eclipse), issue these commands to generate the necessary project files:

> gradle idea
> gradle eclipse





Build
--------------


See my Java EE 7 Developer Handbook published by Packt Publishing (1st Published on Friday 20 September 2013
http://www.packtpub.com/java-ee-7-developer-handbook/book



Scala and Java EE 7 Development Experiences
---------------------------------------------

Scala is an alternative JVM language with both object-oriented and functional programming paradigms.
Scala development with the Java EE 7 platform is definitely possible and can be a pleasant experience.
If you have uncertainty about how Scala can fit around the Java EE 7 platform, then this session aims to illustrate
the huge benefit that Scala adoption can bring to the platform...


Scala language overview
Java EE 7 architecture and design
WildFly 8 application server *TODO*
Using Gradle as a build tool
How to create beans in Scala with dependency injection
JAX-RS endpoints
Servlet Endpoints
JMS Messaging
Scala adoption advice and hints for sustainable team development

Read more http://javacro.org/sessions/#scala

;-)

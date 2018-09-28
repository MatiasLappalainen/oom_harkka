# Instructions

 - See OOMkit instructions here https://gitlab.utu.fi/jmjmak/oom-oomkit
 - See also general SBT project instructions here https://gitlab.utu.fi/jmjmak/templates-jqwik-test
 - 
Note that the default build.sbt is for Java 10. Update the file if your
Java SDK version differs (that is, the line with: val javaVersion = 10)

## OOMKit installation

$ git clone https://gitlab.utu.fi/jmjmak/oom-oomkit

$ cd oom-oomkit

$ sbt publishLocal

$ cd ..

$ git clone https://gitlab.utu.fi/jmjmak/oom-oomkit-demo

$ cd oom-oomkit-demo

$ sbt run
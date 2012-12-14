About this project:

This project contains the POC related to JSF stuff, so a person can get started with ease.

Deploy:
This is a maven project so "mvn clean install" will create a war file which can be deployed in tomcat 7. It was observed that Glassfish-2.1.1 does not support JSF-2.0


How to deploy a webapp in tomcat using maven?

1. Tomcat Authentication
First, add an user with administrator access right for Tomcat. To add Tomcat user, edit this file � "%TOMCAT_PATH%/conf/tomcat-users.xml".

File : tomcat-users.xml

<?xml version='1.0' encoding='utf-8'?>
<tomcat-users>
  <role rolename="manager"/>
  <role rolename="admin"/>
  <user username="admin" password="password" roles="admin,manager"/>
</tomcat-users>
Later, you will use the user "admin" to do the deployment.



2. Maven Authentication
In Maven side, you need to add the same user authentication information in "%MAVEN_PATH%/conf/settings.xml".

File : settings.xml

//...
<server>
	<id>TomcatServer</id>
	<username>admin</username>
	<password>password</password>
</server>
//...
3. Maven-Tomcat-Plugin
Declare "Maven-Tomcat plugin" and related Tomcat server detail in your pom.xml file.

<plugin>
	<groupId>org.codehaus.mojo</groupId>
	<artifactId>tomcat-maven-plugin</artifactId>
	<configuration>
		<url>http://127.0.0.1:8080/manager</url>
		<server>TomcatServer</server>
		<path>/mkyongWebApp</path>
	</configuration>
</plugin>
See a full pom.xml file.

<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
	http://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.mkyong</groupId>
	<artifactId>mkyongweb-core</artifactId>
	<packaging>war</packaging>
	<version>1.0</version>
	<name>mkyongweb-core Maven Webapp</name>
	<url>http://maven.apache.org</url>
	<build>
		<plugins>
			<!-- Maven Tomcat Plugin -->
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>tomcat-maven-plugin</artifactId>
				<configuration>
					<url>http://127.0.0.1:8080/manager</url>
					<server>TomcatServer</server>
					<path>/mkyongWebApp</path>
				</configuration>
			</plugin>
			<!-- Maven compiler plugin -->
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<configuration>
					<source>1.6</source>
					<target>1.6</target>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>

4. Deploy to Tomcat
Issue "mvn tomcat:deploy" to package your project in a WAR file, and deploy it to Tomcat server. To verify it, just access to the Tomcat�s manager page and make sure "/mkyongWebApp" path is existed.

URL : http://127.0.0.1:8080/manager/



URL to look out for:

1. Hello World : http://localhost:8080/JavaServerFaces/hello.jsf

2. Hello World AJAX : http://localhost:8080/JavaServerFaces/helloAjax.jsf
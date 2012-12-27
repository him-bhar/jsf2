About this project:

This project contains the POC related to JSF stuff, so a person can get started with ease.

Deploy:
This is a maven project so "mvn clean install" will create a war file which can be deployed in tomcat 7. It was observed that Glassfish-2.1.1 does not support JSF-2.0


How to deploy a webapp in tomcat using maven?

1. Tomcat Authentication
First, add an user with administrator access right for Tomcat. To add Tomcat user, edit this file – "%TOMCAT_PATH%/conf/tomcat-users.xml".

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
Issue "mvn tomcat:deploy" to package your project in a WAR file, and deploy it to Tomcat server. To verify it, just access to the Tomcat’s manager page and make sure "/mkyongWebApp" path is existed.

URL : http://127.0.0.1:8080/manager/


                               Configure Managed Bean with XML

With XML configuration, you can use the old JSF 1.x mechanism to define the managed bean in a normal faces-config.xml file.
 Best Practice
It’s recommended to put the managed beans in a separate XML file because the faces-config.xml is used to set the application level configurations.

So, you should create a new XML file and put the managed beans detail inside, and declared the XML file in the javax.faces.CONFIG_FILES initialize parameter, which is inside the WEB-INF/web.xml file.

web.xml

 ...
 <context-param>
    <param-name>javax.faces.CONFIG_FILES</param-name>
    <param-value>WEB-INF/manage-beans.xml</param-value>
  </context-param>
...


URL to look out for:

1. Hello World : http://localhost:8080/JavaServerFaces/hello.jsf

2. Hello World AJAX : http://localhost:8080/JavaServerFaces/helloAjax.jsf

3. JSF 2.0 redirect and view URL bar : http://localhost:8080/JavaServerFaces/page1.jsf

4. Conditional Navigation Flow : http://localhost:8080/JavaServerFaces/start.jsf (also see PaymentController and faces-config.xml)

5. Form-Action Navigation Flow : http://localhost:8080/JavaServerFaces/startFormActionFlow.jsf (also see PageController and faces-config.xml)

6. JSF 2.0 and message-bundle properties : http://localhost:8080/JavaServerFaces/helloMessageBundle.jsf

7. JSF 2.0 and message-I18n properties Internationalization : http://localhost:8080/JavaServerFaces/startI18n.jsf

8. JSF 2.0 and input Text control demo : http://localhost:8080/JavaServerFaces/ui-controls/textboxControl.xhtml

9. JSF 2.0 and input Secret control demo : http://localhost:8080/JavaServerFaces/ui-controls/textboxControl.xhtml

10. JSF 2.0 and input Textarea control demo : http://localhost:8080/JavaServerFaces/ui-controls/textboxControl.xhtml

11. JSF 2.0 and input Checkbox control demo : http://localhost:8080/JavaServerFaces/ui-controls/checkboxControl.xhtml

12. JSF 2.0 and input Radiobutton control demo : http://localhost:8080/JavaServerFaces/ui-controls/radioButtonControl.xhtml

13. JSF 2.0 and input Listbox control demo : http://localhost:8080/JavaServerFaces/ui-controls/listboxControl.xhtml

14. JSF 2.0 and input Multiselect Listbox control demo : http://localhost:8080/JavaServerFaces/ui-controls/multiselectListboxControl.jsf

15. JSF 2.0 and input SelectOneMenu DropDown Control : http://localhost:8080/JavaServerFaces/ui-controls/selectOneMenuControl.jsf

15. JSF 2.0 and OutputText Tag : http://localhost:8080/JavaServerFaces/ui-controls/outputText/outputText.xhtml

16. JSF 2.0 and OutputFormat Tag (Display parameterized text) : http://localhost:8080/JavaServerFaces/ui-controls/outputFormat/outputFormat.xhtml

17. JSF 2.0 and Graphic Image Tag : http://localhost:8080/JavaServerFaces/ui-controls/graphicImage/graphicImageControl.xhtml

18. JSF 2.0 and Output Style Sheet : http://localhost:8080/JavaServerFaces/ui-controls/outputStyleSheet/outputStyleSheetControl.xhtml

19. JSF 2.0 and Output Script : http://localhost:8080/JavaServerFaces/ui-controls/jsRes/outputScript.xhtml

20. JSF 2.0 link, commandLink and outputLink example : http://localhost:8080/JavaServerFaces/ui-controls/link/login.xhtml

21. JSF 2.0 panelGrid example, In JSF , "h:panelGrid" tag is used to generate HTML table tags to place JSF components in rows and columns layout, from left to right, top to bottom (To test enter Alphabets not number) : http://localhost:8080/JavaServerFaces/ui-controls/panelGrid/panelGrid.jsf

22. JSF 2.0 message and messages example, To view this output, enter invalid inputs like, less-than 5 letter string, and age above 200 : http://localhost:8080/JavaServerFaces/ui-controls/message/message.jsf

23. JSF 2.0 In JSF, "f:param" tag allow you to pass a parameter to a component, but it's behavior is different depends on which type of component it's attached : http://localhost:8080/JavaServerFaces/ui-controls/param/param.xhtml

24. JSF 2.0 attribute example, In JSF, "f:attribute" tag allow you to pass a attribute value to a component, or a parameter to a component via action listener. : http://localhost:8080/JavaServerFaces/ui-controls/attribute/attribute.xhtml

25. JSF 2.0 setPropertyActionListener example, In JSF, "f:setPropertyActionListener" tag is allow you to set a value directly into the property of your backing bean : http://localhost:8080/JavaServerFaces/ui-controls/setPropertyActionListener/setPropertyActionListener.xhtml

26. JSF 2.0 and dataTable sample : http://localhost:8080/JavaServerFaces/table/displayTable.jsf

27. JSF 2.0 and add new order sample : http://localhost:8080/JavaServerFaces/table/addOrder.jsf

28. JSF 2.0 and delete order using AJAX and table refresh : http://localhost:8080/JavaServerFaces/table/displayTable.jsf (Click on the delete link (present against each order) after adding a new order)

29. JSF 2.0 and edit using AJAX and complete flow for CRUD on orders : http://localhost:8080/JavaServerFaces/table/displayTable.jsf

30. JSF 2.0 and templating :
     i.  http://localhost:8080/JavaServerFaces/templating/viewTemplatedPage.jsf
     ii. http://localhost:8080/JavaServerFaces/templating/page1.jsf (With custom data)
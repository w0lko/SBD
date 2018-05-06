
********************************************************************
About this project
********************************************************************

This project demonstrates the simplest possible Versant JPA
application with create, read, update and delete (CRUD) operations.

Note: This example does not require the Versant JPA plugin
for Eclipse to be installed.

Warning: If you place this example project in a folder, which is a
subfolder of your Eclipse workspace folder, you will have to update
the projects library references manually to get rid of Eclipse
build path errors.

********************************************************************
Database connection information
********************************************************************

The database connection information is specified in
/src/META-INF/persistence.xml as follows:

<properties>
  <property name="versant.connectionURL" value="jpa_hello_world@localhost" />
</properties>


********************************************************************
Running the Application
********************************************************************

Versant JPA relies on runtime enhancement using a Java agent.

When you run Versant JPA applications, you need to add this
agent to the VM parameters.

We did this for you by creating a launcher for the 'Program'
application:

-javaagent:../../lib/versantjpa-2.0.jar=jpa_hello_world

To run from Eclipse, you can simply right-click on
com.versant.jpa.helloworld.HelloWorldMain and select
Run As Java Application

We have also created an Ant build file to run this sample project.


Running from Eclipse or from Ant should print the following:

"Creating database...database created
Created: Earth
Hello from Earth
Hello from the blue planet
All Worlds deleted
Removing database...database removed
That's all folks."


Enjoy using Versant JPA!
Your Versant JPA team.

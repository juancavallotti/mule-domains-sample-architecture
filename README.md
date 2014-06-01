Sample Architecture with Mule Domains
================================

This project is a POC of a Mule Domain, that can be built with [mule's gradle plugin](https://github.com/mulesoft-labs/mule-gradle-plugin).

This project consists in two modules:

  * API: This module exposes an API Through APIKit, and communicates through JMS with the backend module. The JMS connector is shared and is used to perform inter-app communication, by taking advantage of an embedded ActiveMQ.
  * Backend: This module uses the new DB module to perform various operations against the Database.

How to run:

  1. Clone and build the [gradle plugin](https://github.com/mulesoft-labs/mule-gradle-plugin) as shown on its readme.
  1. Download mule community eddition from [MuleSoft](http://www.mulesoft.org), unzip it and start it with `$ bin/mule`
  1. Edit the file `build.gradle` and change the install path to where you have installed Mule CE, please don't specify subfolders.
  1. Run the task `$ gradle install`, this will trigger the build and installation of the domain in mule.
  1. With your browser access [the API console](http://localhost:8081/api/console) and have fun with the operations.
 
  

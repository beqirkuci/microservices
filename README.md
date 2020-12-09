---
tags: [spring cloud, zuul , eureka]
projects: [spring-cloud, spring-cloud-netflix]
---
:spring_version: current
:spring_cloud_version: Hoxton.SR9
:java_version: 11

This guide walks you through the process of routing and filtering requests to a
microservice application by using the Netflix Zuul edge service library.

== What You Will Build

You will two microservices applications and then build a reverse proxy
application that uses https://github.com/spring-cloud/spring-cloud-netflix[Netflix Zuul]
to forward requests to the service proxy service application. You will also see how to use Zuul to
filter requests that are made through the proxy service.

== What You Need

:java_version: 11

[[scratch]]
== Starting with Spring Initializr

For all Spring applications, you should start with the https://start.spring.io[Spring
Initializr]. The Initializr offers a fast way to pull in all the dependencies you need for
an application and does a lot of the set up for you.

This guide needs four applications. The first application (the microservice-a application) needs Spring Web dependency and eureka-client dependency,
The second application (the microservice-b application) needs the Spring Web dependency,eureka-client dependency,netflix-archaius.

The following listing shows the `pom.xml` file (for two applications) that where created
when you choose Maven:

====
[src,xml]
----
include::initial/book/pom.xml[]
----
====

The following listing shows the `build.gradle` file (for the book application) that is
created when you choose Gradle:

====
[src,groovy]
----
include::initial/book/build.gradle[]
----
====

The third application (the routing and filtering application) needs the Spring Web,Zuul dependencies and Eureka. 

The following listing shows the `pom.xml` file (for the routing and filtering application)
that is created when you choose Maven:

====
[src,xml]
----
include::initial/gateway/pom.xml[]
----
====

The following listing shows the `build.gradle` file (for the routing and filtering
application) that is created when you choose Gradle:

====
[src,groovy]
----
include::initial/gateway/build.gradle[]
----
====

[[initial]]
== Set up a Microservice

The microservicea-a and microservicea-b  will be as simple as a Spring application can be. Edit
`MicroserviceAApplication.java` and `MicroserviceBApplication.java` so that it matches the following
listing (from
`microservice-a\src\main\java\com\example\microservicea\MicroserviceAApplication.java`):
`microservice-b\src\main\java\com\example\microservicea\MicroserviceBApplication.java`):


[source,properties]
----
include:microservice-a\src\main\resources\application.properties[]
include:microservice-b\src\main\resources\application.properties[]
----
====

Set `server.port` here, too, so that it does not conflict with your edge service when you
get both services up and running locally.

== Create an Edge Service

Spring Cloud Netflix includes an embedded Zuul proxy, which you can enable with the
`@EnableZuulProxy` annotation. This will turn the Gateway application into a reverse proxy
that forwards relevant calls to other services -- such as our book application.

Open the Gateway application's `ZuulProxyEurekaApplication`
class and add the `@EnableZuulProxy` annotation, as the following listing (from
`zuul-proxy-eureka\src\main\java\com\example\zuulproxyeureka\ZuulProxyEurekaApplication.java`)
shows:

====


[source,properties]
----
include::zuul-proxy-eureka\src\main\resources\application.properties[]
----
====

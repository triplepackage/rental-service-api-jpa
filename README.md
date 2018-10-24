# Spring Boot REST API with JPA

http://ec2-34-204-247-182.compute-1.amazonaws.com:8080/swagger-ui.html

Sample REST API project using the following technologies
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger
- Docker

![Alt text](images/github-jpa-001.jpg?raw=true "Step 01")
![Alt text](images/github-jpa-002.jpg?raw=true "Step 02")
![Alt text](images/github-jpa-003.jpg?raw=true "Step 03")
![Alt text](images/github-jpa-004.jpg?raw=true "Step 04")
![Alt text](images/github-jpa-005.jpg?raw=true "Step 05")
![Alt text](images/github-jpa-006.jpg?raw=true "Step 06")
![Alt text](images/github-jpa-007.jpg?raw=true "Step 07")
![Alt text](images/github-jpa-008.jpg?raw=true "Step 08")
![Alt text](images/github-jpa-009.jpg?raw=true "Step 09")
![Alt text](images/github-jpa-011.jpg?raw=true "Step 10")


## Running Docker Container

Note that if you're MySql instance is running inside a Docker container, you will need to update the database url host in application.properties

<pre>
Johns-MBP:.ssh admin$ docker ps -a
CONTAINER ID        IMAGE                       COMMAND                  CREATED             STATUS                    PORTS                    NAMES
a7525de941ab        83e14038cd41                "sh -c 'java $JAVA_O…"   7 minutes ago       Up 5 minutes              0.0.0.0:8080->8080/tcp   epic_roentgen
3661d89bf328        flask-app                   "python web_api.py"      4 months ago        Exited (0) 2 months ago                            hopeful_hypatia
69f5bbae9e26        ubuntu                      "/bin/bash"              8 months ago        Exited (0) 2 months ago                            priceless_banach
e4efea270cbf        mongo                       "docker-entrypoint.s…"   8 months ago        Up 3 days                 27017/tcp                some-mongo
c1d991eb7615        jupyter/scipy-notebook      "tini -- start-noteb…"   8 months ago        Up 4 weeks                0.0.0.0:8888->8888/tcp   cocky_panini
6db215c5ec25        mysql/withrentaldb:latest   "docker-entrypoint.s…"   8 months ago        Up 3 days                 0.0.0.0:3306->3306/tcp   mysql
5c169dd65757        rocker/rstudio              "/init"                  8 months ago        Exited (0) 2 months ago                            practical_mccarthy
Johns-MBP:.ssh admin$ docker inspect 6db215c5ec25 | grep IPAddress
            "SecondaryIPAddresses": null,
            "IPAddress": "172.17.0.4",
                    "IPAddress": "172.17.0.4",
Johns-MBP:.ssh admin$ 
</pre>

Contents of application.properties
<pre>
spring.datasource.url=jdbc:mysql://172.17.0.4:3306/rental
spring.datasource.username=******
spring.datasource.password=*******
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
server.port=8080
</pre>

## Gradle Build Notes
To skip running test when performing gradle buildDocker
<pre>
Johns-MBP:rental-service-api-jpa admin$ gradle buildDocker -x test

> Task :buildDocker
Sending build context to Docker daemon  77.23MB

Step 1/6 : FROM frolvlad/alpine-oraclejdk8:slim
 ---> c887553bc35c
Step 2/6 : VOLUME /tmp
 ---> Using cache
 ---> dadfad5cb181
Step 3/6 : ADD rental-service-api-0.0.1-SNAPSHOT.jar app.jar
 ---> 723051f79922
Step 4/6 : RUN sh -c 'touch /app.jar'
 ---> Running in f3267409fa58
Removing intermediate container f3267409fa58
 ---> 9886fce58db0
Step 5/6 : ENV JAVA_OPTS=""
 ---> Running in 4269e1ea9943
Removing intermediate container 4269e1ea9943
 ---> bbedcada7693
Step 6/6 : ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
 ---> Running in 95317a34af59
Removing intermediate container 95317a34af59
 ---> 83e14038cd41
Successfully built 83e14038cd41
Successfully tagged com.rental/rental-service-api:0.0.1-SNAPSHOT


BUILD SUCCESSFUL in 5s
4 actionable tasks: 1 executed, 3 up-to-date
Johns-MBP:rental-service-api-jpa admin$ 

</pre>

## Running The Docker Container
<pre>
Johns-MacBook-Pro:libs admin$ docker images
REPOSITORY                      TAG                 IMAGE ID            CREATED             SIZE
com.rental/rental-service-api   0.0.1-SNAPSHOT      83e14038cd41        14 minutes ago      244MB
Johns-MacBook-Pro:libs admin$ docker run -p 8080:8080 83e14038cd41 -t --name rental-service-api-jpa

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.0.4.RELEASE)

2018-09-08 10:31:30.483  INFO 6 --- [           main] com.rental.RentalApplication             : Starting RentalApplication on bb1f901a9db5 with PID 6 (/app.jar started by root in /)
2018-09-08 10:31:30.489  INFO 6 --- [           main] com.rental.RentalApplication             : No active profile set, falling back to default profiles: default
2018-09-08 10:31:30.558  INFO 6 --- [           main] ConfigServletWebServerApplicationContext : Refreshing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@5b1d2887: startup date [Sat Sep 08 10:31:30 GMT 2018]; root of context hierarchy
2018-09-08 10:31:32.176  INFO 6 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.ws.config.annotation.DelegatingWsConfiguration' of type [org.springframework.ws.config.annotation.DelegatingWsConfiguration$$EnhancerBySpringCGLIB$$9ad9497e] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2018-09-08 10:31:32.238  INFO 6 --- [           main] .w.s.a.s.AnnotationActionEndpointMapping : Supporting [WS-Addressing August 2004, WS-Addressing 1.0]
2018-09-08 10:31:32.275  INFO 6 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$f641847f] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2018-09-08 10:31:32.338  INFO 6 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.hateoas.config.HateoasConfiguration' of type [org.springframework.hateoas.config.HateoasConfiguration$$EnhancerBySpringCGLIB$$75c1d1b1] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2018-09-08 10:31:32.896  INFO 6 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2018-09-08 10:31:32.940  INFO 6 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2018-09-08 10:31:32.940  INFO 6 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.32
2018-09-08 10:31:32.958  INFO 6 --- [ost-startStop-1] o.a.catalina.core.AprLifecycleListener   : The APR based Apache Tomcat Native library which allows optimal performance in production environments was not found on the java.library.path: [/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib]
2018-09-08 10:31:33.154  INFO 6 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2018-09-08 10:31:33.154  INFO 6 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2598 ms
2018-09-08 10:31:33.248  INFO 6 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Servlet dispatcherServlet mapped to [/]
2018-09-08 10:31:33.250  INFO 6 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Servlet messageDispatcherServlet mapped to [/services/*]
2018-09-08 10:31:33.254  INFO 6 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2018-09-08 10:31:33.255  INFO 6 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2018-09-08 10:31:33.255  INFO 6 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2018-09-08 10:31:33.255  INFO 6 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2018-09-08 10:31:33.490  INFO 6 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
Sat Sep 08 10:31:33 GMT 2018 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
2018-09-08 10:31:34.053  INFO 6 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2018-09-08 10:31:34.113  INFO 6 --- [           main] j.LocalContainerEntityManagerFactoryBean : Building JPA container EntityManagerFactory for persistence unit 'default'
2018-09-08 10:31:34.136  INFO 6 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [
	name: default
	...]
Sat Sep 08 10:31:34 GMT 2018 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
Sat Sep 08 10:31:34 GMT 2018 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
2018-09-08 10:31:34.272  INFO 6 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.2.17.Final}
2018-09-08 10:31:34.274  INFO 6 --- [           main] org.hibernate.cfg.Environment            : HHH000206: hibernate.properties not found
Sat Sep 08 10:31:34 GMT 2018 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
2018-09-08 10:31:34.381  INFO 6 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.0.1.Final}
Sat Sep 08 10:31:34 GMT 2018 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
Sat Sep 08 10:31:34 GMT 2018 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
Sat Sep 08 10:31:34 GMT 2018 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
Sat Sep 08 10:31:34 GMT 2018 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
2018-09-08 10:31:34.668  INFO 6 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQL5Dialect
Sat Sep 08 10:31:34 GMT 2018 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
Sat Sep 08 10:31:34 GMT 2018 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
2018-09-08 10:31:35.431  INFO 6 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2018-09-08 10:31:36.254  WARN 6 --- [           main] aWebConfiguration$JpaWebMvcConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2018-09-08 10:31:36.342  INFO 6 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/api/rental/{rentalId}],methods=[GET],produces=[application/json]}" onto public com.rental.domain.Rental com.rental.web.RentalController.rental(int)
2018-09-08 10:31:36.344  INFO 6 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/api/rentals/street/{streetName}],methods=[GET],produces=[application/json]}" onto public java.util.List<com.rental.domain.Rental> com.rental.web.RentalController.getRentalByStreetName(java.lang.String)
2018-09-08 10:31:36.344  INFO 6 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/api/rentals/city/{cityName}],methods=[GET],produces=[application/json]}" onto public java.util.List<com.rental.domain.Rental> com.rental.web.RentalController.getRentalByCity(java.lang.String)
2018-09-08 10:31:36.345  INFO 6 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/v2/api-docs],methods=[GET]}" onto public org.springframework.http.ResponseEntity<springfox.documentation.spring.web.json.Json> springfox.documentation.swagger2.web.Swagger2Controller.getDocumentation(java.lang.String)
2018-09-08 10:31:36.348  INFO 6 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/configuration/security]}" onto org.springframework.http.ResponseEntity<springfox.documentation.swagger.web.SecurityConfiguration> springfox.documentation.swagger.web.ApiResourceController.securityConfiguration()
2018-09-08 10:31:36.349  INFO 6 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/configuration/ui]}" onto org.springframework.http.ResponseEntity<springfox.documentation.swagger.web.UiConfiguration> springfox.documentation.swagger.web.ApiResourceController.uiConfiguration()
2018-09-08 10:31:36.349  INFO 6 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/swagger-resources]}" onto org.springframework.http.ResponseEntity<java.util.List<springfox.documentation.swagger.web.SwaggerResource>> springfox.documentation.swagger.web.ApiResourceController.swaggerResources()
2018-09-08 10:31:36.352  INFO 6 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2018-09-08 10:31:36.353  INFO 6 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2018-09-08 10:31:36.613  INFO 6 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2018-09-08 10:31:36.862  INFO 6 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@5b1d2887: startup date [Sat Sep 08 10:31:30 GMT 2018]; root of context hierarchy
2018-09-08 10:31:36.943  INFO 6 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2018-09-08 10:31:36.943  INFO 6 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2018-09-08 10:31:37.594  INFO 6 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2018-09-08 10:31:37.597  INFO 6 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'dataSource' has been autodetected for JMX exposure
2018-09-08 10:31:37.602  INFO 6 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Located MBean 'dataSource': registering with JMX server as MBean [com.zaxxer.hikari:name=dataSource,type=HikariDataSource]
2018-09-08 10:31:37.614  INFO 6 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
2018-09-08 10:31:37.644  INFO 6 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found {0} custom documentation plugin(s)
2018-09-08 10:31:37.658  INFO 6 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2018-09-08 10:31:37.662  INFO 6 --- [           main] s.w.ClassOrApiAnnotationResourceGrouping : Group for method rental was rental-controller
2018-09-08 10:31:37.665  INFO 6 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Request mapping: rental belongs to groups: [[ResourceGroup{groupName='rental-controller', position=0, controller=com.rental.web.RentalController}]] 
2018-09-08 10:31:37.666  INFO 6 --- [           main] s.w.ClassOrApiAnnotationResourceGrouping : Group for method getRentalByCity was rental-controller
2018-09-08 10:31:37.667  INFO 6 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Request mapping: getRentalByCity belongs to groups: [[ResourceGroup{groupName='rental-controller', position=0, controller=com.rental.web.RentalController}]] 
2018-09-08 10:31:37.667  INFO 6 --- [           main] s.w.ClassOrApiAnnotationResourceGrouping : Group for method getRentalByStreetName was rental-controller
2018-09-08 10:31:37.667  INFO 6 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Request mapping: getRentalByStreetName belongs to groups: [[ResourceGroup{groupName='rental-controller', position=0, controller=com.rental.web.RentalController}]] 
2018-09-08 10:31:37.671  INFO 6 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Created resource listing Path: /default/rental-controller Description: rental-controller Position: 0
2018-09-08 10:31:37.771  INFO 6 --- [           main] s.w.ClassOrApiAnnotationResourceGrouping : Group for method getRentalByCity was rental-controller
2018-09-08 10:31:37.806  INFO 6 --- [           main] s.w.ClassOrApiAnnotationResourceGrouping : Group for method getRentalByStreetName was rental-controller
2018-09-08 10:31:37.814  INFO 6 --- [           main] s.w.ClassOrApiAnnotationResourceGrouping : Group for method rental was rental-controller
2018-09-08 10:31:37.869  INFO 6 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2018-09-08 10:31:37.876  INFO 6 --- [           main] com.rental.RentalApplication             : Started RentalApplication in 7.928 seconds (JVM running for 8.603)
</pre>

![Alt text](images/github-jpa-011.jpg?raw=true "Step 10")

Test Endpoint Using Postman
![Alt text](images/github-jpa-012.jpg?raw=true "Step 10")

## Helpful Command Line Stuff

<pre>
Johns-MBP:rental-service-api-jpa admin$ ./gradlew

Welcome to Gradle 4.8.1!

Here are the highlights of this release:
 - Dependency locking
 - Maven Publish and Ivy Publish plugins improved and marked stable
 - Incremental annotation processing enhancements
 - APIs to configure tasks at creation time

For more details see https://docs.gradle.org/4.8.1/release-notes.html

Starting a Gradle Daemon (subsequent builds will be faster)

> Task :help

Welcome to Gradle 4.8.1.

To run a build, run gradlew <task> ...

To see a list of available tasks, run gradlew tasks

To see a list of command-line options, run gradlew --help

To see more detail about a task, run gradlew help --task <task>

For troubleshooting, visit https://help.gradle.org

BUILD SUCCESSFUL in 3s
1 actionable task: 1 executed

Johns-MBP:rental-service-api-jpa admin$ ./gradlew build

> Task :test
2018-09-07 04:46:54.775  INFO 67074 --- [       Thread-5] o.s.w.c.s.GenericWebApplicationContext   : Closing org.springframework.web.context.support.GenericWebApplicationContext@3eb6d41a: startup date [Fri Sep 07 04:46:51 EDT 2018]; root of context hierarchy
2018-09-07 04:46:54.778  INFO 67074 --- [       Thread-5] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2018-09-07 04:46:54.778  INFO 67074 --- [       Thread-5] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2018-09-07 04:46:54.783  INFO 67074 --- [       Thread-5] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.


Johns-MBP:rental-service-api-jpa admin$ git init
Initialized empty Git repository in /Users/admin/GitHub/rental-service-api-jpa/.git/

Johns-MBP:rental-service-api-jpa admin$ git status -uno
On branch master

No commits yet

Johns-MBP:rental-service-api-jpa admin$ git add *
The following paths are ignored by one of your .gitignore files:
build
out
Use -f if you really want to add them.
Johns-MBP:rental-service-api-jpa admin$ git status
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)

        new file:   build.gradle
        new file:   gradle/wrapper/gradle-wrapper.jar
        new file:   gradle/wrapper/gradle-wrapper.properties
        new file:   gradlew
        new file:   gradlew.bat
        new file:   settings.gradle
        new file:   src/main/java/com/rental/RentalApplication.java
        new file:   src/main/java/com/rental/domain/Rental.java
        new file:   src/main/java/com/rental/domain/RentalRepository.java
        new file:   src/main/java/com/rental/web/ApiDocumentationConfiguration.java
        new file:   src/main/java/com/rental/web/RentalController.java
        new file:   src/test/java/com/sample/SampleApplicationTests.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)

        .gitignore

Johns-MBP:rental-service-api-jpa admin$ git commit -m "Initial creation."
[master (root-commit) 7396e98] Initial creation.
 12 files changed, 496 insertions(+)
 create mode 100644 build.gradle
 create mode 100644 gradle/wrapper/gradle-wrapper.jar
 create mode 100644 gradle/wrapper/gradle-wrapper.properties
 create mode 100755 gradlew
 create mode 100644 gradlew.bat
 create mode 100644 settings.gradle
 create mode 100644 src/main/java/com/rental/RentalApplication.java
 create mode 100644 src/main/java/com/rental/domain/Rental.java
 create mode 100644 src/main/java/com/rental/domain/RentalRepository.java
 create mode 100644 src/main/java/com/rental/web/ApiDocumentationConfiguration.java
 create mode 100644 src/main/java/com/rental/web/RentalController.java
 create mode 100644 src/test/java/com/sample/SampleApplicationTests.java
 
Johns-MBP:rental-service-api-jpa admin$ git remote add origin https://github.com/triplepackage/rental-service-api-jpa.git
Johns-MBP:rental-service-api-jpa admin$ git pull
warning: no common commits
remote: Counting objects: 3, done.
remote: Compressing objects: 100% (2/2), done.
remote: Total 3 (delta 0), reused 0 (delta 0), pack-reused 0
Unpacking objects: 100% (3/3), done.
From https://github.com/triplepackage/rental-service-api-jpa
 * [new branch]      master     -> origin/master
There is no tracking information for the current branch.
Please specify which branch you want to merge with.
See git-pull(1) for details.

    git pull <remote> <branch>

If you wish to set tracking information for this branch you can do so with:

    git branch --set-upstream-to=origin/<branch> master

Johns-MBP:rental-service-api-jpa admin$ git push -f origin master
Counting objects: 27, done.
Delta compression using up to 8 threads.
Compressing objects: 100% (19/19), done.
Writing objects: 100% (27/27), 54.58 KiB | 10.92 MiB/s, done.
Total 27 (delta 0), reused 0 (delta 0)
To https://github.com/triplepackage/rental-service-api-jpa.git
 + e65bd23...7396e98 master -> master (forced update)


</pre>
# Use Environment Variables For Database Settings
Modify application.settings as follows:
<pre>
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=update
server.port=8080
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type=TRACE
</pre>

For debugging in IntelliJ, set the environment variables as such:
![Alt text](images/github-jpa-013.jpg?raw=true "Step 10")

If running via Docker container, do the following:
<pre>
docker run -e SPRING_DATASOURCE_URL=jdbc:mysql://172.17.0.4:3306/rental?useSSL=false -e SPRING_DATASOURCE_USERNAME=root -e SPRING_DATASOURCE_PASSWORD=xxxxx -p 8080:8080 bc0dcce8f41e -t --name rental-service-api-jpa
</pre>

When building the Docker container via IntelliJ terminal, be sure to set the database environment variable. Otherwise, the build will fail.
<pre>
Johns-MBP:rental-service-api-jpa admin$ export SPRING_DATASOURCE_URL=jdbc:mysql://127.0.0.1:3306/rental
Johns-MBP:rental-service-api-jpa admin$ export SPRING_DATASOURCE_USERNAME=root
Johns-MBP:rental-service-api-jpa admin$ export SPRING_DATASOURCE_PASSWORD=xxxx
Johns-MBP:rental-service-api-jpa admin$ ./gradlew buildDocker 

> Task :buildDocker
Sending build context to Docker daemon  77.23MB

Step 1/6 : FROM frolvlad/alpine-oraclejdk8:slim
 ---> c887553bc35c
Step 2/6 : VOLUME /tmp
 ---> Using cache
 ---> dadfad5cb181
Step 3/6 : ADD rental-service-api-0.0.1-SNAPSHOT.jar app.jar
 ---> Using cache
 ---> 927824028b80
Step 4/6 : RUN sh -c 'touch /app.jar'
 ---> Using cache
 ---> beeebf9e047f
Step 5/6 : ENV JAVA_OPTS=""
 ---> Using cache
 ---> 06763f0732a4
Step 6/6 : ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
 ---> Using cache
 ---> f3066e77b0cf
Successfully built f3066e77b0cf
Successfully tagged com.rental/rental-service-api:0.0.1-SNAPSHOT


BUILD SUCCESSFUL in 2s
6 actionable tasks: 1 executed, 5 up-to-date
Johns-MBP:rental-service-api-jpa admin$ 
</pre>

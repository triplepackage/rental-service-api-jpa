# Spring Boot REST API with JPA

Sample REST API project using the following technologies
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger

![Alt text](images/github-jpa-001.jpg?raw=true "Step 01")
![Alt text](images/github-jpa-002.jpg?raw=true "Step 02")
![Alt text](images/github-jpa-003.jpg?raw=true "Step 03")
![Alt text](images/github-jpa-004.jpg?raw=true "Step 04")
![Alt text](images/github-jpa-005.jpg?raw=true "Step 05")
![Alt text](images/github-jpa-006.jpg?raw=true "Step 06")
![Alt text](images/github-jpa-007.jpg?raw=true "Step 07")
![Alt text](images/github-jpa-008.jpg?raw=true "Step 08")
![Alt text](images/github-jpa-009.jpg?raw=true "Step 09")
![Alt text](images/github-jpa-010.jpg?raw=true "Step 10")

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

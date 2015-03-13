# bpersonalia
Belajar Java Bareng - HR System

## What is it?
bpersonalia is an opensource software for HR system. At beginning state of this project, it is intented as learning java project for new developer but not to close opportunity become embrio for real production grade of opensource HR System.

The HR System will be develop based on regulation of Indonesia Policy (UU Ketenagakerjaan Indonesia).

## Roadmap
##### Alpha 1 
1. Employee Master 
2. Recruitment Management
3. Leave Management

##### Alpha 2
1. employe grade/leveling
2. training
3. job spesification/job position/gap management

##### Alpha 3
1. Time Management
2. Compensation & Benefit
3. Payroll

##### Alpha 4
1. Onboarding
2. terminating

## Technology Stack
- Maven 3
- Spring MVC 4
- MyBatis 3
- PostgreSQL

## Quick Run
Clone this repo into your machine, and make sure following configuration correct

1. Application database connection config on ```src/main/resources/spring/application.properties```. You also can create new configuration file ```src/main/resources/spring/application.local.properties```. This second file wont be pushed to remote git repo.
2. [Liquibase](http://www.liquibase.org/) maven plugin configuration for database connection on ```pom.xml``` file. Next, this two configurations must read from same source.

Then you can run using embedded jetty servlet container using following command from project root directory

```sh
mvn clean jetty:run
```

or by using embedded tomcat container using following command

```sh
mvn clean tomcat7:run
```
On each of command, liquibase maven plugin will populate all changeset logged on ```src/main/resource/liquibase/changelog.xml```, so no need to pass raw sql file of ddl and dml of application.

If you want to run on standalone servlet container, please execute following command first from project root directory.

```sh
mvn liquibase:update
```

### Known Issues
Because web integration tests are using same database with development, some test will fail if any data already exists on database, especially for test requiring verification against row number on database. Next this two mechanism must be configured to use separate database (i.e testing using in memory embedded database). 

## How to Contribute
- Fork this project to your GitHub account
- Clone your fork to local computer
- Create a topic or feature branch, don't work in the master branch. This will avoid breaking the master branch and help keeping it as a productive branch
- Make some commits to improve the project
- Push your branch to your fork
- Open a pull request on GitHub

## How to Contact Project Maintainer
Using social media (Whatsapp Messenger, [Facebook Group](https://www.facebook.com/groups/1551068508508353/))


all are still proposal/draft, subject to other member proposal/discussion


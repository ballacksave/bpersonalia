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

1. Application database connection config on ```src/main/resources/spring/application.properties```. You also can create new configuration file ```src/main/resources/spring/application.local.properties```. This second file already ignored by git so wont be pushed to remote git repo.
2. 

Then, from project root directory, execute following command to run using embedded jetty servlet-container 

```sh
mvn clean jetty:run
```

or by using embedded tomcat container using following command

```sh
mvn clean tomcat7:run
```

Please note, on each of spring's context initialized, integration component for liquibase and spring ```liquibase.integration.spring.SpringLiquibase``` (Configured on ```src/main/resources/spring/back/data-context.xml) will populate all diff changeset logged on ```src/main/resource/liquibase/changelog.xml``` (diff compare to your current database change state), so no need to pass raw sql file of ddl and dml of application.

## How to Contribute
### Workflow
- Fork this project to your GitHub account
- Clone your fork to local computer
- Create a topic or feature branch, don't work in the master branch. This will avoid breaking the master branch and help keeping it as a productive branch
- Make some commits to improve the project
- Push your branch to your fork
- Open a pull request on GitHub

### Make Changes
Following are guidelines how to make change

#### Data Access
This project MyBatis as persistence engine. Use ```org.bareng.hr.back.repository.Repository<T, I>``` parameterized interface as contract, so we get uniform MyBatis mapping name. When not generic mapping name required, just write them on extended type. Please note, you have to write mapping for required methods only, otherwise ignore them.

```java
package org.bareng.hr.back.repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface Repository<T, I> {
    boolean insert(T entity);
    int insertAll(List<T> entities);
    boolean update(T entity);
    int updateAll(Iterable<T> entities);
    boolean exists(I id);
    List<T> findAll();
    List<T> findAll(RowBounds rowBounds);
    List<T> findAll(RowBounds rowBounds, String... sorts);
    T findOne(I id);
    Long countAll();
    boolean delete(I id);
    int deleteAll(Iterable<I> ids);
}
```

Xml mapper used as main mechanism for mapping required sql statements instead of annotation, because (as explained on documentations) there are some limitations on using annotation based mapping compare to xml mapping. Please note, we are using [HSQLDB](http://hsqldb.org/) embedded in-memory database for unit and integration test requiring "real" database connection. According to that, please use ANSI sql statements as long as possible. For any case requiring vendor specifics sql statements, please write separate mapping for each of them (In our case first for PostgreSql and second for HSQLDB), each specific mapping differentiated by ```databaseId``` MyBatis mapping attribute. Look at following snippet for example, in this case ```databaseId``` mapping attribute used inside ```<selectKey>``` element, please read MyBatis [documentation](https://mybatis.github.io/mybatis-3/) for details. 

```xml
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="org.bareng.hr.back.repository.EmployeeRepository">
	<!-- ...other mapping elements here... -->
	
	<!-- Saving employee data, and set id property of parameter object with database generated id wich is assigned for related database row after insert operation  -->
    <insert id="insert" parameterType="Employee"
        useGeneratedKeys="true">
		<![CDATA[
		INSERT INTO tb_employee(register_number, full_name, birth_date, email_address, gender_type) 
		VALUES (#{regNumber}, #{fullName}, #{birthDate}, #{emailAddress}, #{gender})
		]]>
        <selectKey order="AFTER" keyProperty="id" resultType="java.lang.Integer" databaseId="postgre">
			<![CDATA[SELECT CURRVAL('tb_employee_id_seq')]]>
        </selectKey>
        <selectKey order="AFTER" keyProperty="id" resultType="java.lang.Integer" databaseId="hsqldb">
            <![CDATA[CALL IDENTITY()]]>
        </selectKey>
    </insert>
    
    <!-- ...other mapping elements... -->
</mapper>
```

#### Service Object
TBD

#### Controller
TBD

#### Testing
If you use spring-test module for testing, please don't forget to 

- Annotate with ```@ActiveProfile("test")``` for each test type requiring real database connection to use HSQLDB embedded in-memory database instead of default PostgreSQL database. 
- For each types requiring database manipulation, annotate them or test method with ```Transactional(required=Propagation.REQUIRED)``` so that after test method executions spring-test infrastructure will rollback your database state.

Use Mockito mock or stub object for collaborator.

Use hamcrest matchers for verifying your test state.

## How to Contact Project Maintainer
Using social media (Whatsapp Messenger, [Facebook Group](https://www.facebook.com/groups/1551068508508353/))


all are still proposal/draft, subject to other member proposal/discussion


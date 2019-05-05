# PPMTool
Full Stack Project: Spring Boot 2.0, ReactJS, Redux

...or create a new repository on the command line

```
echo "# FullStackPPMTool" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/alexlen01/springboot-ppmtool.git
git push -u origin master
```
...or push an existing repository from the command line

```
git remove add origin https://github.com/alexlen01/springboot-ppmtool.git
git push -u origin master
```

... working with a new branch and merging it back to master

```
git branch
git branch branch0
git checkout branch0
git add .
git commit -m "Project Object"
git push --set-upstream origin branch0
git checkout master
git merge branch 0
```

## Daily checkpoints while building FullStackPPMTool:

### Day 1

1. Added **Project** object under _domain_
2. Added **ProjectRepository** object under _repositories_ (added **findAllById** method)
3. Added **ProjectService** object under _services_ (added **saveOrUpdateProject** method and wired **ProjectRepository** instance)
4. Added **ProjectController** object under _web_ (added **createNewProject** method and wired **ProjectService** instance)

### Day 2

5. Modified **Project** object to add data validation for **projectName** and **projectIdentifier**
6. Added custom validation using **MapValidationErrorService** under _services_
7. Added custom error handling using **CustomResponseEntityHandler** under _exceptions_
8. Added remaining CRUD operations for **Project"" entity

### Day 3

9. Added Rest Assured to test **ProjectController** endpoints
10. Revised project package structure using the following conventions:

```
config - class which will read from property files

cache - caching mechanism class files

constants - constant defined class

controller - controller class

exception - exception class

model - pojos classes will be present

security - security classes

service - Impl classes

util - utility classes

validation - validators classes

bootloader - main class
```







## Starting SpringBoot application and testing REST API

1. Run _com.local.ppmtool.PPMToolApplication_ as **Spring Boot App**

2. Make the REST API call(s) using CURL, PostMan, or SoapUI:

```
POST http://localhost:8080/api/project
GET http://localhost:8080/api/project/{projectId}
GET http://localhost:8080/api/project/all
DELETE http://localhost:8080/api/project/{projectId}
```

3. Run H2 Console and confirm project entry was successful:

```
http://localhost:8080/h2-console

SELECT * FROM PROJECT
```

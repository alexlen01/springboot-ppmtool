# FullStackPPMTool
Full Stack Project: Spring Boot 2.0, ReactJS, Redux

...or create a new repository on the command line

```
echo "# FullStackPPMTool" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/alexlen01/FullStackPPMTool.gif
git push -u origin master
```
...or push an existing repository from the command line

```
git remove add origin https://github.com/alexlen01/FullStackPPMTool.gif
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

## First steps in building FullStackPPMTool:

1. Added **Project** object under _domain_
2. Added **ProjectRepository** object under _repositories_ (added **findAllById** method)
3. Added **ProjectService** object under _services_ (added **saveOrUpdateProject** method and wired **ProjectRepository** instance)
4. Added **ProjectController** object under _web_ (added **createNewProject** method and wired **ProjectService** instance)

## Starting SpringBoot application and testing REST API

1. Run _com.local.ppmtool.SpringBootPPMToolApplication.java_ as **Spring Boot App**
2. Make a REST API call using CURL, PostMan, or SoapUI:


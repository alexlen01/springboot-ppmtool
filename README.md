# FullStackPPMTool
Full Stack Project: Spring Boot 2.0, ReactJS, Redux

...or create a new repository on the command line

echo "# FullStackPPMTool" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/alexlen01/FullStackPPMTool.gif
git push -u origin master

...or push an existing repository from the command line

git remove add origin https://github.com/alexlen01/FullStackPPMTool.gif
git push -u origin master


... working with a new branch

Alex@ELITE MINGW64 ~/git/springboot-ppmtool (master)
$ git branch
* master

Alex@ELITE MINGW64 ~/git/springboot-ppmtool (master)
$ git branch branch0

Alex@ELITE MINGW64 ~/git/springboot-ppmtool (master)
$ git branch
  branch0
* master

Alex@ELITE MINGW64 ~/git/springboot-ppmtool (master)

$ git checkout branch0
Switched to branch 'branch0'

Alex@ELITE MINGW64 ~/git/springboot-ppmtool (branch0)
$ git add .

Alex@ELITE MINGW64 ~/git/springboot-ppmtool (branch0)
$ git commit -m "Project Object"
[branch0 9745793] Project Object
 2 files changed, 40 insertions(+)
 create mode 100644 README.md
 create mode 100644 src/main/java/com/local/ppmtool/domain/Project.java

Alex@ELITE MINGW64 ~/git/springboot-ppmtool (branch0)
$ git push --set-upstream origin branch0
Enumerating objects: 18, done.
Counting objects: 100% (18/18), done.
Delta compression using up to 4 threads
Compressing objects: 100% (7/7), done.
Writing objects: 100% (11/11), 1.10 KiB | 282.00 KiB/s, done.
Total 11 (delta 1), reused 0 (delta 0)
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
remote:
remote: Create a pull request for 'branch0' on GitHub by visiting:
remote:      https://github.com/alexlen01/springboot-ppmtool/pull/new/branch0
remote:
To https://github.com/alexlen01/springboot-ppmtool.git
 * [new branch]      branch0 -> branch0
Branch 'branch0' set up to track remote branch 'branch0' from 'origin'.

Alex@ELITE MINGW64 ~/git/springboot-ppmtool (branch0)

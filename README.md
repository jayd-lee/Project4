# How to use Git and Github (IMPORTANT)


## Understanding git and github

##### *It is important to understand the TWO different types of branches*

- `Local` branch is the code that shows up in your IntelliJ (VScode if ur a dumbass)

- `Remote` branch is the code that shows up on your Github. 

##### *It is important to note that even if you are changing code in the same branch (i.e 'Jayden' branch), your code in `local` and `remote` may be different. You must 'push' your local branch in order to get it updated to your Github.*

# Steps of using git and github Effectively: 
## 1. Update your local branch from the remote branch
##### Say teammate A commits and pushes to 'main'. It is important for teammate B to now access the updated version of the 'main' branch. So, go to main branch and pull from remote to local, so that your branches are updated.

- `pull` updates local branch from remote branch

###### (base) jaydenlee@pal-nat186-63-147 Project4 % git pull
###### remote: Enumerating objects: 10, done.
###### remote: Counting objects: 100% (10/10), done.
###### remote: Compressing objects: 100% (1/1), done.
###### remote: Total 4 (delta 2), reused 4 (delta 2), pack-reused 0
###### Unpacking objects: 100% (4/4), 398 bytes | 79.00 KiB/s, done.
###### From https://github.com/jayd-lee/Project4
######    846393d..cb56c9e  Dhanush    -> origin/Dhanush
###### Updating b83f65d..90b6264
###### Fast-forward
######  src/project4.java | 1 +
######  1 file changed, 1 insertion(+)




## 2. Move to your name's branch and copy code from main branch (or your teammate's branch)

- `checkout {branch name}` moves to the branch you want to MOVE to

###### (base) jaydenlee@pal-nat186-63-147 Project4 %  git checkout Jayden
###### Switched to branch 'Jayden'


- `merge main` after you checkout to your branch, and this will COPY main to your branch. (If there is conflicting differences, change accordingly).

###### (base) jaydenlee@pal-nat186-63-147 Project4 %  git merge main
###### Auto-merging src/project4.java
###### CONFLICT (content): Merge conflict in src/project4.java
###### Automatic merge failed; fix conflicts and then commit the result.


## 3. Change code, and update your branch/repository locally, and remotely

- `add` is whenever you want to APPLY the changes that you made to your code (LOCAL BRANCH). This is a PREPERATION step before you "commit".

###### (base) jaydenlee@pal-nat186-63-147 Project4 % git add src/project4.java 

- `commit -m "{commit message}"` is COMFIRMING the applied changes to your code, and UPDATING your local branch COMPLETELY. Now your local branch is updated.

###### (base) jaydenlee@pal-nat186-63-147 Project4 % git commit -m "commit showing how commit command works"
###### [Jayden c0d219d] commit showing how commit command works


- `push` is when you want to SUBMIT the changes made to your local branch, to "REMOTE" branch. This will UPDATE your code on GITHUB

###### (base) jaydenlee@pal-nat186-63-147 Project4 % git push
###### Enumerating objects: 10, done.
###### Counting objects: 100% (10/10), done.
###### Delta compression using up to 8 threads
###### Compressing objects: 100% (3/3), done.
###### Writing objects: 100% (4/4), 391 bytes | 391.00 KiB/s, done.
###### Total 4 (delta 2), reused 0 (delta 0), pack-reused 0
###### remote: Resolving deltas: 100% (2/2), completed with 2 local objects.
###### To https://github.com/jayd-lee/Project4.git
######    2a74ff3..c0d219d  Jayden -> Jayden


## 4. Merge request on Github to change the main, by pressing the button right after you commit and push





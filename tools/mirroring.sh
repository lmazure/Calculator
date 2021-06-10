#!/bin/bash

source_repo="gitlab.com/lmazure_TestGroup"
source_project="secondtestproject"
target_repo="gitlab.com/lmazure_testmirroring"
target_project="secondtestprojectmirror"
git clone --mirror https://$source_repo/$source_project.git
cd $source_project.git
git show-ref | grep ' refs/merge-requests/' | cut -d' ' -f2 | xargs -n1 -r git update-ref -d # do not push merge-requests refs to GitLab, it will refuse them
git push --mirror https://$target_repo/$target_project.git
cd ..
rm -fr $source_project.git
#!/bin/bash

if [[ $# -ne 4 ]]; then
    echo "Syntax: $0 <source login> <source password> <target login> <target password>"
    exit 2
fi

# for safety reasons, repositories are hardcoded here, so we are sure we will not accidentaly overwrite some unexpected repository by providing wrong arguments on the command line
# for security reasons, the logins/passwords are stored somewhere else

source_repo="gitlab.com/lmazure_TestGroup"
source_project="secondtestproject"
source_login="$1"
source_password="$2"
target_repo="gitlab.com/lmazure_testmirroring"
target_project="secondtestprojectmirror"
target_login="$3"
target_password="$4"

echo "=== cloning https://$source_repo/$source_project.git"
git clone --mirror https://$source_login:$source_password@$source_repo/$source_project.git
if [[ $? -ne 0 ]]; then
    echo "!! Failed to clone https://$source_repo/$source_project.git"
    echo "=== done"
    exit 2
fi

echo "=== cleaning up refs"
cd $source_project.git
git show-ref | grep ' refs/merge-requests/' | cut -d' ' -f2 | xargs -n1 -r git update-ref -d # do not push merge-requests refs to GitLab, it would refuse them

echo "=== pushing to https://$target_repo/$target_project.git"
git push --mirror https://$target_login:$target_password@$target_repo/$target_project.git
if [[ $? -ne 0 ]]; then
    echo "!! Failed to push to https://$target_repo/$target_project.git"
    # keep running the script to delete local repository
fi

echo "=== removing local repository"
cd ..
rm -fr $source_project.git

echo "=== done"

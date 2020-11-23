#!/bin/bash

if [[ $(find -iname '*.java') ]];
then
echo "Ada file Java pada home"
find -iname '*.java'
else
echo "Tidak ada file Java"
fi

#!/bin/bash
[ "$1" = "" ] && echo necesito el mensaje del commit && exit 1
#git add --all
git add .
git commit -am "$1"
git push

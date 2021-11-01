#! /usr/bin/bash

read -p "Enter country names: " -a arr;
echo "${arr[@]/UK/United Kingdom}"
#!/bin/bash

echo "Before appending the file"
cat book.txt

echo "5. Learning Laravel 5">> book.txt
echo "After appending the file"
cat book.txt

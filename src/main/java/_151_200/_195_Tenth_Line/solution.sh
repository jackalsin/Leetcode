#!/usr/bin/env bash
awk '{
    if (NR==10) print$0
}' file.txt


#Solution 2
tail -n +10 file.txt | head -n 1

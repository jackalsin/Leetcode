#!/usr/bin/env bash
awk '{
    for (i = 1; i <= NF; ++i) {
        if(s[i] == "") {
            s[i] = $i;
        } else {
            s[i] = s[i] " " $i;
        }
    }
} END {
    for (i = 1; i<= NF;++i) {
        print s[i];
    }
}' failedCase1.txt

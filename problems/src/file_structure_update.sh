#!/bin/sh
function update_directory_txt {
    update_directory
    find main -type d > directory.txt
}

function update_directory {
    while read -r line; do mkdir -p "$line" ; done < directory.txt
}
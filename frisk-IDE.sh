#!/bin/sh
printf '\033c\033]0;%s\a' frisk-IDE
base_path="$(dirname "$(realpath "$0")")"
"$base_path/frisk-IDE.x86_64" "$@"

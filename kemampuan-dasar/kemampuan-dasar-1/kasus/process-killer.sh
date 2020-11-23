#!/bin/bash
echo "Nama program"
read program
pid=$(pgrep $program)
echo "No PID : $pid"
kill $(pgrep $program)

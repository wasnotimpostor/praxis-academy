#!/bin/bash
Recipient="cobabuatkan@gmail.com"
Subject="Greeting"
Message="Hallooo"
`mail -s $Subject $Recipient <<< $Message`

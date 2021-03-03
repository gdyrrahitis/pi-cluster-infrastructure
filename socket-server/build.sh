#!/bin/sh

gcc server.c command.pb-c.c response.pb-c.c -lprotobuf-c -o server

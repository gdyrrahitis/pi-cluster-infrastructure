#!/bin/sh

chmod 777 build.sh

# stop service before deployment
echo "Stopping service..."
sudo systemctl stop socketserver.service

# building server
echo "Building server..."
sh ./build.sh

# copying server to another location
echo "Copying server to /usr/local/bin..."
cp ./server /usr/local/bin
chmod 755 /usr/local/bin/server

# create service file
if [ ! -f /etc/systemd/system/socketserver.service ]
then
    echo "Service file doesn't exist, copying it..."
    cp ./socketserver.service /etc/systemd/system/socketserver.service
fi

status=$(systemctl is-enabled socketserver.service)
if [ "$status" = "enabled" ]; then
    echo "Service is already enabled"
else
    echo "Service is disabled, enabling service..."
    # Now need to enable the service: socketserver.service
    sudo systemctl enable socketserver.service
fi;

isactive=$(systemctl is-active socketserver.service)
if [ "$isactive" = "active" ]; then
    echo "Service is already started"
else
    echo "Service is stopped, starting service..."
    # Now need to start the service
    # socketserver.service
    sudo systemctl start socketserver.service
fi;

# to stop
# sudo systemctl stop socketserver.service

# find if socket tcp port is open with:
# ss -lntu

# Check service status
# systemctl status socketserver.service

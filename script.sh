#!/bin/bash

# Check if a command parameter was provided
if [ -z "$1" ]; then
  echo "No command provided. Use './script.sh start' or './script.sh cleanup'."
  exit 1
fi

# Define what to do based on the parameter
case "$1" in
  start)
    echo "Starting the application..."
    mvn clean install
    docker-compose up -d
    echo "Application started."
    ;;

  cleanup)
    echo "Cleaning up..."
    docker-compose down
    docker volume rm status-monitor_status-monitor-data
    echo "Cleanup completed."
    ;;

  *)
    echo "Invalid command. Use './script.sh start' or './script.sh cleanup'."
    exit 1
    ;;
esac
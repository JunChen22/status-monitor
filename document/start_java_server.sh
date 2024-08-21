#!/bin/bash

# Number of servers to start (default is 1)
NUM_SERVERS=${1:-1}
BASE_PORT=8081

# Define the Java file and JAR file names
JAVA_FILE="SimulatedServer.java"
CLASS_NAME="SimulatedServer"
JAR_FILE="SimulatedServer.jar"

# Compile the Java file
echo "Compiling Java file..."
javac $JAVA_FILE

# Check if the compilation was successful
if [ $? -ne 0 ]; then
    echo "Compilation failed. Exiting..."
    exit 1
fi

# Create a manifest file for the JAR
echo "Creating JAR file..."
echo "Main-Class: $CLASS_NAME" > manifest.txt

# Include all compiled class files in the JAR
jar cfm $JAR_FILE manifest.txt *.class

# Remove the manifest file
rm manifest.txt

# Check if the JAR file was created
if [ ! -f $JAR_FILE ]; then
    echo "JAR file creation failed. Exiting..."
    exit 1
fi

# Start multiple servers
for ((i=0; i<NUM_SERVERS; i++))
do
    PORT=$((BASE_PORT + i))
    echo "Starting server on port $PORT..."
    java -jar $JAR_FILE $PORT &
    # Save the PID of the server process
    SERVER_PIDS[$i]=$!
done

# Cleanup function to stop the servers and remove generated files
cleanup() {
    echo "Stopping servers..."
    for PID in "${SERVER_PIDS[@]}"
    do
        kill $PID
    done
    wait
    echo "Servers stopped."

    # Cleanup generated files
    echo "Cleaning up generated files..."
    rm *.class $JAR_FILE
    echo "Cleanup complete."
}

# Trap signals and clean up before exiting
trap cleanup EXIT
trap cleanup INT

# Wait for all server processes to complete
wait
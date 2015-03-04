#!/bin/bash


# Set the environment variables and execute the script each time you want to run the tests
# Requires the ant tool
TEST_CLASS=com.example.equation2ndgrade.MainActivityTest
TEST_JAR=EquationSolvingAppUITest.jar
TEST_JAR_PATH=./bin

ant clean
ant build

ADB_BIN=$ANDROID_HOME/platform-tools/adb

$ADB_BIN push $TEST_JAR_PATH/$TEST_JAR /data/local/tmp/

$ADB_BIN shell uiautomator runtest $TEST_JAR -c $TEST_CLASS

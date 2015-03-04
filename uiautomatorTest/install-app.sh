#!/bin/bash
# Compiles and installs the application under test

cd ../app
ant clean debug install
cd ../uiautomatorTest


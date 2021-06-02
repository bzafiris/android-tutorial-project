# android-tutorial-project
A simple android tutorial project with test projects for teaching purposes.
The project includes a small android application (quadratic equation solver) that is tested
with the help of various test frameworks and specifically (a) Android test framework,
(b) Espresso, (c) UIAutomator and (d) Robolectric.

Execute the android integration tests in a connected device or emulator with the command:
```
gradlew connectedCheck
```
Robolectric tests are executed as ordinary JUnit tests in a standard JVM with the command:
```
gradlew test
```


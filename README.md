# JUnit 5 Cookbook Code Samples

[![maven](https://github.com/VividcodeIO/junit5-starter/actions/workflows/maven.yaml/badge.svg)](https://github.com/VividcodeIO/junit5-starter/actions/workflows/maven.yaml)

Source code of my book [JUnit 5 Cookbook](https://leanpub.com/junit5).

The source code is built using Java 8.

Tests annotated with `@Fail` will fail the tests. If you want to have a clean
build, you can ignore the `fail` tag.

Tests annotated with `@Slow` are enabled using the system property `slow`. This
property is added by default in `build.gradle` and `pom.xml`.
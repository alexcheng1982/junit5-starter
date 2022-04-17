# JUnit 5 code samples

Source code of my book [JUnit 5 Cookbook](https://leanpub.com/junit5).

Tests annotated with `@Fail` will fail the tests. If you want to have a clean
build, you can ignore the `fail` tag.

Tests annotated with `@Slow` are enabled using the system property `slow`. This
property is added by default in `build.gradle`.
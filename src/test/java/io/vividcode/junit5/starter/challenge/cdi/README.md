# CDI Extension

This [CDI](https://jakarta.ee/specifications/cdi) (Contexts and Dependency
Injection) extension supports dependency injection.

[Weld](https://weld.cdi-spec.org/) is used as the CDI implementation.

In the extension, a Weld container is created and stored in the store.

The extension class implements `TestInstancePostProcessor`. When processing the
test
instance, fields annotated with `@Inject` will have their values set with
objects retrieved from the CDI container.

After all tests are executed, the CDI container is shut down.
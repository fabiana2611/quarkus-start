# getting-started project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

The code used in this project is adatapted from the [Quarkus cookBook](https://quarkus.io/books).

Some notes about the book and references to this project you can see in these two posts:

- [Quarkus Part 1](https://fabiana2611.github.io/java/books/quarkus)
- [Quarkus Part 2](https://fabiana2611.github.io/java/books/quarkus-p2)

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `getting-started-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/getting-started-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/getting-started-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

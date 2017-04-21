# GuavaJmx

Get insight in Guava via JMX.

## Building

Currently GuavaJmx is not deployed to Maven Central. So you have to clone and build it yourself.

```bash
$ git clone https://github.com/elexx/guavajmx.git
$ cd guavajmx
guavajmx$ ./gradlew install
```

## Dependency

GuavaJmx dependents on the oldest Guava version it at least needs to run. So if you need a newer Guava Version just add an explicit dependency to Guava!

Add a dependency to GuavaJMX using Maven:

```xml
<dependency>
    <groupId>com.github.elexx</groupId>
    <artifactId>guavajmx</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

Add a dependency to GuavaJMX using Gradle:

```
dependencies {
    compile 'com.github.elexx:guavajmx:0.0.1-SNAPSHOT'
}
```

## Usage

### Cache

When building the Cache, don't forget to call `.recordStats()` otherwise the JMX bean will not show any statistics.

```
Cache<String, String> myCache = newBuilder()
    .recordStats()
    .build();
```

Register the bean with JMX:
```
GuavaJmxManagementService.register(myCache, "Name to be shown in JMX client");
```

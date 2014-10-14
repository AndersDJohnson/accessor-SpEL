accessor
========

Access objects with the [Spring Expression Language][spel]. Convenient and safe access of deep fields in an object graph.

By default, uses null-safe navigation, but that and other features can be enabled or disabled.

## Usage

Download the JAR and add it to your app's runtime classpath. A zipped JAR is available on the latest release, e.g. [accessor-1.0.0-SNAPSHOT.jar.zip](https://github.com/adjohnson916/accessor/releases/download/1.0.0-SNAPSHOT/accessor-1.0.0-SNAPSHOT.jar.zip).

Simplest usage lets you do this:

```java
  Object value = Accessor.DEFAULT.get(myObject, "some.deep.property");
```

instead of 

```java
Object value = myObject.getSome() != null && myObject.getSome().getDeep() != null && myObject.getSome().getDeep().getProperty();
```

or

```java
Object value;
try {
  value = myObject.getSome().getDeep().getProperty();
}
catch(NullPointerException npe) {}
```


For more examples, see tests under "src/test/java".

## Alternatives

* [Apache Commons BeanUtils: PropertyUtils#getNestedProperty](https://commons.apache.org/proper/commons-beanutils/apidocs/org/apache/commons/beanutils/BeanUtils.html#getNestedProperty(java.lang.Object, java.lang.String))
* [Apache Commons 

[spel]: http://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/expressions.html

accessor
========

Access objects with the [Spring Expression Language][spel]. Convenient and safe access of deep fields in an object graph.

By default, uses null-safe navigation, but that and other features can be enabled or disabled.

## Usage

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



[spel]: http://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/expressions.html

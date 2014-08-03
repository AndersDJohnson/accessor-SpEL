accessor
========

Access objects with Spring Expression language.

Convenient access of deep fields in an object graph.
By default, uses null-safe navigation, but that and other features can be enabled or disabled.

## Usage

See examples in tests under "test/java".

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



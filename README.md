# Groovy Macro Musings

Groovy supports macros since 2.5... and no one seems to use them.  So
here are some attempts to add language features at macro level (with
varying usefulness).

## ES6 object property shorthand

```groovy
def labels=["a", "b"]
def values=[1, 2]
[labels, values]
    .transpose()
    .collect{ label, value -> 
        mapOf(label,value) 
    }
// → [[label:a, value:1], [label:b, value:2]]
```

## Clojure like threading macro

```groovy 
def add1 = { it+1 }
def mul = { a, b -> a*b }

threadFirst(
    42,
    add1,
    mul(5)
)
```

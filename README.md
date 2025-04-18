# Luma

**Luma** is intended to be a tiny experiment on **proving
termination for recursive functions**.  It’s intended to be 
integrated with the Neve compiler once proven to work.

## Using Luma

Luma takes in your input, which can be either:

1. a function declaration
2. a function call

And depending on the kind of input, it will either:

1. determine whether your function terminates
2. determine the number of recursive steps your call takes

For example, say we have this simple definition: 

```elixir
f(0) = 0
f(x) = x + f(x - 1)
```

Luma ~~will~~ **should** (because it’s not implemented yet) 
tell you something along the lines of:

```
Line 2: Function `f` does not always terminate.
    • it has the base cases `0`
    • but:
        • `x - 1` doesn’t always reach `0` when -inf < x <= 0
    • therefore:
        • `f` does not always terminate.
```

However, if we **restrict** x’s domain:

```elixir
f(0) = 0
f(x | x in nat) = x + f(x - 1)
```

We get:

```
Line 2: Function `f` always terminates.
    • it has the base cases `0`
    • but:
        • `x - 1` always reaches `0` when 0 < x < inf 
    • therefore:
        • `f` always terminates.
        • it has a maximum number of recursive steps of nearly `inf`
        • it has a minimum number of recursive steps of `0`
```

## Limitations

Luma can’t prove that every kind of recursive function 
terminates: it’s possible **in theory**, but Luma is 
intended to be integrated with the Neve compiler, and it
doesn’t sound very practical to have a full-blown equation 
solver in a compiler that’s already complex enough.

For example, Luma will simply reject the following 
definition:

```elixir
f(0) = 0
f(x) = x + f(x/2 + 1)
```

Because `x/2 + 1` is a complex growth pattern and would 
require equation-solving capabilities to be proven.
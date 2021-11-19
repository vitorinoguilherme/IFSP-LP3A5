-- recursividade normal
fibonacci 0 = 0 
fibonacci 1 = 1 
fibonacci num = fibonacci ( num - 1 ) + fibonacci ( num - 2 )

-- recursividade de cauda
fibonacciWithTailRecursion num = fib' 0 1 num
fib' a b 0 = a
fib' a b num = fib' (a+b) a (num-1)
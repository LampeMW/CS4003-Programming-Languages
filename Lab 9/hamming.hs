{-|
**  Lab 9 - Hamming's Sequence
**  Matt Lampe
**  M03516707
**  CS4003
**  4/6/2015
-}

merge :: [Int] -> [Int] -> [Int]
merge [] [] = []
merge xs [] = xs
merge [] xs = xs
merge (x:xs) (y:ys)
	| x <= y = x:merge xs (y:ys)
	| x > y = y:merge (x:xs) ys


times :: Int -> [Int] -> [Int]
times n [] = []
times n (x:xs) = n * x : times n xs


ham :: [Int] -> [Int]
ham primes = this_prime : (ham rest_of_primes)
	where
		this_prime = head primes
		rest_of_primes = merge (drop 1 primes) (times this_prime primes)

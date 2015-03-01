#|
## Lab 6 - The Power of Lambda
## Matt Lampe
## M03516707
## CS4003
## 2/28/2015
## Description:  Uses an infinite list and lazy procedures to find the first N prime numbers
## Usage - Run program and enter (stol N) to find the first N prime numbers
|#

(define int-builder$
  (lambda (n)
    (cons n (lambda () (int-builder$ (+ n 1))))))

(define take$
  (lambda (m s)
    (if (or (= m 0) (null? s))
        '()
        (cons (car s) (take$ (- m 1) ((cdr s)))))))

(define filter-out-mults$
  (lambda (num s)
    (if (null? s)
        '()
        (if (= (modulo (car s) num) 0)
            (filter-out-mults$ num ((cdr s)))
            (cons (car s) (lambda () (filter-out-mults$ num ((cdr s)))))))))

(define sieve$
  (lambda (s)
    (cons (car s)
          (lambda () (sieve$ (filter-out-mults$ (car s) ((cdr s))))))))

(define stol$
  (lambda (n)
    (take$ n (sieve$ (int-builder$ 2)))))
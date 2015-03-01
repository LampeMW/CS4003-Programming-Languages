(define int-builder$
  (lambda (n)
    (cons n (lambda () (int-builder$ (+ n 1))))))

(define filter-out-mults$
  (lambda (num s)
    (if (null? s)
        '()
        (if (= (modulo (car s) num) 0)
            (filter-out-mults$ num ((cdr s)))
            (cons (car s) (lambda () (filter-out-mults$ num ((cdr s)))))))))

(define take$
  (lambda (m s)
    (if (or (= m 0) (null? s))
        '()
        (cons (car s) (take$ (- m 1) ((cdr s)))))))

(define sieve$
  (lambda (s)
    (list (car s)
          (lambda () (sieve$ (filter-out-mults$ (car s) ((cadr s))))))))
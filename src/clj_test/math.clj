(ns clj-test.math
    (:gen-class)
)

(defn add [& args] (apply + args))
(defn subtract [& args] (apply - args))

(defn factorial [number]
    (cond ; condition on the number passed in
        (= number 0) 1
        (= number 1) 1
        (> number 1) (* number (factorial(- number 1))) ; if number > 1, multiply number with the return value of factorial(number-1)
    )
)
(defn transpose [matrix]
    (let [v1 (nth matrix 0) v2 (nth matrix 1) v3 (nth matrix 2)]
        (map vector v1 v2 v3)
    )
)

(defn transpose [m]

)
(defn divide [& args]  (apply / args))
(defn mult [& args] (apply * args))
(defn iseven [n](if (= (mod n 2) 0) true false))
(defn pow [base exp]
    (cond 
        (= exp 0) 1
        (= exp 1) base
        (> exp 1) (* base (pow base (- exp 1)))
    )
)

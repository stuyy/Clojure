(ns clj-test.math
    (:gen-class)
)

(defn add [& args]
    (apply + args)
)

(defn subtract [& args] (apply - args))

(defn factorial [number]
    (cond
        (= number 0) 1
        (= number 1) 1
        (> number 1) (* number (factorial(- number 1)))
    )
)
(ns clj-test.range (:gen-class))

(defn someNumber [n] (rand-int n)) ; Function defined to return a random number from 0 to n-1

(defn -main "Main" [& args]
    ; This clj file contains code going over lazy evaluation.

    (def numbers (take 10 (range))) ; Lazy evaluate and return the first 10 numbers from the infinite list range.
    (println numbers)
    (println (someNumber 4567))
)
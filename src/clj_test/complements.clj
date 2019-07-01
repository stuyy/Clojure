(ns clj-test.complements (:gen-class))

(defn isEmpty "Takes a vector and checks if it's empty using seq and nil? function" 
    [v] (nil? (seq v)))
(defn notEmpty "Takes in a vector, returns the complement of isEmpty." 
    [v] ((complement isEmpty) v))

(defn contains-number? [c]
    (loop [in c] 
        (cond
            (empty? in) false
            (instance? Long (first in)) true
            :else (recur (rest in))
        )
    )
)

(defn -main [& args]
    (println ((complement empty?) [])) ; returns false. 
    (def v1 ["Anson" "Jack" "MyName" "2" "3" 2.0 3.0 "4" 19])
    (println (contains-number? v1))
    (println ((complement contains-number?) v1)) ; Returns the complement of contains-number.
    ; Use filter and complement to get all of the non-empty vectors.

    (def vectors [[1 2 3] [2 4 5] [9 0 4] [] [] [] [3 8 2] [12 93 42] [2 3]])
    (def nonEmptyVectors (filter (complement empty?) vectors))
    (println nonEmptyVectors)
    (def emptyVectors (filter empty? vectors))
    (println (str "There are " (count emptyVectors) " empty vectors!"))

    
)
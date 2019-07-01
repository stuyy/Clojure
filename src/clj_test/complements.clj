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

(defn gt-fifty? [n] (> n 50))

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

    ; Filter takes in a predicate, and a collection. Filter goes through each element in the collection
    ; and passes it to the predicate function.
    ; It returns the values that passed the predicate.

    (def numbers (take 25 (repeatedly #(rand-int 100)))) ; Note: rand-int is a function that produces side effects.
    (def nums2 (take 500 (repeatedly #(rand-int 250))))

    ; for returns a lazy sequence.

    (println 
        (for [ ppl ["anson" "thomas" "samatha"] ages [19 21 23]
            :let [ ppl-desc (str ppl " is " ages " years old.") ]]
            ppl-desc
        )
    )
    ; passing multiple collections in 'for' will iterate over them in a nested fashion.
    ; i.e [1 2 3] and [3 4 5] would yield a result with 1 and 3, 1 and 4, 1 and 5, 2 and 3, 2 and 4, etc..

    (println
        (for [ppl {:p1 "Anson" :p2 "Sarah"} 
            :let [person ppl] ; Binding the ppl map to person. The  map entry becomes a vector i.e: [:p1 Anson]
            :when(= (last person) "Anson")] ; use last since the vector only contains the key and value.
            person            
        )
    )

    ; Use flatten to return the contents of any nested collection to a single flattened sequence.
    (println (flatten [[2 3 4][5 4][[45 67][22 34]]]))
    (println (flatten (list (list [2 3] [4 5] [[3 4][5 6][2 3]])(list 17 28 19 31 22))))

    (println (vec '(1 2 3))) ; Converts a list to a vector.
    (println (into [] '(3 4 9 1))) ; Takes the list and conjs each element into a vector.
)
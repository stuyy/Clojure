(ns clj-test.recur 
    (:gen-class)
    (:require [clojure.set :as set])
)

; Traverses a Collection recursively.
(defn traverse [someList]
    (let [flag (empty? someList)]
        (if flag nil (do (println (first someList)) (traverse (rest someList))))
    )
)
(defn iam [listOfAdjectives output]
    (if (empty? listOfAdjectives) output
        (iam (rest listOfAdjectives) (conj output (str "I am " (first listOfAdjectives))))
    )
)

; Print a List using Loop & Recur
(defn loopCollection [someCollection]
    (loop [col someCollection]
        (if (empty? col) nil
            (do (println (first col))
                (recur (rest col)))))) ; recur back to loop, passing the rest of the list.

; This expects a Map where it's keys map to a list
; Get the values of the keys, converts it from a list to a set. 
(defn getSetOfMap [input]
    (loop [collection input output []]
        (if (empty? collection) 
            output ; if empty, return output, the output vector.
            (recur (rest collection) (conj output (set (first (vals collection))))) ; else recur the rest of the collection and the output vector conjoined with the first element of the collection.
        )
    )
)

; This function will get the intersection of n sets. 
; listOfSets is a list of sets.
(defn getIntersection [listOfSets]
    (def counter 0)
    (loop [input listOfSets interSet #{}]
        (if (empty? input) 
            interSet
            (do
                (if (= counter 0) ; If counter is 0, the interSet is empty. We can't intersect a set with elements with the empty set, it'll yield the empty set.
                    (do
                        (def counter (inc counter)) ; Increment Counter by 1.
                        (recur 
                            (rest input) ; recur the rest of the set.
                            (set/union (first input) interSet) ; Take the union of the first set in the list with the empty set.
                        )
                    )
                    (recur (rest input)(set/intersection (first input) interSet))
                )
            )
        )
    )
)

(defn randList [amount max] (take amount (repeatedly #(rand-int max))))

(defn -main "Main" [& args]
    ;(traverse [1 2 3]) ; Traverse a Vector
    ;(traverse '(4 5 6)) ; Traverse a List
    ;traverse {:anson '(1 2 3) :josh '(4 5 6) :zach '(7 8 9)}) ; Traverse a Map
    ;(traverse #{:blue :yellow :green :red}) ; Traverse a Set.

    (def adjectives ["Tall" "Beautiful" "Buff" "Cool"])
    (def myOutput (iam adjectives []))
    ;(traverse myOutput)

    ; Generate a random list of 100 numbers.

    (def numbers (randList 100 2000))
    (traverse numbers) ; Print out the numbers recursively.
    (println (str "Total Numbers: " (count numbers)))

    ; Use recur to loop through.

    (def nums (randList 10 100))
    (println "Traversing through the list.")
    (loopCollection nums)
    ; So we know how to traverse through lists! :)
    (def myMap {:anson (randList 5 10) :lisa (randList 5 10) :taylor (randList 5 10)})
    (loopCollection myMap)

    (def mySet (getSetOfMap myMap))
    (println mySet)
    (def listSet (apply list mySet))
    (def intersectionSet (getIntersection listSet))
    
    (println intersectionSet)
)
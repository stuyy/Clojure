(ns clj-test.maps (:gen-class))

(defn addFive [n] (+ n 5))
(defn gen [] (take 5 (repeatedly #(rand-int 100))))
(defn toMap "Takes in a vector of lists by id and names, and converts it to a Map." [someList]
    (println (str "List to eval: " someList))
    (loop [in someList out {}]
        (if (empty? in) out (recur (rest in) (assoc out (first (first in))(last (first in)))))
    )
)

(defn -main [& args]
    (def numbers (gen))
    (def newList (map addFive numbers)) ; map returns a lazy sequence.
    (println (str "Original List: " (vec numbers)))
    (println (str "New List after Mapping: " (vec newList)))
    
    (reduce + [1 2 3 8 30 22 12])
    (def total 0)
    (def total (reduce + total [7 8 2 1 4 3]))
    (println (str "Total: " total))

    ; We can use Reduce to convert between different collections.

    ; Converting a Set to a List.
    (def myList '())
    (def myList (reduce conj myList #{"Anson" "Jack" "Larry" "Sophia" "Cindy"}))
    (println myList)

    (def myMap {:person1 "Anson" :person2 "Riley" :person3 "Moe" :person4 "Christina"})
    (def mapToList '())
    (def mapToList (reduce conj mapToList (vals myMap)))
    (println mapToList)

    (def people ['(0 "Anson") '(1 "Jack") '(2 "Rachel") '(3 "Isabella")]) ; define a vector of lists of people and their ids
    (def peopleMap (toMap people))
    (println peopleMap)
    (println (keys peopleMap))
    (println (vals peopleMap))


    ; Using map to apply the function empty? on each collection.
    (def emptyValues (map empty? (list [2 4] [] {} [4 5] {:p1 "Jack"} [2 4] '())))
    (println emptyValues)

    ; Use map to apply the anonymous function that adds 5 to each element in the collection.
    (def newMap (map #(+ % 5) '(6 20 5 2 6 7 2 344)))
    (println newMap)

    (def people {:p1 '("Anson" 21 true) :p2 '("Jackie" 22 false) :p3 '("Sarah" 23 false)})
    (println (keys people))
    (println (vals people))
    

    (loop [key (keys people)]
        (if (empty? key) nil
            (do
                (if (last ((first key) people)) 
                    (println (str (first ((first key) people)) " is a boy"))
                    (println (str (first ((first key) people)) " is a girl"))
                )
                (recur (rest key))
            )
        )
    )

    ; Define a function that takes in a collection that defines a person, the last value is assumed to be a boolean value
    ; if true, return "is a boy", if false "is a girl"
    (defn iter-people "Takes in a list, corresponding to the value of a map" [value]
        (if (empty? value) nil
            (if (last value) (str (first value) " is a boy") (str (first value) " is a girl"))
        )
    )

    ; example 

    (println (iter-people '("Joe" 21 true)))
    (println (iter-people ["Rachel" 22 false]))
    (println (iter-people '("Anson" 21 true)))

    ; Let's say I want to apply our function to multiple tuples of people.

    (println (map iter-people '(("Carol" 23 false) ("Victoria" 19 false) ("Adam" 25 true) ("Jordan" 29 true))))
    
    ; Other examples of map.

    (println (map pos? '(1 -8 9 -45 -5 3 5 6 0 -2)))
    (defn square [n] (* n n))
    (println (map square [2 3 4 5 6 7 8 9]))
    
    ; 
    (println (map + [1 2 3] (take 10 (iterate inc 5)))) ; 6 8 10
    (println (map + [2 4 5] (iterate (partial + 10) 10))) ; 12 24 35
    
)
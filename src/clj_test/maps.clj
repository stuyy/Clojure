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

    (reduce conj {} people)
    (def des (fn [n] (assoc {} (first n)(last n))))  
)
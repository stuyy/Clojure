(ns clj-test.empty
    (:gen-class)
)

(defn -main "Main" [& args]
    (def v1 [])
    (def v2 ["Anson"])

    (println (empty? v1))
    (println (empty? v2))
    (println (nil? (seq v1)))
    (println (nil? (seq v2)))

    (def v3 [78 92 94 22 12 10 16 20])

    (println (every? even? v3))
    ; every? is used to test if something is true for every element in a Collection.
    ; every? takes in a predicate.

    (def iseven? (fn [n] (= (mod n 2) 0)))
    (println (every? (fn [num] (= (mod num 2) 0)) v3))
    (println (every? iseven? v3))

    ; we can also define an anonymous function with shorthand syntax.

    (def iseven? #(= (mod % 2) 0))
    (println (iseven? 4))
    (def numbers [23 54 42 34 94 24 23 11 40])
    (println (some #(> % 100) numbers))
    (println (some #(> % 100) (conj numbers 200)))

    (def greater (if (some #(> % 100) numbers) (str "There is a number greater than 100") (str "There is no number greater than 100")))
    (println greater)

    (def greater (if (some #(> % 100) (conj numbers 204)) (str "There is a number greater than 100") (str "There is no number greater than 100")))
    (println greater)

    (let [greater (some #(> % 100) numbers)] (if greater (println "Greater than 100") (println "Less than 100")))
    (let [greater (some #(> % 100) (conj numbers 101))] (if greater (println "Greater than 100")(println "Less than 100")))
    (if-let [flag (every? #(= (mod % 2) 0) v3)]
        (println "Every element in Vector v3 is even.") (println "There is some element in Vector v3 that is odd.")
    )

    ; Check if a String exists in a List.
    (def names '("Anson" "Daniel" "Henry" "Lucas" "George" "Chris" "Susan" "Christina" "Alexis"))
    (if (some #(= % "Daniel") names) 
        (println "Daniel exists!") (println "Daniel does not exist!"))
    
    ; Binding an expression to a symbol, and if true it will evaluate the first argument.
    ; This is useful when binding expressions that are ONLY used conditionally.
    (if-let [flag (some #(= % "Larry") names)]
        (println "Larry Exists!")
        (println "Larry does not exist!")
    )
    (when (some #(= % "Anson") names) (println "Anson exists!"))
    (when (every? odd? v3) (println "Every number is odd!"))
    
    (def odds (when (every? even? v3) (map inc v3))) ; If every element in v3 is even, then return a new list with all numbers incremented by 1.
    (when (not (nil? odds)) (println odds)) ; When odds is not nil, print odds.
    
)
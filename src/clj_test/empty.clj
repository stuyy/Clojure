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

    (let [greater (some #(> % 100) numbers)]
        (if greater
            (println "Greater than 100")
            (println "Less than 100")
        )
    )

    (let [greater (some #(> % 100) (conj numbers 101))]
        (if greater
            (println "Greater than 100")
            (println "Less than 100")
        )
    )

    (if-let [flag (every? #(= (mod % 2) 0) v3)]
        (println "Every element in Vector v3 is even.") (println "There is some element in Vector v3 that is odd.")
    )
)
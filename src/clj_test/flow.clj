(ns clj-test.flow
    (:gen-class)
)
(defn -main "Main" [& args]
    (println "Main")
    (def v1 [])
    (empty? v1)
    ; or
    (nil? (first v1)) ; if true, then v1 is an empty vector.
    (= (count v1) 0) ; if count = 0, then v1 is an empty vector.

    ; Using if-do

    ; Generate a Random Number.
    
    (def random (fn [n] (rand-int n)))
    (let [someNum (random 100)] ; generate a random number up to 100.
        (let [flag (> someNum 50)] ; Bind the express to flag.
            (if flag 
                (do 
                    (println (str someNum " is greater than 50"))
                    (println "Try again.")
                )
                (do 
                    (println (str someNum " is not greater than 50"))
                    (println "Try again.")
                )
            )
        )
    )
)
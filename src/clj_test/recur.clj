(ns clj-test.recur (:gen-class))

; Traverses a Collection recursively.
(defn traverse [someList]
    (let [flag (empty? someList)]
        (if flag nil
            (do
                (println (first someList))
                (traverse (rest someList))
            )
        )
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
            (do
                (println (first col))
                (recur (rest col))
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
)
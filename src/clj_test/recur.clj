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

(defn -main "Main" [& args]
    (traverse [1 2 3]) ; Traverse a Vector
    (traverse '(4 5 6)) ; Traverse a List
    (traverse {:anson '(1 2 3) :josh '(4 5 6) :zach '(7 8 9)}) ; Traverse a Map
    (traverse #{:blue :yellow :green :red}) ; Traverse a Set.

    (def adjectives ["Tall" "Beautiful" "Buff" "Cool"])
    (def myOutput (iam adjectives []))
    (traverse myOutput)
)
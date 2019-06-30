(ns clj-test.partials (:gen-class))

(defn -main "Main Function" [& args]
    ; create some partial functions
    (def addThree (fn [a b c] (+ a b c))) ; anonymous function called addThree.
    (def one (partial addThree 1))
    (def two (partial one 2))
    (def three (partial two 3))
    (println (three))

    ; Comp Functions
    (def square #(* % %)) ; Anonymous function used to square a number.
    (def getNum #(+ 0 %)) ; Anonymous function used to get a number.

    (def result ((comp square square square) 2))
    (println result)
)   
(ns clj-test.partials (:gen-class))

(defn -main "Main Function" [& args]
    ; create some partial functions
    (def addThree (fn [a b c] (+ a b c))) ; anonymous function called addThree.
    (def one (partial addThree 1))
    (def two (partial one 2))
    (def three (partial two 3))
    (println (three))
    (println (three 4))
)
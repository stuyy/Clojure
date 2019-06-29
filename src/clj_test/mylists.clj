(ns clj-test.mylists
    (:gen-class)
)

(defn -main "Lists" [& args]
    ; Lists
    (def names '("Anson" "Jack"))
    (println (cons "Jake" names))
    (def otherNames (list "Evan" "Seth" "Josh"))
    (println  otherNames)
    ; Vectors
    ; Vectors can be accessed by indices, lists cannot.
    ; Both vectors and lists are considered collections in Clojure
    (def nameVector ["Joshua" "Seth" "Michael" "Logan" "Will"])
    (println nameVector)
    (println (str "Last name in Vector: " (last nameVector)))
)
; lein run -m clj-test.mylists
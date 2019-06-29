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
    ; All collections are immutable (they never change) and persistent.
    ; Note: cons function does NOT mutate the collection.
    (def nameVector ["Joshua" "Seth" "Michael" "Logan" "Will"])
    (println nameVector)
    (println (str "Last name in Vector: " (last nameVector)))
    ; Get the Count of the nameVector Collection
    (def sizeOfNames (count nameVector))
    (println (str "Total Names in Vector nameVector: " sizeOfNames))
)
; lein run -m clj-test.mylists
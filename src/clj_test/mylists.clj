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
    ; The conj function adds elements to a data structure in the most natural way.
    ; For Vectors, it'll add them at the end.
    ; For Lists, conj will add items to the front of the list.
    (conj nameVector "Matthew")
    (println nameVector)

    ; Maps
    (def names {:anson 21 :lisa 22 :susan 23})
    (println names)
    (println (get names :anson))
    (def lisaAge (get names :lisa))
    (println (str "Lisa's Age: " lisaAge))
    ; We can also retrieve values from Maps like this:
    (println (:anson names)) ; Use the key itself as a function instead of using the 'get' function.
    (println (:lisa names))
    (println (:susan names))
)
; lein run -m clj-test.mylists
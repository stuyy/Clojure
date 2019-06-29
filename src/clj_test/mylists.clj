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
    ; Use keys and vals function to retrieve keys and values of a Map, respectively.
    (def keysOfMap (keys names))
    (println keysOfMap)
    (def valsOfMap (vals names))
    (println (str "Values of Name Map: " valsOfMap))
    ; Remember that Collections are immutable, and whenever we want to update, add, remove, etc. a value, we are essentially returning a new Collection/Data Structure with the updated value in it.

    ; Create a Map where each key maps to a list. The list will correspond to the person's grades.
    (def grades {:anson (list 90 96 93) :mitch (list 83 99 100) :kyle (list 77 28 90)})
    (println grades)
    (println (first grades))
)
; lein run -m clj-test.mylists
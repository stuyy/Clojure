(ns clj-test.reduce (:gen-class))
(defn toMap "Takes a vector of lists and converts them to a map." [v]
    (reduce #(assoc %1 (first %2)(rest %2)) {} v)
)
(defn -main [& args]
    (comment
        "f should be a function of 2 arguments. If val is not supplied,
        returns the result of applying f to the first 2 items in coll, then
        applying f to that result and the 3rd item, etc. If coll contains no
        items, f must accept no arguments as well, and reduce returns the
        result of calling f with no arguments.  If coll has only 1 item, it
        is returned and f is not called.  If val is supplied, returns the
        result of applying f to val and the first item in coll, then
        applying f to that result and the 2nd item, etc. If coll contains no
        items, returns val and f is not called."
    )
    (reduce conj #{} [:a :b :c]) ; Appends all elemens from the vector to a set.
    
    ; A vector of lists of ids and names to a Map using Reduce.

    (reduce #(assoc %1 (first %2)(last %2)) {} ['(0 "Anson") '(1 "Sophia") '(2 "Cindy") '(3 "Madison")])
    (def myMap (toMap ['(0 "Anson" "Male") '(1 "Samantha" "Female")]))
    (println myMap)
    ; Define a vector of lists.
    (def vec1 [
        '(0 "Anson" "Male" "Empire Commons")
        '(1 "Sarah" "Female" "Liberty Terrace")
        '(2 "Hannah" "Female" "Empire Commons")
        '(3 "Stella" "Female" "Emprie Commons")
        '(4 "Samantha" "Female" "State Quad")    
    ])
    
    (println (toMap vec1))

    ; Example from Book.
    ; r is the vector we're building up.
    ; x is the elements in the collection.
    (def filterNil (fn [r x] (if (nil? x) r (conj r x))))
    (println (reduce filterNil [] [:anson :sarah nil nil :richard :isabella :sophia :tommy nil :tanya :michelle :holly nil nil nil]))
    
    ; You cannot reduce an infinite sequence, unlike `map`.
)
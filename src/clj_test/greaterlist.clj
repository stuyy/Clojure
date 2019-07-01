(ns clj-test.greaterlist (:gen-class))

(defn genNum [] (take 50 (repeatedly #(rand-int 500))))

(defn -main [& args]
    
    (def sublists (partition 5 (genNum)))
    ; Generate a random list of 50 integers.
    ; Partition them into lists of 5 (so 10 lists)
    ; Check which list has the greater sum.
    (println sublists)
    (def sum 0)
    (def greaterList '())
    (loop [subl sublists] ; Bind sublists to 'subl'
        (if (empty? subl) nil ; if list is empty, return nil.
            (do 
                (println (str "Sum for " (vec (first subl)) " is " (apply + (first subl))))
                (if (> (apply + (first subl)) sum) ; check if the sum of the current sublist is greater than sum.
                    (do
                        (def sum (apply + (first subl))) ; if greater than sum, set sum to the sum of the current sublist.
                        (def greaterList (first subl)) ; keep track of the list that's greater.

                    ) 
                    sum ; return sum 
                )
                (recur (rest subl))
            )
        )
    )
    (println (str "The greater list with sum " sum " is " (vec greaterList)))
)
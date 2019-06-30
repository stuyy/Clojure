(ns clj-test.range (:gen-class))
(def MAX_NUM_DICE 6)


(defn someNumber [n] (rand-int n)) ; Function defined to return a random number from 0 to n-1
(defn roll [] (+ 1 (rand-int MAX_NUM_DICE))) ; Roll the dice by generating a random number between 0 to 6, and add 1.
(defn generateRandomList [amount maxNum] (repeatedly amount #(rand-int maxNum)))

(defn -main "Main" [& args]
    ; This clj file contains code going over lazy evaluation.

    (def numbers (take 10 (range))) ; Lazy evaluate and return the first 10 numbers from the infinite list range.
    (println numbers)
    (println (someNumber 4567))

    ; Generates a random number up to n and prints it out.
    ; Check if the random number is greater than 50.
    (defn genNumber [n]
        (let [someNum (rand-int n)]
            (println (str "The random number is " someNum))
            (if (> someNum 50) 
                (println (str someNum " is greater than 50"))
                (println (str someNum " is less than 50"))
            )
        )
    )
    (genNumber 100)
    (println (str "You rolled a " (roll)))
    (def list1 (generateRandomList 10 100)) ; Generate a random list and assign to the var list1.
    (println list1) ; Print out the list.
    (println (every? even? list1)) ; Check if every element in the list is even.
    (println (every? odd? list1)) ; Check if every element in the list is odd.
    
    ; The probability of all elements in list1 being even or odd is .01%.
    
)
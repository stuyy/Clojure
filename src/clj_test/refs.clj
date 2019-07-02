(ns clj-test.refs (:gen-class))

; To change a value of a ref, it must be wrapped inside a (dosync) function.
(defn ageUp? "If number is 1, alter ageRef by incrementing it's value." [ageRef]
    (when (= (rand-int 2) 1)
        (dosync (alter ageRef inc)) ; Must run inside a transaction.
        (println (str "Aged up!"))
    )
)

(defn -main "Main" [& args]
    ; Clojure has something called refs that allow you to coordinate shared state. 
    ; Software Transactional Memory
    ; Refs use STM (Software Transactional Memory) to coordinate changes of state.
    ; All actions on refs within the transaction are Atomic, Consistent, and Isolated.
    
    (def myAge (ref 21))
    (println (str "My age: " @myAge))
    ; Alter myAge 
    
    (let [n 2]
        (future (dotimes [_ n] (ageUp? myAge))) ; thread 1
        (future (dotimes [_ n] (ageUp? myAge))) ; thread 2
    )

    (future (println (str "Age is now " @myAge)))

)
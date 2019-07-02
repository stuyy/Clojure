(ns clj-test.refs (:gen-class))

(defn -main "Main" [& args]
    ; Clojure has something called refs that allow you to coordinate shared state. 
    ; Software Transactional Memory
    ; Refs use STM (Software Transactional Memory) to coordinate changes of state.
    ; All actions on refs within the transaction are Atomic, Consistent, and Isolated.
    
)
(ns clj-test.flow
    (:gen-class)
)
(defn -main "Main" [& args]
    (println "Main")
    (def v1 [])
    (empty? v1)
    ; or
    (nil? (first v1)) ; if true, then v1 is an empty vector.
    (= (count v1) 0) ; if count = 0, then v1 is an empty vector.
)
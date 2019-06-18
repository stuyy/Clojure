(ns clj-test.test
    (:gen-class)
)

(defrecord Person [firstname lastname age gender])


(defn -main "Main" [& args]
    (println "Test")
    (def anson (Person. "Anson" "Foong" 21 true))
    (println anson)
)
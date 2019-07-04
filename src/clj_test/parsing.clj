(ns clj-test.parsing
  (:require [cheshire.core :refer :all]))

(defn read-json [json-map]
  (loop [n json-map]
    (if (empty? n) nil
      (do (println (first n)) (recur (rest n))))))

(defn -main [& args]
  (def mydata (generate-string {:foo "bar" :baz 5}))
  (println mydata)
  (println (type mydata))

  (def res (slurp "https://my-json-server.typicode.com/typicode/demo/db")) ; slurp api endpoint
  (spit "data.json" res) ; save to data.json file
  (def data (parse-string (slurp "data.json"))) ; parses to map
  (read-json data)
)
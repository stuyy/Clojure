(ns clj-test.ops (:gen-class))

(defn iter [coll]
    (loop [m coll]
    (if (empty? m) nil
        (do (println (first m)) (recur (rest m)))
    ))
)
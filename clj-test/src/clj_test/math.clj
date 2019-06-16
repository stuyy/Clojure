(ns clj-test.math
    (:gen-class)
)

(defn add [& args]
    (apply + args)
)

(defn subtract [& args] (apply - args))
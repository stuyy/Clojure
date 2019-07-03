(ns clj-test.protocols (:gen-class))

(defmulti add (fn [coll]
  (cond
    (list? coll) :list
    (vector? coll) :vector
    (map? coll) :map
    :else :default)))

(defmethod add :list [input] (println "List!"))
(defmethod add :vector [input] (println "Vector!"))
(defmethod add :map [input] (println "Map!"))
(defmethod add :default [input] (println "None"))

(defprotocol Operations ; Clojure's Protocol functions are not variadic.
  (operate [this coll])
  (log [this coll]))

(defn compute [this coll]
  (cond
    (= this :add) (apply + coll)
    (= this :sub) (apply - coll)
    (= this :div) (apply / coll)
    (= this :mul) (apply * coll)
    (= this :mod) (apply mod coll)))

(extend-protocol Operations
  clojure.lang.Keyword
  (operate [this coll] ; pass in as a collection.
    (when (coll? coll)
      (if (map? coll)
        (compute this (into [] (vals coll)))
        (compute this coll))))
  
  java.lang.String
  (log [this coll] (str coll))
)
  
; end of extend-protocol.

(defn -main [& args]
  (println (operate :add [2 3 4]))
  (println (operate :sub [22 333]))
  (println (operate :div [20 4 5]))
  (println (operate :mod '(2 3)))
  (println (operate :mul {:a 20 :b 22}))
  (println (log "some str" '(1 23)))
)
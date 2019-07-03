(ns clj-test.polymorphism (:gen-class)
  ; Reserved for imports.
  )

(defn who "If we wanted to have a function that would behave differently based on the kind of input
we had, we could use a case like statement. This example uses a function called cond that
behaves differently depending on the instance of the argument." [input]
  (cond
    (= java.lang.String (class input)) "You are a string."
    (= clojure.lang.Keyword (class input)) "You are a keyword."
    (= clojure.lang.PersistentArrayMap (class input)) "You are a map."
    (= clojure.lang.PersistentList$EmptyList (class input)) "You are a list."
    :else "Not found!"))


(defn -main [& args]
  (println (who '()))
  (println (who {}))
  (println (who #{}))
  (println (who []))
)
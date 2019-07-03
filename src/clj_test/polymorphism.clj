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


(defmulti is-even-num ; Take in a number and check if it is odd or even.
  (fn [n] (if (= (mod n 2) 0) "even" "odd")))

(defmethod is-even-num "even" [n] (str n " is even")) ; If dispatch function returns even, we print out the number and say it's even

(defmethod is-even-num "odd" [n] (str n " is odd")) ; If dispatch function returns odd, we print out the number and say it's odd

(defn -main [& args]
  (println (who '()))
  (println (who {}))
  (println (who #{}))
  (println (who []))
  (println (is-even-num 11))
  (println (is-even-num 3))
  (println (is-even-num 22))
)
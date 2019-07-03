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
  (fn [n] 
    (cond
      (not= java.lang.Long (class n)) (Exception. "Not a number.")
      (= (mod n 2) 0) "even"
      :else "odd")))

(defmethod is-even-num "even" [n] (str n " is even")) ; If dispatch function returns even, we print out the number and say it's even
(defmethod is-even-num "odd" [n] (str n " is odd")) ; If dispatch function returns odd, we print out the number and say it's odd
(defmethod is-even-num :default [n] "Something went wrong.")

; define a protocol 
(defprotocol BigMushroom (eat-mushroom[this]))
(extend-protocol BigMushroom
  java.lang.String
  (eat-mushroom[this]
    (str (.toUpperCase this) " tasty!"))
  
  clojure.lang.Keyword
  (eat-mushroom[this]
    (case this
      :grow "Eat the right side."
      :shrink "Eat the left side."))

  java.lang.Long
  (eat-mushroom [this]
    (if (< this 3)
      "Eat the right side to grow."
      "Eat the left side to shrink"))
)

(defn -main [& args]
  (println (who '()))
  (println (who {}))
  (println (who #{}))
  (println (who []))
  (println (is-even-num 11))
  (println (is-even-num 3))
  (println (is-even-num 22))
  (println (is-even-num "22"))
  
  (println (eat-mushroom "Big Mushroom"))
  (println (eat-mushroom 2))
  (println (eat-mushroom :grow))
)
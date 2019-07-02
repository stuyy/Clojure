(ns clj-test.core
  (:gen-class)
  (:require [clojure.string :as str])
  (:require [clj-test.math :refer :all]) ; import our own math library
  (:require [clj-test.ops :as ops])
)

(def MY_NAME "ANSON FOONG") ; declare global variable STRING

(defn greeting [name] (str "Hello " name)) ; returns a string
(def getAge (fn [age] (str "Age: " age))) ; returns age
(defn someFunction [p, s] (println "I am some function") (println p) (println s))

(defn callme [phone, state]
  (apply someFunction phone state)
)
; this function uses let to shadow the global var MY_NAME and sets it to "JACK RABBIT" in its lexical scope.
; At the end of this function you can see it prints the original global string
(defn tempFunc [] (
  let [MY_NAME "JACK RABBIT"]
    (println MY_NAME)
  )
  (println MY_NAME)
)

(defrecord Person [ firstname lastname age gender])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;(def div (divide 9 3 3))
  ;(def num (mult 3 3 3 3 3))
  ;(println num)
  ;(println div)
  ;(println (pow 3 5))
  ;(def matrix (list (list 1 2 3) (list 3 4 5) (list 4 5 6)))
  ;(println matrix)
  ;(println (transpose [[2 3 5][4 6 7][2 6 7]]))
  (def m [[1 2 3][4 5 6][22 54 24]])
  (ops/iter m)

  ; Use apply to join strings.

  (def myName ["An" "s" "on" " " "Fo" "o" "ng"])
  (println (apply str myName))
)

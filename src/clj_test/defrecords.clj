(ns clj-test.defrecords (:gen-class))

(defrecord Book [title author published])
(def harry-potter (Book. "Harry Potter and the Deathly Hallows" "J.K. Rowling" "2007"))
(def percy-jackson (Book. "Percy Jackson and the Olympians: The Lightning Thief" "Rick Riordan" "2005"))

(defn -main [& args]
  (println (class harry-potter))
  (println (class percy-jackson))
)
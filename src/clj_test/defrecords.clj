(ns clj-test.defrecords (:gen-class))

(defprotocol UpdatePage
  (flip-page-right [this amt])
)
(defrecord Book [title author published current pages]
  UpdatePage
  (flip-page-right [this amt]
    (println (.-pages this))
    (if (> (+ @(.-current this) amt) (.-pages this))
      (reset! (.-current this) (.-current pages))
      (reset! (.-current this) (+ @(.-current this) amt))
    )))
(def harry-potter (Book. "Harry Potter and the Deathly Hallows" "J.K. Rowling" "2007" (atom 1) 759))
(def percy-jackson (Book. "Percy Jackson and the Olympians: The Lightning Thief" "Rick Riordan" "2005" (atom 1) 377))

(defn -main [& args]
  (println (class harry-potter))
  (println (class percy-jackson))
  
  (flip-page-right harry-potter 20)
  (println (format "Current Page for %s is %d" (.-title harry-potter) @(.-current harry-potter)))
)
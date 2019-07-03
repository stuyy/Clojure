(ns clj-test.defrecords (:gen-class))

(defprotocol UpdatePage
  (flip-right-amt [this amt])
  (flip-left-amt [this amt])
)
(defrecord Book [title author published current pages]
  UpdatePage
  (flip-right-amt [this amt]
    (if (> (+ @(.-current this) amt) (.-pages this))
      (reset! (.-current this) (.-current pages))
      (reset! (.-current this) (+ @(.-current this) amt))))

  (flip-left-amt [this amt]
    (if (>= (- @(.-current this) amt) 1)
      (reset! (.-current this) (- @(.-current this) amt))
      (reset! (.-current this) 1)))
)
(def harry-potter (Book. "Harry Potter and the Deathly Hallows" "J.K. Rowling" "2007" (atom 1) 759))
(def percy-jackson (Book. "Percy Jackson and the Olympians: The Lightning Thief" "Rick Riordan" "2005" (atom 1) 377))

(defn -main [& args]
  (println (class harry-potter))
  (println (class percy-jackson))
  
  (flip-right-amt harry-potter 20)
  (println (format "Current Page for %s is %d" (.-title harry-potter) @(.-current harry-potter)))
  (flip-left-amt harry-potter 15)
  (println (str "Current Page " @(.-current harry-potter)))
  (flip-left-amt harry-potter 22)
  (println (str "Current Page " @(:current harry-potter)))
)
(ns clj-test.defrecords (:gen-class))

(defprotocol UpdatePage
  (flip-right-amt [this amt])
  (flip-left-amt [this amt])
  (flip-left [this])
  (flip-right [this])
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
  
  (flip-left [this]
    (when (> @(.-current this) 1) (swap! (.-current this) dec)))
  
  (flip-right [this]
    (when (< @(.-current this) (.-pages this)) (swap! (.-current this) inc)))
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

  (dotimes [n 4] (flip-right harry-potter))
  (flip-left harry-potter)
  (flip-left harry-potter)
  (println @(:current harry-potter))
)
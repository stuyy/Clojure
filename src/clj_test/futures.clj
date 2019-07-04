(ns clj-test.futures)

(defn -main [& args]
  (let [hello (future (Thread/sleep 2000) "Hello World")]
    (println @hello)
    (println (realized? hello)))

  (println (deref (future (Thread/sleep 5000) "After 5 seconds.") 1000 "After 1 seconds.")) ; deref future and return a string if it has not finished after 1000ms (1 seconds.)

  (def hello-world (future (Thread/sleep 1000) "Hi")) ; Sleeps for 1 seconds, returns "Hi"
  (println (realized? hello-world))
  
  (println (deref hello-world 5000 "Nope.")) ; If nothing was returned after 5 seconds, return "Nope."
  (shutdown-agents)
)
(ns clj-test.agents (:gen-class))

(def myAge (agent 1))
(defn ageUp []
  (send myAge inc))

(defn error-exception [state]
  (throw (Exception. "Failed!")))
(defn -main [& args]
  (println @myAge)
  (ageUp)
  (ageUp)
  (ageUp)
  ; Note: `send` happens asynchronously, so the value of agent myAge might not be correct.
  (def val (future (send myAge error-exception))) ; The send function dispatches the action to the agent, which is processed by a thread in the thread pool.
  (println @@val)
  (shutdown-agents)
)
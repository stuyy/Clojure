(ns clj-test.libtest 
  (:require [clojure.core.async :as async]))

(def tea-channel (async/chan 10))
(def google-channel (async/chan 10))
(def yahoo-channel (async/chan 10))

(defn -main [& args]
  (async/>!! tea-channel :tea) ; Putting data to our channel, synchronously.
  (async/>!! tea-channel :lipton-tea)
  (async/>!! tea-channel :nestea)
  (async/>!! tea-channel :blue-tea)

  (async/<!! tea-channel) ; removes :tea
  (async/close! tea-channel) ; Close the channel. It will stop new inputs being added, but you can still take data off of it.
  (async/>!! tea-channel :red-tea) ; Returns false because the channel is closed.

  (async/<!! tea-channel)

  (def other (async/chan 10))
  (async/go-loop []
    (when-let [msg (async/<! other)]
      (println (str msg)))
    (recur))

  (async/>!! other :tea)
  (async/>!! other :milk)
  (async/>!! other :juice)
  (for [n '(1 2 3)] (println n))
)
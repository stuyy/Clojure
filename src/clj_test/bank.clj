(ns clj-test.bank (:gen-class))

(defn withdraw "Runs a transaction subtracting the amount from the balanceRef is value of balanceRef exceeds amt" [amt balanceRef]
    (if (> amt @balanceRef) 
        "You cannot withdraw that amount right now." 
        (dosync (alter balanceRef - amt))
    )
)
(defn deposit "Runs a transaction adding the amount to the balanceRef" [amt balanceRef]
    (dosync (alter balanceRef + amt)) ; Update the value of balanceRef inside body of dosync.
)
(defn -main [& args]
    (def balance (ref 500)) ; Create a ref that represents the user's balance.
    (withdraw 200 balance)
    (println (str "Your balance is now " @balance))
    (deposit 1000 balance)
    (println (str "Your balance after depositing 1000 is " @balance))
    ; Run multiple threads and deposit and withdraw money.
    ;(future (dotimes [n 3] (withdraw 200 balance))) ; Should withdraw $200 3 times. Total output should be 700.
    ;(future (dotimes [n 3] (deposit 500 balance)))
    ;(future (println (str "Balance is now " @balance)))
    ;(shutdown-agents)

    (def thread1 (future (dotimes [n 3] (withdraw 200 balance)))) ; withraw 600 from 1300 = 700
    (def thread2 (future (dotimes [n 6] (withdraw 400 balance)) @balance))
    (println @thread2)
    (shutdown-agents)
)
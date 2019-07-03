(ns clj-test.bank (:gen-class))

(defn withdraw "Runs a transaction subtracting the amount from the balanceRef is value of balanceRef exceeds amt" [amt balanceRef]
    (if (> amt @balanceRef) 
        "You cannot withdraw that amount right now." 
        (dosync (alter balanceRef - amt)) ; alter balanceRef, pass function -, and the args amt. 
    )
)

(defn deposit "Runs a transaction adding the amount to the balanceRef" [amt balanceRef]
    (dosync (alter balanceRef + amt)) ; Update the value of balanceRef inside body of dosync.
)

(defn transferMoney "Gives p2 the amt from p1" [ref-p1 ref-p2 amt]
    (dosync 
        (when (> (:balance @ref-p1) amt)
            (alter ref-p1 assoc :balance (- (:balance @ref-p1) amt)) ; Subtracts the amount from the P1's balance.
            (alter ref-p2 assoc :balance (+ (:balance @ref-p2) amt)) ; Add the amount to P2's balance.
        )
    ) 
) 
(defn -main [& args]
    ;(def balance (ref 500)) ; Create a ref that represents the user's balance.
    ;(withdraw 200 balance)
    ;(println (str "Your balance is now " @balance))
    ;(deposit 1000 balance)
    ;(println (str "Your balance after depositing 1000 is " @balance))
    ; Run multiple threads and deposit and withdraw money.
    ;(future (dotimes [n 3] (withdraw 200 balance))) ; Should withdraw $200 3 times. Total output should be 700.
    ;(future (dotimes [n 3] (deposit 500 balance)))
    ;(future (println (str "Balance is now " @balance)))
    ;(shutdown-agents)

    ;(def thread1 (future (dotimes [n 3] (withdraw 200 balance)))) ; withraw 600 from 1300 = 700
    ;(def thread2 (future (dotimes [n 6] (withdraw 400 balance)) @balance))
    ;(println @thread2)
    (def anson (ref {:person "Anson" :balance 1000}))
    (def sarah (ref {:person "Sarah" :balance 1500}))

    (dotimes [n 3] (transferMoney anson sarah 100))
    
    (println @anson)
    (println @sarah)
    (shutdown-agents)
    
)
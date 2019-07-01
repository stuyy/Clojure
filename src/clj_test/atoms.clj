(ns clj-test.atoms (:gen-class))
(comment "There are a couple of ways that we can change the value of an atom. These changes are
    always made synchronously.")


(defn -main "Atoms are designed to store the state of something that is independent." [& args]

    (def dragon (atom :baby-dragon))
    (println @dragon)
    (reset! dragon :growing) ; Changing the state of our atom.

    ; Define a mutable list.
    (def myList (atom '(19 22 24 93 45 30 21)))
    ; To print our list, we need to dereference it using @
    (println @myList) ; outputs myList.
    ; if we want to change the state of our list independent of other states, we can do so using reset! or swap!
    (reset! myList (conj @myList 33))
    (println @myList)

    ; define an empty atomic list.
    (def numbers (atom ()))
    ;  We can use swap! function to swap the current value of our atomic list with the new value returned from the function.
    (swap! numbers conj 1) ; conj 1 returns (1), we are swapping the value of the atomic list players with (1)
    (swap! numbers conj 2)
    (swap! numbers conj 3)
    (println @numbers)

    (def vectorNumbers (atom []))
    (reset! vectorNumbers [1])
    (println @vectorNumbers)
    (reset! vectorNumbers [2 3 4])
    (swap! vectorNumbers conj 5)
    (println @vectorNumbers)
)
(ns clj-test.ch2
    (:gen-class)
)

(defn -main "Main!" [& args]
    ; def can be used to define global symbols, these symbols are known as 'vars' or var objects.
    (def myName "Anson Foong")
    (def myAge 21)
    (def myGender "Male")

    (println (format "Name: %s\nAge: %s\nGender: %s\n" myName myAge myGender))
    
    ; if we want to bind a symbol without changing it's value globally, use 'let'
    (let [myName "Jack" myAge 22 myGender "Male"]
        (println (format "Name: %s\nAge: %s\nGender: %s\n" myName myAge myGender))
    )
    (println (format "Name: %s\nAge: %s\nGender: %s\n" myName myAge myGender))
)
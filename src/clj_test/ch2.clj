(ns clj-test.ch2
    (:gen-class)
)

; getInfo takes in 3 parameters, and returns a formatted string.
(defn getInfo [name age gender] (str (format "Name: %s\nAge: %s\nGender: %s\n" name age gender)))
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
    ; call getInfo()
    (println (str "Get Info\n" (getInfo myName myAge myGender)))

    (def someFunc (fn [] (str "Hello World"))) ; define some anonymous function and set it equal to someFunc.
    (println (someFunc)) ; here we will print the value returned from someFunc.
)
(ns clj-test.strings (:gen-class)
  (:import java.util.UUID)
)

(def myBufferStr (new StringBuffer 20))
(def myName (new String "Anson Foong"))
(def firstChar (.charAt myName 0))
(def upper (.toUpperCase myName))
(def lower (.toLowerCase myName))

(defn -main [& args]
  (println myName)
  (println (str myName " is cool!"))
  (println firstChar)

  (if (.equalsIgnoreCase myName "ansOn fOonG") (println "Equal!") (println "Not Equal!"))
  (println (.hashCode myName))
  (.append myBufferStr "Linus Sebastian")
  (println (.toString myBufferStr))
  (println (UUID/randomUUID))
)
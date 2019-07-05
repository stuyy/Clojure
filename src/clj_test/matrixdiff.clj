(ns clj-test.matrixdiff)

(def matrix [[2 3 4][4 5 6][5 6 7]])

(defn not-square? [m]
  (if (some #(not= (count m)(count %)) m) true false))

(defn diff [matrix]
  (if (not-square? matrix) nil
  (do 
    (loop [m matrix sum1 0 sum2 0 i 0 j (- (count matrix) 1)]
      (if (empty? m) (Math/abs (- sum1 sum2))
        (recur (rest m) (+ sum1 (nth (first m) i)) (+ sum2 (nth (first m) j)) (+ i 1) (- j 1)))))))
(defn -main [& args]
  (println (diff matrix))
  (println (diff [[1 2 3][4 5 6][9 8 9]]))
  (println (diff [[11 2 4][4 5 6][10 8 -12]]))
)
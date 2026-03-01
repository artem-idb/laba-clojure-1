(ns laba_12.core
  (:gen-class)
  (:require [clojure.data.json :as json]
  [clojure.java.io :as io]))

(defn parseJson [filepath]
(with-open [reader (io/reader filepath)] (json/read reader
 :key-fn keyword)))

(defn printJson [data]
(doseq [i data] (println (format "%-20s age: %d grade: %d"
(:name i)(int (:age i))(int (:grade i))))))

(defn descFilter [data field]
(sort-by field #(compare %2 %1) data))

(defn -main [& args]
(let [data (parseJson "resources/data.json")
  sorted (descFilter data :grade)]
  (println "\nВывод")
  (printJson sorted)))
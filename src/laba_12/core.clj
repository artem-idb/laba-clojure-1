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

(defn ascFilter [data field]
(sort-by field #(compare %1 %2) data))

(defn -main [& args]
(let [data (parseJson "resources/data.json")]
  (println "Выберите сортировку:")
  (println "  1 — по убыванию  (grade)")
  (println "  0 — по возрастанию (grade)")
  (print "Ваш выбор: ")
  (flush)
(let [input (read-line) sorted (if (= input "1")  (descFilter data :grade) (ascFilter data :grade)) ]
  (println (if (= input "1") "\nСортировка по убыванию:" "\nСортировка по возрастанию:"))
  (printJson sorted))))
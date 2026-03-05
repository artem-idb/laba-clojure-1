(ns laba_12.core
  (:gen-class)
  (:require [clojure.data.json :as json]
  [clojure.java.io :as io]))

(defn processJson [filepath field desc?]
(with-open [reader (io/reader filepath)]
  (let [data (json/read reader :key-fn keyword)]
  (if desc?
    (sort-by field #(compare %2 %1) data)
    (sort-by field #(compare %1 %2) data)))))

(defn printJson [data]
(doseq [i data] (println (format "%-20s age: %d grade: %d"
(:name i)(int (:age i))(int (:grade i))))))

(defn readValidInput []
  (loop [] (print "Ваш выбор: ") (flush)
  (let [input (clojure.string/trim (read-line))]
  (if (contains? #{"0" "1"} input)
    input
  (do (println "Ошибка: введите 0 или 1") (recur))))))

(defn -main [& args]
  (println "Выберите сортировку:")
  (println "  1  по убыванию  (grade)")
  (println "  0  по возрастанию (grade)")
(let [input  (readValidInput) desc?  (= input "1") sorted (processJson "resources/data.json" :grade desc?)]
  (println (if desc? "\nСортировка по убыванию:" "\nСортировка по возрастанию:"))
  (printJson sorted)))
(ns laba_12.core
  (:gen-class)
  (:require [clojure.data.json :as json]
  [clojure.java.io :as io]))

(defn parseJson [filepath]
(with-open [reader (io/reader filepath)] (json/read reader
 :key-fn keyword)))

(defn printJson [data]
(doseq [i data] (println (format "%-20s age: %d salary: %d"
(:name i)(int (:age i))(int (:salary i))))))

(defn -main [& args]
  (let [data (parseJson "resources/data.json")]
    (println "\nВывод")
    (printJson data)))
(defproject laba_12 "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.12.2"][org.clojure/data.json "2.4.0"]]
  :main ^:skip-aot laba_12.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
(ns script
  (:require [clojure.tools.cli :as cli]
            [clojure.string :as str])
  (:gen-class))

(set! *warn-on-reflection* true)

(def cli-options
  "CLI option configuration; see https://github.com/clojure/tools.cli"
  [["-h" "--help" "Show this help message"]])

(defn usage [options-summary]
  (->> ["Usage: script [options]"
        ""
        "Options:"
        options-summary
        ""
        "Examples:"
        "  script --help    Show this help message"]
       (str/join \newline)))

(defn error-msg [errors]
  (str "The following errors occurred while parsing your command:\n\n"
       (str/join \newline errors)))

(defn exit [status msg]
  (when msg
    (if (zero? status)
      (println msg)
      (binding [*out* *err*]
        (println msg))))
  (System/exit status))

(defn -main [& args]
  (let [{:keys [options arguments errors summary]} (cli/parse-opts args cli-options)]
    (cond
      (:help options)
      (exit 0 (usage summary))
      
      errors
      (exit 1 (error-msg errors))
      
      :else
      (do
        (println "Hello from clj.native-cli!")
        (exit 0 nil)))))

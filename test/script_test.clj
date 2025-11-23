(ns script-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.string :as str]
            [script :as script]))

(deftest test-usage-function
  (testing "usage generates help text"
    (let [summary "  -h, --help  Show this help message"
          result (script/usage summary)]
      (is (str/includes? result "Usage: script [options]"))
      (is (str/includes? result "Options:"))
      (is (str/includes? result "Examples:"))
      (is (str/includes? result summary)))))

(deftest test-error-msg-function
  (testing "error-msg formats errors correctly"
    (let [errors ["Error 1" "Error 2"]
          result (script/error-msg errors)]
      (is (str/includes? result "The following errors occurred"))
      (is (str/includes? result "Error 1"))
      (is (str/includes? result "Error 2")))))

(deftest test-cli-options
  (testing "CLI options are defined correctly"
    (is (vector? script/cli-options))
    (is (seq script/cli-options))
    (let [help-option (first script/cli-options)]
      (is (= "-h" (first help-option)))
      (is (= "--help" (second help-option))))))


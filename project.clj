(defproject net.clojars.jwierzbi/rf-fx-password "0.1.2-SNAPSHOT"
  :description "re-frame coeffect for generating random passwords."
  :url "https://github.com/jwierzbi/rf-fx-password"
  :license {:name "BSD-2-Clause"
            :url "https://github.com/jwierzbi/rf-fx-password/blob/main/LICENSE"}

  :plugins [[lein-shadow "0.4.1"]
            [lein-shell "0.5.0"]]

  :dependencies [[org.clojure/clojure "1.11.1" :scope "provided"]
                 [org.clojure/clojurescript "1.11.54" :scope "provided"
                  :exclusions [com.google.javascript/closure-compiler-unshaded
                               org.clojure/google-closure-library
                               org.clojure/google-closure-library-third-party]]
                 [re-frame "1.3.0" :scope "provided"]]

  :profiles {:dev {:dependencies [[thheller/shadow-cljs "2.23.3"]]}}

  :deploy-repositories [["clojars" {:url "https://repo.clojars.org"
                                    :sign-release false
                                    :username :env/CLOJARS_USERNAME
                                    :password :env/CLOJARS_PASSWORD}]]

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version"
                   "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["deploy" "clojars"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]

  :shadow-cljs {:source-paths ["src" "test"]
                :dependencies []
                :builds {:ci {:target :karma
                              :output-to "target/ci.js"}}}

  :npm-dev-deps [[karma "6.4.2"]
                 [karma-cljs-test "0.1.0"]
                 [karma-chrome-launcher "3.2.0"]]

  :aliases {"ci" ["do"
                  ["clean"]
                  ["shadow" "compile" "ci"]
                  ;; might require setting CHROME_BIN, e.g.:
                  ;; $ export CHROME_BIN=/usr/bin/chromium
                  ["shell" "npx" "karma" "start" "--single-run"]]})

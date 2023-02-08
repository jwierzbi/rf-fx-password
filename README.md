# rf-fx-password

A [re-frame](https://github.com/day8/re-frame) coeffect for creating random
passwords.

## Usage

### Step 1. Add dependency

Add the following project dependency:

[![Clojars](https://img.shields.io/clojars/v/net.clojars.jwierzbi/rf-fx-password.svg)](https://clojars.org/net.clojars.jwierzbi/rf-fx-password)

### Step 2. Add to namespace

In the namespace add the "require":

```clj
(ns app.core
  (:require
    ...
    [re-frame.core :as re-frame]
    [rf-fx-password.core] ;; add this
    ...))
```

### Step 3. Use

```clj
(re-frame/reg-event-fx
 ::event
 [(re-frame/inject-cofx :random-password)]
 (fn [{:keys [db random-password]} _]
   (println "password:" random-password) ;; new password can be used
   ...))
```

## License

rf-fx-password is [2-Clause BSD License](LICENSE).

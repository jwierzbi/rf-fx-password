# rf-fx-password

A [re-frame](https://github.com/day8/re-frame) coeffect for creating random
passwords.

![Unit tests status](https://github.com/jwierzbi/rf-fx-password/actions/workflows/unit-tests.yaml/badge.svg)

## Usage

**Step 1.**

Add the following project dependency:

[![Clojars](https://img.shields.io/clojars/v/net.clojars.jwierzbi/rf-fx-password.svg)](https://clojars.org/net.clojars.jwierzbi/rf-fx-password)

**Step 2.**

In the namespace add the "require":

```clj
(ns app.core
  (:require
    ...
    [re-frame.core :as re-frame]
    [rf-fx-password.core] ;; add this
    ...))
```

**Step 3.**

The password is passed in the coeffects map under `:random-password` key.

The coeffect can be used either without any arguments:

```clj
(re-frame/reg-event-fx
 ::event
 [(re-frame/inject-cofx :random-password)]      ;; add the coeffect
 (fn [{:keys [db random-password]} _]           ;; by default the password is 10
   (println "password:" random-password)        ;; characters long
   ...))

;; password: SFfV&RnuWy
```

Or it can take a password length:

```clj
(re-frame/reg-event-fx
 ::event
 [(re-frame/inject-cofx :random-password 16)]   ;; add the coeffect
 (fn [{:keys [db random-password]} _]           ;; password will have 16
   (println "password:" random-password)        ;; characters
   ...))

;; password: y$zAq?"^k0g;Bn(V
```

## License

rf-fx-password is [2-Clause BSD License](LICENSE).

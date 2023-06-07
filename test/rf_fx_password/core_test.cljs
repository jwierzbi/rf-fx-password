(ns rf-fx-password.core-test
  (:require [cljs.test :refer [deftest is async]]
            [re-frame.core :as re-frame]
            [rf-fx-password.core]))

(def ^:const default-length 10)
(def ^:const defined-length 16)

(re-frame/reg-event-fx
 ::event-with-default-length-password
 [(re-frame/inject-cofx :random-password)]
 (fn [{:keys [db random-password]} [_ done]]

   (println "password:" random-password)

   (is (= (count random-password) default-length))

   (done)
   {:db db}))

(deftest random-password-with-default-length-test
  (async
   done
   (re-frame/dispatch [::event-with-default-length-password done])))

(re-frame/reg-event-fx
 ::event-with-defined-length-password
 [(re-frame/inject-cofx :random-password defined-length)]
 (fn [{:keys [db random-password]} [_ done]]

   (println "password:" random-password)

   (is (= (count random-password) defined-length))

   (done)
   {:db db}))

(deftest random-password-with-defined-length-test
  (async
   done
   (re-frame/dispatch [::event-with-defined-length-password done])))

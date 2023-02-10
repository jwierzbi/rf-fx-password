(ns rf-fx-password.core
  (:require [re-frame.core :as re-frame]
            [clojure.string :as string]))

(defn gen-password
  "Generates random password with a given `length`. The password is generated
   from lower and upper-case letters, numbers and special characters."
  [length]
  (let [chars (string/join ["abcdefghijklmnopqrstuvwxyz"
                            "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                            "0123456789"
                            "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~"])]
    (reduce
     (fn [x _] (string/join [x (rand-nth chars)]))
     ""
     (range length))))

(re-frame/reg-cofx
 :random-password
 (fn [cofx length]
   (assoc cofx :random-password (gen-password (if (int? length) length 10)))))

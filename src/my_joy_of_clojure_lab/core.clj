(ns my-joy-of-clojure-lab.core
  (:use [clojure.test               :only [run-tests]])
  (:use [midje.sweet]))

(defn map-bit-xor ""
  [max-x max-y] (for [x (range max-x), y (range max-y)] [x y (bit-xor x y)]))

;.;. Out of clutter find simplicity; from discord find harmony; in the
;.;.                               ; middle of difficulty lies opportunity.
;.;.                               ; -- Einstein
(fact (map-bit-xor 2 2) => [[0 0 0] [0 1 1] [1 0 1] [1 1 0]])
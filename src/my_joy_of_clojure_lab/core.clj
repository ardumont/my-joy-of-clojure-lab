(ns my-joy-of-clojure-lab.core
  (:use [clojure.test               :only [run-tests]])
  (:use [midje.sweet]))

(defn map-bit ""
  [max-x max-y]
  (for [x (range max-x), y (range max-y)] [x y]))

(fact (map-bit 2 2) => [[0 0] [0 1] [1 0] [1 1]] )

(defn map-bit-xor ""
  [max-x max-y] (map (fn [[x y]] [x y (bit-xor x y)]) (map-bit max-x max-y)))

;.;. A clean boundary between useful abstractions and the grubby code that
;.;. touches the real world is always a good thing. -- Ron Jeffries
(fact (map-bit-xor 2 2) => [[0 0 0] [0 1 1] [1 0 1] [1 1 0]])
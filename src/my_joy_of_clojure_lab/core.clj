(ns my-joy-of-clojure-lab.core
  (:use [clojure.test               :only [run-tests]])
  (:use [midje.sweet]))

;; xor

(defn xors ""
  [max-x max-y] (for [x (range max-x), y (range max-y)] [x y (bit-xor x y)]))

;.;. The sum of wisdom is that time is never lost that is devoted to work.
;.;. -- Emerson
(fact (xors 2 2) => [[0 0 0] [0 1 1] [1 0 1] [1 1 0]])

;; java method discovery

;; instanciates a new frame
(def frame (java.awt.Frame.))

;; retrieve all the methods from the Frame class.
;; (seq (.getMethods java.awt.Frame))

(defn filter-method "Filter the methods from a java class"
  [clazz re]
  (for [method (seq (.getMethods clazz))
        :let [method-name (.getName method)]
        :when (re-find re method-name)]
    method-name))

(fact
  (filter-method java.awt.Frame #"Vis") => ["setVisible", "isVisible"])

(defn xors-frame ""
  [frame f]
  (let [gfx (.getGraphics frame)]
#_    (do
      (.setSize frame (java.awt.Dimension. 200 200))
      (.fillRect gfx 100 100 50 75)
      (.setColor gfx (java.awt.Color. 255 128 0))
      (.fillRect gfx 100 150 75 50))))
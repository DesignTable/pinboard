(ns pinboard.widget
  (:require [lt.object :as object]
            [lt.objs.command :as cmd]
            [lt.objs.tabs :as tabs]
            [lt.util.dom :as dom]
            )
  (:require-macros [lt.macros :refer [behavior defui]]))


(defui close-button [elem]
  [:span.button "remove"]
  :click (fn []
           (println "remove elem")
           (dom/remove elem)
           ))

(defui widget0 []
  [:div
   [:p "some text"]])

(defn wclose []
  (let [wrapper widget0]
    (dom/append wrapper (close-button wrapper))
    wrapper))

(def testvar "str value")

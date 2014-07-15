(ns pinboard.pintab
  (:require [lt.object :as object]
            [lt.objs.command :as cmd]
            [lt.objs.tabs :as tabs]
            [pinboard.widget :as pw]
            )
  (:require-macros [lt.macros :refer [behavior defui]]))

(defui pinboard-panel [this title]
  [:h1 (str "Pinboard: " title)])


(def tval pw/testvar)
(def uval "u")

(defn fuval [] "some string")

; from browser
(behavior ::destroy-on-close
                  :triggers #{:close}
                  :reaction (fn [this]
                              ;(println "pinboard destroy")
                              ;(object/raise this :inactive)
                              (object/destroy! this)))

(object/object* ::pinboard.panel
                :tags [:pinboard.panel]
                :name "pinboard"
                :init (fn [this title]
                        (pinboard-panel this title)))

(def default-title "Default")
;(def default-pinboard (object/create ::pinboard.panel default-title))
(defn default-pinboard
  "find the default pinboard. Create it, if it doesn't exist."
  []
  (let [insts (object/instances-by-type ::pinboard.panel)
        def-insts (filter #(= (:args (deref %)) [default-title]) insts)
        _         (if (< 1 (count def-insts))
                    (println "Error: more than 1 default instance"))
        def-inst (if (empty? def-insts)
                   (object/create ::pinboard.panel default-title)
                   (first def-insts))]
    def-inst))


(defn new-pinboard [title]
  (object/create ::pinboard.panel title))

(cmd/command {:command ::show-pinboard
              :desc "pinboard: Show default"
              :exec (fn []
                      ;(println "show default pinboard")
                      (tabs/add-or-focus! (default-pinboard)))})
;                      (tabs/add-or-focus! (object/create ::plugin0.panel)))})


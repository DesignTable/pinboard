(ns pinboard.test
  (:require [pinboard.pintab :as pt]
            [pinboard.widget :as pw]
            [lt.objs.tabs :as tabs]
            [lt.object :as object]
            [lt.util.dom :as dom]
            ))


(def pt1 (pt/new-pinboard "t1"))
(tabs/add-or-focus! pt1)
pt1

(dom/append (object/->content pt1)
        (pw/widget0))

(dom/append (object/->content pt1)
        (pw/wclose))

(pw/wclose)

(dom/append (let [w pw/widget0]
              (pw/close-button w)))

;; use of fragments!
(let [w (pw/widget0)
      cb (pw/close-button w)
      fragw (dom/fragment [w])
      _ (dom/append w cb)]
  (dom/append (object/->content pt1) fragw))


(count (object/instances-by-type :pinboard.pintab/pinboard.panel))
(first (object/instances-by-type :pinboard.pintab/pinboard.panel))


(defn destroy-pintabs []
  (map object/destroy!
       (object/instances-by-type :pinboard.pintab/pinboard.panel)))

(destroy-pintabs)


(comment
  (destroy-pintabs)
)

(object/->content pt1)

(def test-w (pw/wclose))
(pw/widget0)

pw/testvar
pt/tval
pt/uval
(println pt/uval)
(pt/fuval)

pt/tval

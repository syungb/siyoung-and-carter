(ns app.core
  (:require-macros [secretary.core :refer [defroute]])
  (:import goog.history.Html5History)
  (:require
    [app.components.header :refer [header]]
    [app.components.footer :refer [footer]]
    [app.pages.home :refer [home]]
    [reagent.core :as r]
    [secretary.core :as secretary]))


;; adding routing using secretary
(def app-state (r/atom {}))

;; adding browser history
(defn hook-browser-navigation! []
  (doto))


(defn app []
  [:div.container
   [header]
   [home]
   [footer]])

(defn ^:export main []
 (r/render
   [app]
   (.getElementById js/document "app")))

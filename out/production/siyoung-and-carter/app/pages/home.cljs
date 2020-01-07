(ns app.pages.home
  (:require
    [reagent.core :as r]))

(defn main-photo
  []
  [:div.main__img
   [:img {:src "/img/yosemite_2019.jpg"
          :alt "Carter and Siyoung in Yosemite 2019"}]])

(defn home
  []
  [:div.main
   [main-photo]
   [:div.main__text
    [:span "Welcome to Siyoung and Carter's Wedding Page"]]])
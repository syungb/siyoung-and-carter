(ns app.pages.home
  (:require
    [reagent.core :as r]))

(defn main-photo
  []
  [:div.image_renderer
   [:img {:class "image_renderer__img"
          :src "/img/main_photo.jpg"
          :alt "Carter and Siyoung in Yosemite 2019"}]
   [:div.text__block
    [:h2.text-align-center.date "Saturday, May 16th, 2020"]
    [:h2.text-align-center.venue "Grace Venue, Toronto"]]])


(defn home
  []
  [:div.home
   [main-photo]])
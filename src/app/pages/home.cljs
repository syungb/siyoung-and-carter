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
    [:h2.text-align-center.date "June 18th, 2022"]
    [:h2.text-align-center.date "2022년 6월 18일"]
    [:h2.text-align-center.venue "Grace Venue, Toronto"]]])

(defn home
  []
  [:div.home
   [main-photo]])
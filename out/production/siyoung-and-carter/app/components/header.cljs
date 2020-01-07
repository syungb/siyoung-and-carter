(ns app.components.header
  (:require [app.components.menu :refer [menu]]))

(defn header
  []
  [:header
   [:nav {:class "nav-desktop"}
    [:a
     {:class "nav__a--logo"
      :href  "/"}
     [:img
      {:class "nav__img--logo"
       :src "img/logo.png"
       :alt "our logo"}]]
    [menu]]])

(defn header-mobile []
  "testing testing")

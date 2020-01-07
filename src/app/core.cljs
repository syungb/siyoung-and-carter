(ns app.core
  (:require-macros [secretary.core :refer [defroute]])
  (:import goog.history.Html5History)
  (:require
    [app.pages.home :refer [home]]
    [app.pages.our-story :refer [our-story]]
    [app.pages.ceremony :refer [ceremony]]
    [app.pages.rsvp :refer [rsvp]]
    [goog.events :as events]
    [goog.history.EventType :as EventType]
    [reagent.core :as r]
    [secretary.core :as secretary]))

;; -----------------------------------------------------------------------------
;; ROUTES
;; -----------------------------------------------------------------------------
;; adding routing using secretary
(def app-state (r/atom {}))

;; adding browser history
(defn hook-browser-navigation! []
  (doto (Html5History.)
    (events/listen
      EventType/NAVIGATE
      (fn [event]
        (secretary/dispatch! (.-token event))))
    (.setEnabled true)))


;; creating routes
(defn app-routes []
  (secretary/set-config! :prefix "#")

  (defroute "/" []
    (swap! app-state assoc :page :home))

  (defroute "/our-story" []
    (swap! app-state assoc :page :our-story))

  (defroute "/ceremony" []
    (swap! app-state assoc :page :ceremony))

  (defroute "/rsvp" []
    (swap! app-state assoc :page :rsvp))

  (hook-browser-navigation!))

;; creating a current-page multimethod that will return which page component
;; to display based on app-state
(defmulti current-page #(@app-state :page))

(defmethod current-page :home []
  [home])

(defmethod current-page :our-story []
  [our-story])

(defmethod current-page :ceremony []
  [ceremony])

(defmethod current-page :rsvp []
  [rsvp])

(defmethod current-page :default []
  [:div])

;; -----------------------------------------------------------------------------
;; HEADER
;; -----------------------------------------------------------------------------
(def menu-list
  (list
    {:page   :home
     :title "Home"
     :url   "#/"}
    {:page   :our-story
     :title "Our Story"
     :url   "#/our-story"}
    {:page   :ceremony
     :title "Ceremony"
     :url   "#/ceremony"}
    {:page   :rsvp
     :title "RSVP"
     :url   "#/rsvp"}))

(defn menu []
  (into
    [:div.nav__links_container
     [:ul.nav__ul--link
      (doall
        (map
          (fn [{:keys [page title url]}]
            ^{:key page} [:li
                          [:a.nav__a--link
                           {:class (when (= (@app-state :page) page) "active")
                            :on-click #(-swap! app-state assoc :page page)
                            :href  url}
                           title]])
          menu-list))]]))


(def nav-menu (r/atom "closed"))

(defn mobile-menu []
  (let [menu-click @nav-menu]
   [:div.mobile-nav__links_container
    [:ul.mobile-nav__ul--links
     {:class (when (= menu-click "opened") "menu-open")}
     (doall
       (map
         (fn [{:keys [page title url]}]
           ^{:key page} [:li
                         [:a.mobile-nav__a--link
                          {:class (when (= (@app-state :page) page) "active")
                           :on-click (do
                                       (fn [] (-swap! app-state assoc :page page))
                                       (fn [] (reset! nav-menu "closed")))
                           :href url}
                          title]])
         menu-list))]
    [:div.mobile-menu__link
     [:a
      {:on-click
       (fn []
         (if (= menu-click "closed")
           (reset! nav-menu "opened")
           (reset! nav-menu "closed")))}
      "Menu"]]]))


(defn header
  []
  [:header
   [:div.nav_desktop
    [:div.nav_logo
     [:h1.logo
      [:a {:href "#/"} "Siyoung & Carter"]]]
    [menu]]])

;; -----------------------------------------------------------------------------
;; FOOTER
;; -----------------------------------------------------------------------------
(def copyright
  "Copyright Ⓡ 2020 Siyoung Byun. All rights reserved.")

(defn footer
  []
  [:footer
   [:span.footer__text copyright]])


;; -----------------------------------------------------------------------------
;; APP STRUCTURE
;; -----------------------------------------------------------------------------
(defn app []
  [:div.app__container
   [mobile-menu]
   [header]
   [:div.main
    [current-page]]
   [footer]])

;; -----------------------------------------------------------------------------
;; MAIN FUNCTION
;; -----------------------------------------------------------------------------
(defn ^:export main []
  (app-routes)
  (r/render
    [app]
    (.getElementById js/document "app")))

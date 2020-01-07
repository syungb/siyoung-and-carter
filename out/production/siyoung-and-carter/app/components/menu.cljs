(ns app.components.menu)

(def menu-list
  [{:title "Home"
    :url   "/"}
   {:title "Our Story"
    :url   "/our-story"}
   {:title "Ceremony"
    :url   "/ceremony"}
   {:title "RSVP"
    :url   "/rsvp"}])

(defn menu []
  [:div {:class "nav__links_container"}
   [:ul {:class "nav__ul--link"}
    (for [menu menu-list]
      (let [name (:title menu)
            url  (:url   menu)]
        ^{:key name} [:li
                      [:a {:class "nav__a--link"
                           :href  url} name]]))]])
(ns app.pages.ceremony
  (:require
    ["@material-ui/core/Button" :default Button]
    ["@material-ui/icons/Map" :default Map]
    ["@material-ui/icons/CalendarToday" :default CalendarToday]))

(def wedding-detail-en
  "We will be holding our ceremony and reception at the Grace Venue in Toronto on Saturday, May 16, 2020 at 4PM.
   We will start with the ceremony, followed by passed hors d'oeuvres before the full course dinner. There is no specific dress code. Please join us as we celebrate our love with a night full of eating and drinking with great company!")

(def wedding-detail-kr
  "저희 결혼식은 2020년 5월 16일 토요일 오후 4시, 캐나다 토론토 그레이스베뉴에 진행될 예정입니다.
  식순은 결혼예식으로 시작하여, 저녁만찬이 있을예정입니다.
  특별한 드레스 코드는 없습니다.
  결혼식과 함께 이루어지는 피로연 파티에도 참석 부탁드립니다.")

(defn wedding-registry []
  [:div.wedding_registry
   [:div.info-text__block
    [:h2 "Wedding Registry"]
    [:p.description
     "Though you may wish to send us a gift, we already have plenty of material objects in our lives, and do not require more."]
    [:p.description
     "Your attendance is truly the best gift you could give us! We know many of you will be travelling from far away, and we appreciate the effort it takes to get here. All your love, friendship, and support means the world to us!"]
    [:p.description
     "저희에게 축하의 의미로 선물을 주고 싶어 하시는 마음은 감사하지만, 저희는 이미 필요한것이 없을만큼 충분합니다. 결혼식에 참석해 주시는것만으로도 저희에겐 최고의 선물이 될것입니다. 또한 먼곳에서 저희를 위해 와주시는 것만으로도 너무 감사합니다. 마음만 받겠습니다."]]])

(defn info-block []
  [:div.info__block
   [:div.info-text__block
    [:h2.text-align-center
     "Ceremony and Reception"]
    [:h3.text-align-center
     "SATURDAY, MAY 16TH 2020" [:br]
     "4:00 PM - Late Night"]
    [:h3.text-align-center
     "Grace Venue" [:br]
     "150 Symes Rd Unit #130" [:br]
     "Toronto, ON M6N 0B1"]]

   [:div.map__button
    [:> Button
     {:color   :primary
      :variant :outlined
      :href    "https://goo.gl/maps/oMrNLy9Qox8rs6Kt7"
      :target  "_blank"}
     [:> Map]
     "VIEW MAP"]]
   [:div {:class "calendar_link__block text-align-center"}
    [:p
     [:> CalendarToday
      {:class "mui_icon calendar"
       :font-size :small}]
     "We've attached an iCalendar/Google Calendar invite with all of the necessary information. "
     [:a.calendar__link {:href "/files/siyoung-carter-wedding.ics"} "Click Here!"]]]])

;; TODO -- make calendar file to upload

(defn ceremony []
  [:div.ceremony
   [:div.ceremony_details__text
    [:p.text-align-center wedding-detail-en]
    [:p.text-align-center wedding-detail-kr]]
   [info-block]
   [wedding-registry]])



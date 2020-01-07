(ns app.pages.ceremony
  (:require
    ["@material-ui/core/Button" :default Button]))

(def wedding-detail-en
  "We will be holding a formal ceremony and reception at the XXXX on Saturday, May 16, 2020.
   We will start with a nonsectarian ceremony, followed by the XXX style dinner for our reception.
   There is no specific dress code.
   Please join us as we celebrate our love with a night full of eating and drinking with great company")

(def wedding-detail-kr
  "저희 결혼식은 2020년 5월 16일 토요일, 캐나다 토론토 0000에서 진행될 예정입니다.
  식순은 결혼예식으로 시작하여, 저녁만찬이 있을예정입니다.
  특별한 드레스 코드는 없습니다.
  결혼식과 합께 이루어지는 피로연 파티에도 참석 부탁드립니다.")

(defn info-block []
  [:div.info__block
   [:div.info-text__block
    [:h2.text-align-center
     "Ceremony and Reception"]
    [:h3.text-align-center
     "SATURDAY, MAY 16TH 2020" [:br]
     "X:XX - XX:XX PM"]
    [:p.text-align-center
     "Venue Name" [:br]
     "Venue address" [:br]
     "Toronto, ON PostalCode"]]
   [:div.map__button
    [:> Button
     {:color   :primary
      :variant :outlined
      :href    "https://goo.gl/maps/rFJAavLAut2R3wQN7"
      :target  "_blank"}
     "VIEW MAP"]]])

;; TODO -- make calendar file to upload

(defn ceremony []
  [:div.ceremony
   [:div.ceremony_details__text
    [:p.text-align-center wedding-detail-en]
    [:p.text-align-center wedding-detail-kr]]
   [info-block]])



(ns app.pages.simple-korean
  (:require
   [app.pages.our-story :as our-story]))

(defn main-photo
  []
  [:div.sk-wedding-intro--main-photo
   [:div.image_renderer
    [:img {:class ["image_renderer__img" "main__photo"]
           :src "/img/year_08.jpg"}]]])

(def couple
  [:<>
   [:div.sk-wedding-intro--couple
    [:div
     [:span.title "신랑/"]
     [:span.name "카터 브루스"]]]
   [:div.sk-wedding-intro--couple
    [:div
     [:span.title "신부/"]
     [:span.name "변시영"]]]])

(def wedding-parents
  [:div.sk-wedding-intro--parents
   [:div
    [:span "변희섭 · 박희숙"]
    [:span.small "의 딸"]
    [:span "시영"]]
   [:div
    [:span "로저 브루스 · 베키 루이스"]
    [:span.small "의 아들"]
    [:span "카터"]]])

(defn intro []
  [:div.sk-wedding-intro
   couple
   wedding-parents])

(defn ceremony-info []
  [:div.sk-wedding-ceremony-info
   [:h2 "2022년 06월 18일"]
   [:h2 "토요일 오후 4시"]
   [:h3 "그레이스 베뉴, 토론토"]])

(defn copy-to-clipboard [val]
  (let [el (js/document.createElement "textarea")]
    (set! (.-value el) val)
    (.appendChild js/document.body el)
    (.select el)
    (js/document.execCommand "copy")
    (.removeChild js/document.body el)))

(defn copyable-button [value]
  [:button.copy_account
   {:type :button
    :on-click #(do (.stopPropagation %)
                   (copy-to-clipboard value))}
   "복사하기"])

(defn account-info [parent]
  [:div.sk-wedding-account-info
   [:div.sk-wedding-account-info--title
    "마음전하실 곳 (계좌번호)"]
   [:span.sk-wedding-account-info--number
    [:span.account_name
     (if (= parent :mom)
       "예금주: 박희숙 (모)"
       "예금주: 변희섭 (부)")]
    [:div.account_area
     [:span (if (= parent :mom)
              "전북은행 604-22-0047360"
              "전북은행 604-12-0436903")]
     [copyable-button (if (= parent :mom)
                        "604-22-0047360"
                        "604-12-0436903")]]]])

(defn simple-korean
  [parent]
  [:div.text-align-center
   [main-photo]
   [:div.wrapper
    [:div.logo
     [:span.sk-wedding-gallery--title
      "Gallery"]]
    [our-story/photo-renderer]
    [our-story/dot-renderer]]
   [intro]
   [ceremony-info]
   [account-info parent]])

(ns app.pages.simple-korean)

(defn main-photo
  []
  [:div.sk-wedding-intro--main-photo
   [:img {:class ["image_renderer__img"]
          :src "/img/sk_main.jpg"}]])

(defn note
  []
  [:div.sk-wedding-note
   [:div.thank-you
    [:b
     "EVERY DAY, EVERY MOMENT ❤️"]]
   [:div
    "언제나 사랑으로 함께 하겠습니다."]
   [:div
    "두 사람이 이제 새로운 가정을 이루는"]
   [:div
    "아름다운 약속을 하려 합니다."]
   [:div
    "언제나 아름답고 주위에 사랑을 나누는"]
   [:div
    "행복한 가정을 이루도록"]
   [:div
    "축복해 주시고 지켜봐 주십시오."]])

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
   [note]
   [intro]
   [ceremony-info]
   [account-info parent]])

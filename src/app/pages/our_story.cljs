(ns app.pages.our-story
  (:require
    [reagent.core :as r]
    ["@material-ui/core/IconButton" :default IconButton]
    ["@material-ui/icons" :as mui-icons]))

(def about-us
  (list
    {:ind   1
     :parag "while we were both volunteering
                at the Toronto International Film Festival. Among of thousands
                of other volunteers and volunteer shifts, a stroke of good
                fortune saw us scheduled to work together towards the end of
                the festival. We hit it off right away, and the festival wrap
                party was our first (unofficial) date. Many more dates soon
                followed, and it was clear we had found love! "}
    {:ind   2
     :parag "저희는 2008년 토론토 국제 영화제에서 만났습니다. 수천명의 자원봉사자들과 수백개의
         자원봉사 스케줄이 있는 가운데, 저희는 운이좋게도 영화제 마지막날 뜻하지 않은 행운으로
         만날 수 있었습니다. 저희는 처음부터 서로 너무도 잘 맞았고, 영화제가 끝나고 이를 마무리하는
         파티가 저희의 비공식 첫 데이트였습니다. 그다음 많은 데이트와 함게 저희는 서로를 사랑하고
         있다는걸 확신할 수 있었습니다."}
    {:ind   3
     :parag "When we met, we had both come to Canada as students. Carter
                 came from the US to study film at the University of Toronto.
                 And Siyoung transferred from Jeonbuk University in Korea to
                 U of T to complete her degree in Astrophysics. After finding
                 each other here in Toronto, we decided to make this city our
                 home. "}
    {:ind   4
     :parag "처음 만난 해 저희는 둘다 캐나다에서 학생신분이었습니다. 카터는 미국에서 캐나다로 건너와
     토론토대학에서 영화를 공부하고 있었고, 시영이는 한국에서 전북대학교를 다니다 토론토대학으로
     편입하여 천체물리학 학사를 마쳤습니다. 그이후 서로를 만나게된 토론토를 저희의 보금자리로 정하게
     되었습니다."}))

(def photos
  (list {:id   0
         :src  "/img/year_01.jpg"
         :desc "Year 1, at Kensinton Market"}
        {:id   1
         :src  "/img/year_04.jpg"
         :desc "Year 4, at World Wide Short Film Festival Party"}
        {:id   2
         :src  "/img/year_06.jpg"
         :desc "Year 6, working together at Tiff"}
        {:id   3
         :src  "/img/year_08.jpg"
         :desc "Year 8, at Niagara Falls. On the day we got our PR status in Canada"}
        {:id   4
         :src  "/img/IMG_5666.jpg"
         :desc "Year 9, at Ontario Place"}
        {:id   5
         :src  "/img/IMG_5860.jpg"
         :desc "Year 11, walking to a farmer's market"}
        {:id   6
         :src  "/img/IMG_6077.jpg"
         :desc "Year 9, in Busan, South Korea"}
        {:id   7
         :src  "/img/IMG_6804.jpg"
         :desc "Year 10, at the Elora Gorge"}
        {:id   8
         :src  "/img/IMG_6833.jpg"
         :desc "Year 10, at Prince Edward County"}
        {:id   9
         :src  "/img/IMG_7076.jpg"
         :desc "Year 10, at Dundas Peak in Hamilton"}
        {:id   10
         :src  "/img/IMG_7283.jpg"
         :desc "Year 10, at Letchworth State Park"}
        {:id   11
         :src  "/img/IMG_8380.jpg"
         :desc "Year 11, at Marble Canyon AZ"}
        {:id   12
         :src  "/img/IMG_8409.jpg"
         :desc "Year 11, at Grand Canyon"}
        {:id   13
         :src  "/img/IMG_8590.jpg"
         :desc "Year 11, at Yosemite Park"}))

(defn slides [n]
  (let [slides    (array-seq (.getElementsByClassName js/document "mySlides"))
        slide-len (count slides)
        slide-index (cond
                      (> n slide-len) 1
                      (< n 1)         slide-len)]
    (nth slides (- slide-index 1))))


(def current-index (r/atom 0))

(defn next-photo []
  (let [current-val @current-index
        numb (count photos)]
   (cond
     (= current-val (- numb 1)) (reset! current-index 0)
     (< current-val (- numb 1)) (reset! current-index (inc current-val)))))

(defn prev-photo []
  (let [current-val @current-index
        numb (count photos)]
    (cond
      (= current-val 0) (reset! current-index 11)
      (and (> current-val 0) (< current-val numb)) (reset! current-index (dec current-val)))))


(defn photo-renderer []
  [:div.slideshow-container
   (doall
     (for [photo photos]
       (let [id   (:id   photo)
             src  (:src  photo)
             desc (:desc photo)]
         ^{:key id} [:div {:class "my-slides fade"
                           :style (when (= @current-index id) {:display :block})}
                     [:div.number--text (str id " / " (count photos))]
                     [:img {:src src}]
                     [:div.text desc]])))
   [:div.prev
    [:> IconButton {:class "pre icon_button"
                    :variant "contained"
                    :color "primary"
                    :size :small
                    :on-click (fn [] (prev-photo))}
     [:> mui-icons/ArrowBackIos {:class "mui_icon"}]]]

   [:div.next
    [:> IconButton {:class "next icon_button"
                    :variant "contained"
                    :color "primary"
                    :size :small
                    :on-click (fn [] (next-photo))}
     [:> mui-icons/ArrowForwardIos {:class "mui_icon"}]]]])

(defn dot-renderer []
  [:div {:style {:text-align :center}}
   (doall
    (for [photo photos]
      (let [id (:id photo)]
        ^{:key id} [:> IconButton {:class "dot_renderer icon_button"
                                   :variant "contained"
                                   :size :small
                                   :on-click #(reset! current-index id)}
                    (if (= @current-index id)
                      [:> mui-icons/Lens {:class "dot_icon" :font-size :small}]
                      [:> mui-icons/PanoramaFishEye {:class "dot_icon" :font-size :small}])])))])


(defn our-story []
  [:div.our_story
   [:div.our_story__text
    [:h2.text-align-center
     "We met in the fall of 2008,"]
    (doall
      (for [par about-us]
        (let [parag (:parag par)
              ind   (:ind   par)]
          ^{:key ind} [:p {:class "text-align-center"} parag])))]
   [:div.wrapper
    [photo-renderer]
    [dot-renderer]]])
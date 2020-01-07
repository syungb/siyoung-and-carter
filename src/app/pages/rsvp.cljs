(ns app.pages.rsvp)

(def google-form-url
  "https://docs.google.com/forms/d/e/1FAIpQLSd9DUtspvHQMCOKUSMuTM_M-0PFObHb9RtNfX8ISgnJI35gUw/viewform?embedded=true")

(defn rsvp []
  [:div.rsvp
   [:iframe.rsvp__form
    {:class "google_form__embedded"
     :src google-form-url
     :width "640"
     :height "1200"
     :frameBorder "0"
     :marginHeight "0"
     :marginWidth "0"}
    "Loading…"]])
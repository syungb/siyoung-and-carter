(ns app.pages.toronto)

(defn where-to-stay []
  [:div.paragraph__text
   [:h2 "Where to Stay"]
   [:h3 "We don't have any hotel block reservations, but there are many places
         to stay in the city. Look for a plcae in the West end of the city to
         be closer to our wedding venue."]
   [:ul
    [:li
     [:p.title "Airbnb"]
     [:p.description "Airbnb is a good option for staying in toronto on a budget.
                      There are many places available all across the city in a
                      lot of price ranges."]]
    [:li
     [:p.title "Boutique Hotels"]
     [:p.description
      "For those looking for something a little more fancy and unique
       (but also more pricey) Toronto has a number of boutique hotels. Check out "
      [:a.links
       {:href   "https://www.blogto.com/toronto/the_best_boutique_hotels_in_toronto/"
        :target "_blank"}
       "this list"]
      " for suggestions."]]
    [:li
     [:p.title "Royal York Hotel"]
     [:p.description
      "For the classic Grand Canadian Railway Hotel Experience."]]
    [:li
     [:p.title "Other Options?"]
     [:p.description
      "And of course, there are downtown locations of recognizable chains like
       Hilton Garden Inn or Holiday Inn."]]]])

(defn getting-around []
  [:div.paragraph__text
   [:h2 "Getting Around"]
   [:h3 "If you don’t have your own car, or won’t be renting a car there
         are lots of ways to get around town"]
   [:ul
    [:li
     [:p.title "TTC"]
     [:p.description
      "This is the public transit system for Toronto, with subways,
      streetcars, and buses. You can pay fares with cash, but buses and
      streetcars will require exact change. The best option would probably
      be to get a "
      [:a.links
       {:href   "https://www.prestocard.ca/en/about/presto-ticket"
        :target "_blank"}
       "Presto Ticket day pass"]
      ", available at subway stations or Shoppers Drug Mart locations."]]
    [:li
     [:p.title "Rideshares"]
     [:p.description
      "Both Uber and Lyft are ubiquitous in Toronto, so if you have the app,
      you should have no trouble hailing a ride. If you’d rather not use these
      companies, there are also plenty of traditional taxi cabs. "
      [:a.links
       {:href   "http://www.becktaxi.com"
        :target "_blank"}
       "Beck Taxi"]
      " and "
      [:a.links
       {:href   "https://co-opcabs.com/"
        :target "_blank"}
       "Co-Op Cabs"]
      " both have big fleets."]]
    [:li
     [:p.title "Bike Share"]
     [:p.description
      "Biking is a great way to see the city! "
      [:a.links
       {:href   "https://bikesharetoronto.com/"
        :target "_blank"}
       "Bike Share Toronto"]
      " lets you rent bikes from docking stations all over the city. Rent for a
      single ride, or get a pass."]]]])

(defn food []
  [:div.paragraph__text
   [:h2 "Food"]
   [:h3
    "Toronto has a lot of delicious restaurants offering cuisines from all over
    the world. So it would be impossible to distill it down to a few
    recommendations. If you google recommendations for your desired cuisine,
    you’ll probably find some great options!"]])

(defn things-to-do []
  [:div.paragraph__text
   [:h2 "Things to Do"]
   [:ul
    [:li
     [:p.title "Visit a museum"]
     [:p.description
      "The AGO, ROM, Gardiner, and Aga Khan are all great museums to visit."]]
    [:li
     [:p.title "Toronto Island"]
     [:p.description
      "Take the ferry out to the Island for some lovely parks and a nice
      view of the skyline."]]
    [:li
     [:p.title "Watch a movie"]
     [:p.description
      "Siyoung and I met while volunteering at a film festival, and Toronto
      is a great city for cinema lovers. If you’d like to check out an
      independent cinema, there are a number to choose from: TIFF Bell Lightbox,
      Hot Docs, The Paradise, The Royal, The Revue, The Fox, to name a few."]]
    [:li
     [:p.title "See some live music"]
     [:p.description
      "If you’re looking for concert listings "
      [:a.links
       {:href   "https://nowtoronto.com/search/event/music/#page=1"
        :target "_blank"}
       "NOW Magazine"]
      " usually has a pretty comprehensive list of who is playing on a given date."]]]])

(defn free-things-to-do []
  [:div.paragraph__text
   [:h2 "Free Things to Do"]
   [:ul
    [:li
     [:p.title "Explore the city"]
     [:p.description
      "This is a bit of a no-brainer, but Toronto really does have a lot of
      neighborhoods that are fun to walk around in. Places like Kensington,
      Chinatown, Koreatown, Queen West, and the Distillery District are worth
      a visit."]]
    [:li
     [:p.title "Allen Gardens"]
     [:p.description
      [:a.links
       {:href   "https://www.toronto.ca/explore-enjoy/parks-gardens-beaches/gardens-and-horticulture/conservatories/allan-gardens-conservatory/"
        :target "_blank"}
       "This indoor botanical garden"]
      "  is a really cool destination. The oldest parts are over 100 years old,
      and admission is free! A great option when the weather is bad and you
      don’t want to be outdoors, but still want to experience some greenery
      in the city."]]
    [:li
     [:p.title "Explore a park"]
     [:p.description
      "If you’d rather spend your time walking amongst the plant life rather
      than street life, Toronto has a lot of good parks."]
     [:div.list_circle
      [:ul
       [:li "High Park - One of the biggest, it has both wooded trails and more
            manicured recreational grounds. It also has a small zoo with free
            admission!"]
       [:li "Scarborough Bluffs - this one is rather far east from the western
            end of the city where our wedding will be, but it features some
            stunning cliffs on Lake Ontario"]
       [:li "Riverdale Park East - Excellent view of the city skyline from this
            park"]
       [:li "For some great hiking destinations, including some picturesque
            ravines, "
        [:a.links
         {:href   "https://www.blogto.com/sports_play/2014/09/the_top_5_ravines_in_toronto/"
          :target "_blank"}
         "these websites'"]
        " lists offer many good options."]]]]]])

(defn toronto []
  [:div.visiting_toronto__text
   [where-to-stay]
   [getting-around]
   [food]
   [things-to-do]
   [free-things-to-do]])
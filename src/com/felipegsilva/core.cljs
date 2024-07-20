(ns com.felipegsilva.core(:require ["react" :as react]
                                   ["react-dom/client" :as react-dom]
                                   ["refx.alpha" :as refx]
                                   [helix.core :refer [$]]
                                   ["felipegsilva.views" :as views]))


(defn render
  []
  (react-dom/render ($ react/StrictMode ($ views/home))
                    (.getElementById js/document "app")))

(defn reload!
  []
  (refx/clear-subscription-cache!)
  (render))

(defn main!
  "initial point"
  [] 
  (render)
  (println "test"))

(ns com.felipegsilva.core
  (:require 
    ["react" :as react]
    ["react-dom/client" :as react-dom]
    [refx.alpha :as refx]
    [helix.core :refer [$]]
    [com.felipegsilva.views :as views]))


(defonce app-root
  (-> js/document
      (.getElementById "app")
      react-dom/createRoot))

(defn render []
  (->> ($ views/home)
       ($ react/StrictMode)
       (.render app-root)))

(defn reload!
  "reload frontend"
  []
  (refx/clear-subscription-cache!)
  (render))

(defn main!
  "initial point"
  [] 
  (render))


(ns main.portfolio.core (:require  ["react-dom/client" :as react-dom-client]))


(defonce root
  (-> js/document 
      (.getElementById "app")  
      react-dom-client/createRoot))

(defn render [] 
  (println "carlos"))

(defn init 
  "initial point"
  [] 
  (render)
  (println "test"))

(ns com.felipegsilva.views 
  (:require 
    [com.felipegsilva.components.app :as app]
    [com.felipegsilva.components.navbar :as navbar]
    [helix.dom :as d]
    [helix.core :refer [defnc $ <>]]))

(defnc home 
  "home page"
  []
  (<> 
    (d/main {:class (str "w-full h-full")}
            ($ app/app) 
            (d/div 
              {:class (str "w80 h80")}
              (d/p "carlos")))))

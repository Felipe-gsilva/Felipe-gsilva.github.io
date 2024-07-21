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
    (d/div {:class "flex flex-row"}
           (d/div {:class "w-[5%] h-screen"} 
                  ($ navbar/navbar))
           (d/main {:class "w-[95%] h-screen"}
                   ($ app/main)))))

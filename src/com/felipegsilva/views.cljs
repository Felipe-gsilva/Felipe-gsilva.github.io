(ns com.felipegsilva.views 
  (:require 
    ["felipegsilva.components.app" :as app]
    ["felipegsilva.components.navbar" :as navbar]
    ["helix.dom" :as d]
    [helix.core :refer [defnc $ <>]]))

(defnc home 
  "home page"
  []
  (<> 
    (d/main {:class "w-full h-full"}
            ($ app/app) 
            (d/div 
              {:class {str ""}}))))

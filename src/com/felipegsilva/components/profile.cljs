(ns com.felipegsilva.components.profile
  (:require [helix.core :refer [defnc $ <>]]
            [helix.dom :as d]))

(defnc pfp [] 
  (d/img {:class "rounded-full w-80 shadow-md"
          :src "resources/assets/img/beltrao.png"}))

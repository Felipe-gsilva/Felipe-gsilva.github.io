(ns com.felipegsilva.components.navbar 
  (:require [helix.core :refer [defnc $ <>]]
            [helix.dom :as d]))

(defnc navbar [](d/div {:class "w-8 h-full"}))

(ns com.felipegsilva.components.navbar
  (:require [helix.core :refer [defnc $ <>]]
            [helix.dom :as d]))

(defnc navbar []
  (d/div {:class "w-full h-16 flex justify-center items-center space-x-4"}
         (d/button {:class "hover:underline transition-all duration-75"} "navbar")
         (d/button {:class "hover:underline transition-all duration-75"} "navbar")
         (d/button {:class "hover:underline transition-all duration-75"} "navbar")))

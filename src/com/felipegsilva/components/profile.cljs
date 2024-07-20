(ns com.felipegsilva.components.profile
  (:require [helix.core :refer [defnc $ <>]]
            [helix.dom :as d]))

(defnc pfp [] 
  (d/img "resources/img/pfp.jpg")
  )

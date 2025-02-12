(ns com.felipegsilva.views
  (:require
   [com.felipegsilva.components.app :as app]
   [com.felipegsilva.components.navbar :refer [navbar]]
   [com.felipegsilva.components.footer :refer [footer]]
   [helix.dom :as d]
   [helix.core :refer [defnc $ <>]]))

(defnc home
  "home page" []
  (<>
   (d/body {:class "h-screen bg-gray-50"}
    (d/div  {:class "flex flex-col h-full"}
            ($ navbar)
            ($ app/header)
            ($ footer)))))

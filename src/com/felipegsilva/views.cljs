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
   (d/body {:class "h-screen w-screen bg-gray-50 flex justify-center items-center"}
           (d/div  {:class "flex flex-col h-full w-3/4 justify-center items-center"}
                   ($ navbar)
                   ($ app/header)
                   ($ footer)))))

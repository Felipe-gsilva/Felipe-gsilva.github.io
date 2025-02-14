(ns com.felipegsilva.views
  (:require
   [com.felipegsilva.components.app :refer [header]]
   [com.felipegsilva.components.navbar :refer [navbar]]
   [com.felipegsilva.components.footer :refer [footer]]
   [helix.dom :as d]
   [helix.core :refer [defnc $ <>]]))

(defnc home
  "home page" []
  (<>
   (d/body {:class "min-h-dvh lg:h-screen w-screen bg-gray-50 flex flex-col items-center font-mono overflow-hidden"}
           (d/div  {:class "flex flex-col w-full md:w-3/4 flex-1"}
                   ($ navbar)
                   ($ header)
                   #_($ footer)))))

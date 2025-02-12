(ns com.felipegsilva.components.navbar
  (:require
   [com.felipegsilva.components.svg :as svg]
   [helix.core :refer [defnc $ <>]]
   [helix.hooks :as hooks]
   [helix.dom :as d]))

(defnc navbar []
  (let [[theme set-theme] (hooks/use-state false)]
    (d/div {:class "h-16 w-full flex justify-center items-center justify-between p-8"}
           (d/span {:class "h-full space-x-4 flex justify-center items-center"}
                   (d/button {:class "hover:underline transition-all duration-75"} "navbar")
                   (d/button {:class "hover:underline transition-all duration-75"} "navbar")
                   (d/button {:class "hover:underline transition-all duration-75"} "navbar"))
           (d/button {:on-click #(set-theme (not theme))
                      :class "transition-all duration-75 hover:text-gray-500"}
                     (if theme
                       ($ svg/sun)
                       ($ svg/moon))))))

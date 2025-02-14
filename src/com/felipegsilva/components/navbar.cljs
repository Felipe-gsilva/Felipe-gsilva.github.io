(ns com.felipegsilva.components.navbar
  (:require
   [com.felipegsilva.components.svg :as svg]
   [helix.core :refer [defnc $ <>]]
   [refx.alpha :as refx]
   [helix.dom :as d]))

(defnc navbar [{:keys [is-dark?]}]
  (d/nav {:class "h-8 md:h-16 w-full flex justify-center items-center justify-between p-8 text-black dark:text-gray-500"}
         (d/span {:class "h-full space-x-4 flex justify-center items-center"}
                 (d/button {:class "hover:underline hover:text-yellow-600 transition-all duration-75"} "Home")
                 (d/button {:class "hover:underline hover:text-yellow-600 transition-all duration-75"} "About"))
         (d/button {:on-click #(refx/dispatch-sync [:app/set-theme (if is-dark? "light" "dark")])
                    :class (str "transition-all duration-125 "
                                (if is-dark?
                                  "hover:text-yellow-600"
                                  "hover:text-slate-600"))}
                   (if is-dark?
                     ($ svg/sun)
                     ($ svg/moon)))))

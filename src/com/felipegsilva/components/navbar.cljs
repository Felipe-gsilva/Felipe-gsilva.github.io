(ns com.felipegsilva.components.navbar
  (:require
   [com.felipegsilva.components.svg :as svg]
   [helix.core :refer [defnc $ <>]]
   [helix.hooks :as hooks]
   [helix.dom :as d]))

(defnc navbar [props]
    (let [{:keys [toggle-dark is-dark?]} props]
      (d/nav {:class "h-8 md:h-16 w-full flex justify-center items-center justify-between p-8"}
             (d/span {:class "h-full space-x-4 flex justify-center items-center"}
                     (d/button {:class "hover:underline hover:text-yellow-600 transition-all duration-75"} "Home")
                     (d/button {:class "hover:underline hover:text-yellow-600 transition-all duration-75"} "About"))
             (d/button {:on-click toggle-dark
                        :class (str "transition-all duration-75 hover:scale-125 "
                                    (if-not is-dark? 
                                      "hover:text-yellow-600 "
                                      "hover:text-slate-600 "))}
                       (if-not is-dark? 
                         ($ svg/sun)
                         ($ svg/moon))))))


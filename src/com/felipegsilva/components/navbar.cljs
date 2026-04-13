(ns com.felipegsilva.components.navbar
  (:require
   [com.felipegsilva.components.svg :as svg]
   [helix.core :refer [defnc $]]
   [refx.alpha :as refx]
   [helix.dom :as d]))

(defnc navbar [{:keys [is-dark?]}]
  (d/nav {:class (str "sticky top-0 z-50 w-full flex justify-between items-center px-8 py-4 text-sm border-b "
                      (if is-dark?
                        "bg-black text-gray-400 border-gray-800"
                        "bg-gray-50 text-gray-600 border-gray-200"))}
         (d/div {:class "flex items-center space-x-6"}
                (d/a {:href "#home"
                      :class "font-bold hover:text-yellow-600 transition-all duration-75"}
                     "~/")
                (d/a {:href "#experience"
                      :class "hidden md:inline hover:text-yellow-600 transition-all duration-75"}
                     "experience")
                (d/a {:href "#projects"
                      :class "hidden md:inline hover:text-yellow-600 transition-all duration-75"}
                     "projects")
                (d/a {:href "#education"
                      :class "hidden md:inline hover:text-yellow-600 transition-all duration-75"}
                     "education")
                (d/a {:href "#skills"
                      :class "hidden md:inline hover:text-yellow-600 transition-all duration-75"}
                     "skills"))
         (d/button {:on-click #(refx/dispatch-sync [:app/set-theme (if is-dark? "light" "dark")])
                    :class (str "transition-all duration-125 hover:scale-125 "
                                (if is-dark?
                                  "hover:text-yellow-600"
                                  "hover:text-slate-600"))}
                   (if is-dark?
                     ($ svg/sun)
                     ($ svg/moon)))))

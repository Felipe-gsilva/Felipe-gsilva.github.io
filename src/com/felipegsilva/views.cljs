(ns com.felipegsilva.views
  (:require
   [com.felipegsilva.components.app :refer [app]]
   [com.felipegsilva.components.navbar :refer [navbar]]
   [com.felipegsilva.components.footer :refer [footer]]
   [com.felipegsilva.components.experience :refer [experience]]
   [com.felipegsilva.components.education :refer [education]]
   [com.felipegsilva.components.projects :refer [projects]]
   [com.felipegsilva.components.skills :refer [skills]]
   [helix.core :refer [defnc $ <>]]
   [helix.dom :as d]
   [helix.hooks :as hooks]
   [refx.alpha :as refx]))

(defnc home
  "home page" []
  (let [theme (refx/use-sub [:app/theme])
        dark? (= theme "dark")]

    (hooks/use-effect
      :once
      (let [stored-theme (or (.. js/localStorage (getItem "theme"))
                             "dark")]
        (refx/dispatch-sync [:app/set-theme stored-theme])))

    (hooks/use-effect
      [theme]
      (.. js/localStorage (setItem "theme" theme))
      (let [class-list (.. js/document -documentElement -classList)]
        (if (= theme "dark")
          (.add class-list "dark")
          (.remove class-list "dark"))))

    (<>
     (d/div {:class (str "min-h-screen w-screen font-mono "
                         "flex flex-col items-center duration-125 transition-all "
                         (if dark?
                           "bg-black text-white"
                           "bg-gray-50 text-black"))}
            ($ navbar {:is-dark? dark?})
            (d/div {:class "flex flex-col w-full md:w-3/4 flex-1 px-4 md:px-0"}
                   ($ app {:is-dark? dark?})
                   ($ experience {:is-dark? dark?})
                   ($ projects {:is-dark? dark?})
                   ($ education {:is-dark? dark?})
                   ($ skills {:is-dark? dark?}))
            ($ footer)))))

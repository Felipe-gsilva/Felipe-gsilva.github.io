(ns com.felipegsilva.views
  (:require
   [com.felipegsilva.components.app :refer [app]]
   [com.felipegsilva.components.navbar :refer [navbar]]
   [com.felipegsilva.components.footer :refer [footer]]
   [helix.core :refer [defnc $ <>]]
   [helix.dom :as d]
   [helix.hooks :as hooks]
   [refx.alpha :as refx]))

(defnc home
  "home page" []
  (let [theme (refx/use-sub [:app/theme])]
    (hooks/use-effect
      []
      (let [stored-theme (or (.. js/localStorage (getItem "theme"))
                             "light")]
        (refx/dispatch-sync [:app/set-theme stored-theme])))

    (hooks/use-effect
      [theme]
      (.. js/localStorage (setItem "theme" theme))
      (let [class-list (.. js/document -documentElement -classList)]
        (if (= theme "dark")
          (.add class-list "dark")
          (.remove class-list "dark"))))

    (<>
     (d/div {:class (str "min-h-dvh lg:h-screen w-screen bg-gray-50 dark:bg-gray-800 "
                         "font-mono overflow-hidden flex flex-col items-center ")}
            (d/div {:class "flex flex-col w-full md:w-3/4 flex-1"}
                   ($ navbar {:is-dark? (= theme "dark")})
                   ($ app)
                   ($ footer))))))

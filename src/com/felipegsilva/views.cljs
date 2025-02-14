(ns com.felipegsilva.views
  (:require
   [com.felipegsilva.components.app :refer [app]]
   [com.felipegsilva.components.navbar :refer [navbar]]
   [com.felipegsilva.components.footer :refer [footer]]
   [helix.core :refer [defnc $ <>]]
   [helix.dom :as d]
   [helix.hooks :as hooks]))

(defnc home
  "home page" []
  (let [[is-dark? set-dark] (hooks/use-state (= (.. js/localStorage (getItem "theme")) "dark"))
        toggle-dark #(let [new-theme (if is-dark? "light" "dark")]
                      (set-dark (not is-dark?))
                      (.. js/localStorage (setItem "theme" new-theme)))]
    (hooks/use-effect [is-dark?]
      (.. js/document -documentElement -classList
          (toggle "dark" is-dark?)))
    (<>
     (d/div {:class (str "min-h-dvh lg:h-screen w-screen bg-gray-50 flex flex-col items-center font-mono overflow-hidden "
                         "dark:bg-gray-800 dark:text-gray-100")}
             (d/div {:class "flex flex-col w-full md:w-3/4 flex-1"}
                    ($ navbar {:toggle-dark toggle-dark :is-dark? is-dark?})
                    ($ app)
                    #_($ footer))))))


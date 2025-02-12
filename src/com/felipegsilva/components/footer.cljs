(ns com.felipegsilva.components.footer
  (:require [helix.core :refer [defnc $ <>]]
            [helix.dom :as d]))

(defnc footer []
  (d/div {:class "w-full h-full flex flex-col justify-center items-center p-8 bg-white"}
         (d/div {:class " flex flex-row w-3/4 h-2/3 justify-center items-center space-x-6  space-y-8"}
                (d/p {:class "text-lg"}"Work in progress"))))

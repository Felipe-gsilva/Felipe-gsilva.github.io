(ns com.felipegsilva.components.footer
  (:require [helix.core :refer [defnc]]
            [helix.dom :as d]))

(defnc footer []
  (d/footer {:class "w-full flex flex-col justify-center items-center py-8 px-4 select-none border-t border-gray-800 dark:border-gray-800"}
            (d/p {:class "text-sm text-gray-500"}
                 "MIT License 2025 - Felipe Gomes da Silva")))

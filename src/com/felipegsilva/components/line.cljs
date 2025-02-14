(ns com.felipegsilva.components.line
  (:require [helix.core :refer [defnc $ <>]]
            [helix.dom :as d]))

(defnc line-break
  [] (d/div {:class "border-b border-gray-200 dark:border-gray-600"}))

(ns com.felipegsilva.components.blink
  (:require [helix.dom :as d]
            [helix.core :refer [defnc <> $]]))

(defnc g [] 
  (d/p {:class "mr-2 underline"}""))

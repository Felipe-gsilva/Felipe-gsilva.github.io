(ns com.felipegsilva.components.app
  (:require [helix.dom :as d]
            [helix.core :refer [defnc <> $]]
            [com.felipegsilva.components.card :as card]
            ))


(defnc main []
  (<> (d/div {:class "w-1/3 h-full bg-black"}
             (d/div {:class "flex align-center"} 
                    ($ card/card)))))

(ns com.felipegsilva.components.app
  (:require [helix.dom :as d]
            [helix.core :refer [defnc <> $]]
            [com.felipegsilva.components.blink :as blink]
            [com.felipegsilva.components.profile :as profile]
            ))


(defnc app []
  (<>
    ($ profile/pfp)
    (d/div {:class "w-max max-h-max m-4 font-fa"} 
           (d/span {:class "flex items-center justify-center"} 
                   ($ blink/g) 
                   (d/h1 {:class "text-4xl"}"Felipe Gomes da Silva") 
                   (d/div {:class "flex bg-bg1"}
                          (d/p {:class "pl-4 text-center "} "Curr: "))))
    (d/p {:class "m-8"} "C, C++, Clojure and Java")))

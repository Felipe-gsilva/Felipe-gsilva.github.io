(ns com.felipegsilva.components.card
  (:require [helix.dom :as d]
            [helix.core :refer [defnc <> $]]
            [com.felipegsilva.components.profile :as profile]
            ))


(defnc blink [] 
  (d/p {:class "mr-2 underline"} ">"))

(defnc card [] 
  ($ blink) 
  (d/span {:class "flex align-center justify-center"}
          (d/div {:class "w-128 h-full "} 
                 (d/div {:class "flex align-center justify-center"} 
                        ($ profile/pfp))
                 (d/div {:class ""} (d/h1 {:class "text-4xl"} "Felipe Gomes da Silva")
                        (d/div {:class "flex w-full "}
                               (d/p {:class "text-center items-stretch mr-2"} "Curr:")
                               (d/a {:target "_blank" :href "https://www.moclojer.com/"} "Moclojer"))
                        (d/p {:class ""} "C, C++, Clojure and Java")))))


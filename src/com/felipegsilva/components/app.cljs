(ns com.felipegsilva.components.app
  (:require
   [com.felipegsilva.components.line :refer [line-break]]
   [com.felipegsilva.components.svg :as svg]
   [helix.dom :as d]
   [helix.core :refer [defnc <> $]]))

(defnc blink []
  (d/p  ">"))

(defnc header []
  (d/div {:class "w-full h-full flex flex-col justify-center items-center p-8"}
         (d/div {:class " flex flex-row w-3/4 h-1/3 justify-center items-center space-x-6  space-y-8"}
                (d/div {:class "h-full flex flex-col justify-center"}
                       (d/div {:class "py-4"}
                              (d/span {:class "flex space-x-2 text-6xl mb-2 "}
                                      ($ blink)
                                      (d/h1  "Felipe Gomes da Silva"))
                              (d/div {:class "flex w-full "}
                                     (d/span {:class "flex space-x-2"}
                                             (d/p {:class "italic"} "product engineer at ")
                                             (d/a {:class "hover:underline"
                                                   :target "_blank" :href "https://www.moclojer.com/"} " Moclojer")
                                             (d/div {:class ""} "|")

                                             (d/p {:class "italic"} "C, C++, Clojure and Java"))))

                       ($ line-break)
                       (d/p {:class "text-xl  py-4 "} " \"I am now really into on some low level programming, clojure, and some graphical low level applications.")
                       (d/div {:class " flex flex-row h-1/3 justify-start items-center space-x-6 "}
                              (d/span {:class "space-x-4"}
                                      (d/button {:class "p-2 border rounded-lg border-black text-black hover:border-yellow-600 hover:bg-white hover:text-yellow-600 transition-all duration-75"}
                                                (d/span {:class "flex space-x-2"}
                                                        (d/a {:href "https://github.com/Felipe-gsilva"
                                                              :target "_blank"} "github")
                                                        ($ svg/github)))
                                      (d/button {:class "hover:underline rounded-lg border-black w-20 hover:text-yellow-600 transition-all duration-75"}
                                                (d/span {:class "flex space-x-2 justify-center items-center"}
                                                        (d/a
                                                         {:href "https://www.linkedin.com/in/felipe-gsilva/"
                                                          :target "_blank"}
                                                         "linkedin")))))))))



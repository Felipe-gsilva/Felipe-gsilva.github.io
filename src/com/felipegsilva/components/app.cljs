(ns com.felipegsilva.components.app
  (:require
   [com.felipegsilva.components.line :refer [line-break]]
   [com.felipegsilva.components.svg :as svg]
   [helix.dom :as d]
   [helix.core :refer [defnc <> $]]))

(defnc blink []
  (d/p {:class "hidden md:flex"} ">"))

(defnc app [{:keys [is-dark?]}]
  (d/div {:id "Header"
          :class "w-full h-full flex flex-col justify-center items-center p-8 transition-all duration-75 "}
         (d/div {:class "flex flex-row md:h-2/3 h-1/3 justify-center items-center md:space-y-8 space-y-16 "}
                (d/div {:class "h-full flex flex-col justify-center"}
                       (d/div {:class "py-4"}
                              (d/span {:class "flex md:space-x-2 md:text-6xl text-5xl mb-2 "}
                                      ($ blink)
                                      (d/h1   "Felipe Gomes da Silva"))
                              (d/div {:class "flex w-full "}
                                     (d/span {:class "flex md:space-x-2 md:flex-row flex-col md:items-center"}
                                             (d/span {:class "flex space-x-2 md:text-md text-xl"}
                                                     (d/p {:class "italic"} "product engineer at "
                                                          (d/a {:class "underline transition-all duration-75 hover:text-yellow-600"
                                                                :target "_blank" :href "https://www.moclojer.com/"} " Moclojer")))

                                             (d/div {:class "hidden lg:flex"} "|")
                                             (d/p {:class "italic"} "C, C++, Clojure and Java"))))

                       ($ line-break)

                       (d/span {:class "lg:text-xl text-2xl py-4 md:tracking-normal tracking-wide"}
                               (d/p
                                "Software engineer, not that good musicist and beatmaker, who loves low level programming and a rookie in the amazing world of lisp and clojure. Currently under a Computer Science degree at " (d/a {:class "underline hover:text-yellow-600 transition-all duration-75"
                                                                                                                                                                                                                                      :href "https://www2.unesp.br/"
                                                                                                                                                                                                                                      :target "_blank"} "Unesp")
                                ". I pretty much love my girlfriend, music, playing and wacthing soccer, working out, films and games. "))
                       (d/span {:class "lg:text-xl text-2xl py-4 md:tracking-normal tracking-wide"}
                               (d/p "For now, I'm working on open source solutions at my job, respecting my belief that software should be free, reproducable and, at all circunstances, built with love and not only by its later revenue."))

                       (d/div {:class " flex flex-row h-1/3 justify-start items-center md:space-x-6 "}
                              (d/span {:class "md:space-x-4"}
                                      (d/button {:class (str "p-2 border rounded-lg hover:border-yellow-600 hover:text-yellow-600 transition-all duration-75 "
                                                             (if is-dark?
                                                               "border-gray-100 hover:bg-gray-900 "
                                                               "border-black hover:bg-white "))}
                                                (d/span {:class "flex space-x-2"}
                                                        (d/a {:href "https://github.com/Felipe-gsilva"
                                                              :target "_blank"} "github")
                                                        ($ svg/github)))
                                      (d/button {:class "underline rounded-lg border-black p-4 hover:text-blue-600 transition-all duration-75"}
                                                (d/span {:class "flex justify-center items-center"}
                                                        (d/a
                                                         {:href "https://www.linkedin.com/in/felipe-gsilva/"
                                                          :target "_blank"}
                                                         "linkedin")))

                                      (d/button {:class "underline rounded-lg border-black hover:text-pink-600 transition-all duration-75"}
                                                (d/span {:class "flex justify-center items-center"}
                                                        (d/a
                                                         {:href "https://www.instagram.com/felipe.gsilva_/"
                                                          :target "_blank"}
                                                         "instagram")))))))))

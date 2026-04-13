(ns com.felipegsilva.components.app
  (:require
   [com.felipegsilva.components.line :refer [line-break]]
   [com.felipegsilva.components.svg :as svg]
   [helix.dom :as d]
   [helix.core :refer [defnc <>  $]]))

(defnc blink []
  (d/span {:class "hidden md:inline mr-3 select-none"} ">"))

(defnc app [{:keys [is-dark?]}]
  (d/section
   {:id "home"
    :class "w-full min-h-screen flex flex-col justify-center py-16"}
   (d/div
    {:class "flex flex-col space-y-6"}

    ;; Name + roles
    (d/div {}
           (d/h1 {:class "flex items-center md:text-6xl text-4xl font-bold mb-4"}
                 ($ blink)
                 "Felipe Gomes da Silva")
           (d/div {:class (str "flex flex-col md:flex-row md:items-center md:space-x-3 "
                               "text-sm md:text-base space-y-1 md:space-y-0 "
                               (if is-dark? "text-gray-400" "text-gray-500"))}
                  (d/span {:class "italic"} "Full Stack Developer @ Vinellu")
                  (d/span {:class "hidden md:inline"} "·")
                  (d/span {:class "italic"} "CS Undergraduate @ Unesp")
                  (d/span {:class "hidden md:inline"} "·")
                  (d/span {} "Sao Jose do Rio Preto, SP, Brasil")))

    ;; Divider
    ($ line-break)

    ;; Bio
    (d/p {:class "text-base md:text-lg leading-relaxed max-w-2xl"}
         "Software engineer with a proven track record in high-performance systems and scalable architectures. "
         "Strong foundation in performance optimization, low-level computing, and concurrency. "
         "Academic researcher in computer vision and machine learning.")

    ;; Links
    (d/div {:class "flex flex-row flex-wrap gap-3 pt-2"}

           ;; GitHub
           (d/a {:href "https://github.com/Felipe-gsilva"
                 :target "_blank"
                 :class (str "flex items-center gap-2 px-3 py-2 border rounded-lg text-sm "
                             "hover:border-yellow-600 hover:text-yellow-600 transition-all duration-75 "
                             (if is-dark? "border-gray-700" "border-gray-300"))}
                ($ svg/github)
                (d/span "GitHub"))

           ;; LinkedIn
           (d/a {:href "https://www.linkedin.com/in/felipe-gsilva/"
                 :target "_blank"
                 :class (str "flex items-center gap-2 px-3 py-2 border rounded-lg text-sm "
                             "hover:border-blue-500 hover:text-blue-500 transition-all duration-75 "
                             (if is-dark? "border-gray-700" "border-gray-300"))}
                ($ svg/linkedin)
                (d/span "LinkedIn"))

           ;; Email
           (d/a {:href "mailto:felipe.gsilva@protonmail.com"
                 :class (str "flex items-center gap-2 px-3 py-2 border rounded-lg text-sm "
                             "hover:border-yellow-600 hover:text-yellow-600 transition-all duration-75 "
                             (if is-dark? "border-gray-700" "border-gray-300"))}
                (d/span "Email"))))))
